package com.jyami.dancingstar.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jyami.dancingstar.domain.Dancing;
import com.jyami.dancingstar.domain.DancingSpot;
import com.jyami.dancingstar.dto.dacing.DanceScoreResDto;
import com.jyami.dancingstar.dto.dacing.SaveDanceReqDto;
import com.jyami.dancingstar.dto.dacing.SaveOriginDanceReqDto;
import com.jyami.dancingstar.exception.DancingException;
import com.jyami.dancingstar.exception.PythonException;
import com.jyami.dancingstar.repository.DancingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jyami.dancingstar.parsing.DancingParsing.*;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

/**
 * Created by jyami on 2020/02/13
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DancingService {

    private final NcloudAPIService ncloudAPIService;
    private final PythonExeService pythonExeService;
    private final DancingRepository dancingRepository;

    private static String USER_VIDEO = "src/main/resources/user_video/";

    public DanceScoreResDto getDancingScore(MultipartFile file, String nickName, String dancingId) throws IOException {

        Dancing originalDancing = dancingRepository.findById(dancingId)
                .orElseThrow(() -> new DancingException("없는 dancingId 입니다."));

        String filePath = saveLocalFile(file, nickName);

        SaveDanceReqDto saveDanceReqDto = SaveDanceReqDto.builder()
                .frameNumbers(originalDancing.getFrameNumbers())
                .videoPath(filePath)
                .build();

        Dancing userDacing = getDancingDataFromVideo(saveDanceReqDto);

        Integer accuracyScoreForCompare = getAccuracyScoreForCompare(userDacing, originalDancing);
        Integer consistencyScoreForCompare = getConsistencyScoreForCompare(userDacing, originalDancing);

        return getAllScore(accuracyScoreForCompare, consistencyScoreForCompare);
    }

    private DanceScoreResDto getAllScore(int acc, int con){
        return DanceScoreResDto.builder()
                .accuracyScore(acc)
                .consistencyScore(con)
                .totalScore(acc + con)
                .gazeScore(0)
                .faceScore(0)
                .comboScore(0)
                .build();
    }

    public String saveLocalFile(MultipartFile file, String nickName) throws IOException {
        log.info(file.toString());
        InputStream inputStream = file.getInputStream();

        File localSaveFile = new File(USER_VIDEO + nickName + LocalTime.now().toString()+".mp4");
        copyInputStreamToFile(inputStream, localSaveFile);
        log.info(localSaveFile.getAbsolutePath());
        return localSaveFile.getPath();
    }

    private Integer getAccuracyScoreForCompare(Dancing userFile, Dancing originFile){
        List<DancingSpot> userAccuracySpot = userFile.getAccuracySpot();
        List<DancingSpot> originAccuracySpot = originFile.getAccuracySpot();

        List<String> accuracyList = new ArrayList<>();

        for(int i =0; i<originAccuracySpot.size(); i++){
            DancingSpot dancingSpot = userAccuracySpot.get(i);
            DancingSpot dancingSpot1 = originAccuracySpot.get(i);
            accuracyList.add(getScoreForCompare(dancingSpot, dancingSpot1));
        }

        return getTotalScore(accuracyList);
    }

    private Integer getConsistencyScoreForCompare(Dancing userFile, Dancing originFile){
        List<DancingSpot> userConsistencySpot = userFile.getConsistencySpot();
        List<DancingSpot> originConsistencySpot = originFile.getConsistencySpot();

        List<String> consistencyList = new ArrayList<>();

        for(int i =0; i<originConsistencySpot.size(); i++){
            DancingSpot dancingSpot = userConsistencySpot.get(i);
            DancingSpot dancingSpot1 = originConsistencySpot.get(i);
            consistencyList.add(getScoreForCompare(dancingSpot, dancingSpot1));
        }

        return  getTotalScore(consistencyList);
    }


    private String getScoreForCompare(DancingSpot user, DancingSpot origin){
        try {
            return pythonExeService.getOneImageCompareScore(origin.getPoseSpots(), user.getPoseSpots(),
                    origin.getFaceSpots(), user.getFaceSpots());
        } catch (IOException e) {
            throw new PythonException("python execute exception" + e.getMessage());
        }
    }

    /**
     *  origin dance 저장
     */

    public Dancing saveDancingDataFromVideo(SaveOriginDanceReqDto saveOriginDanceReqDto) throws IOException {
        return dancingRepository.save(getDancingDataFromVideo(saveOriginDanceReqDto));
    }

    public Dancing getDancingDataFromVideo(SaveDanceReqDto saveDanceReqDto) throws IOException {
        String originVideo = saveDanceReqDto.getVideoPath();
        String frameNumbers = saveDanceReqDto.getFrameNumbers();

        List<DancingSpot> allAccuracyImageScore = getAllAccuracyImageScore(originVideo, frameNumbers);
        List<DancingSpot> allConsistencyImageScore = getAllConsistencyImageScore(originVideo);

        return saveDanceReqDto.toDomain(allConsistencyImageScore, allAccuracyImageScore);
    }

    private List<DancingSpot> getAllAccuracyImageScore(String originVideo, String frameNumbers) throws IOException {
        String imagesFromVideo = pythonExeService.getImagesFromVideo(originVideo, frameNumbers);// image 파일들 생성
        List<String> strings = stringToStringList(imagesFromVideo);
        return strings.stream()
                .map(t -> getOriginDanceData(t, getTimeFromPath(t)))
                .collect(Collectors.toList());
    }

    private List<DancingSpot> getAllConsistencyImageScore(String originVideo) throws IOException {
        String imagesFromVideo = pythonExeService.getImagesFromVideo(originVideo); // image 파일들 생성
        List<String> strings = stringToStringList(imagesFromVideo);
        return strings.stream()
                .map(t -> getOriginDanceData(t, getTimeFromPath(t)))
                .collect(Collectors.toList());
    }

    public DancingSpot getOriginDanceData(String originFile, String time){

        JsonNode originPoseResult = ncloudAPIService.callPoseEstimation(originFile);
        JsonNode originFaceResult = ncloudAPIService.callFaceRecognition(originFile);

        return DancingSpot.builder()
                .faceSpots(originFaceResult)
                .poseSpots(originPoseResult)
                .time(time)
                .build();
    }
}
