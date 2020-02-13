package com.jyami.dancingstar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyami.dancingstar.exception.PythonException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jyami on 2020/02/13
 */
@Service
@RequiredArgsConstructor
public class DancingService {

    private final NcloudAPIService ncloudAPIService;
    private final PythonExeService pythonExeService;

    public String getOneImageScore(String originFile, String userFile){

        JsonNode originPoseResult = ncloudAPIService.callPoseEstimation(originFile);
        JsonNode userPoseResult = ncloudAPIService.callPoseEstimation(userFile);
        JsonNode originFaceResult = ncloudAPIService.callFaceRecognition(originFile);
        JsonNode userFaceResult = ncloudAPIService.callFaceRecognition(userFile);

        try {
            return pythonExeService.getOneImageScore(originPoseResult, userPoseResult, originFaceResult, userFaceResult);
        } catch (IOException e) {
            throw new PythonException("python execute exception" + e.getMessage());
        }

    }
}
