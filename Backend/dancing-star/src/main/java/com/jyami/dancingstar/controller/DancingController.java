package com.jyami.dancingstar.controller;


import com.jyami.dancingstar.domain.Dancing;
import com.jyami.dancingstar.dto.ResponseDto;
import com.jyami.dancingstar.dto.dacing.DanceScoreResDto;
import com.jyami.dancingstar.service.DancingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class DancingController {

    private final DancingService dancingService;

    @RequestMapping(path = "/score", method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity testFileLocalSave(
            @RequestParam("file") MultipartFile file, @RequestParam("nickName") String nickName,
            @RequestParam("dancingId") String dancingId) throws IOException {

        String s = dancingService.saveLocalFile(file, nickName);
        return ResponseEntity.ok().body(s);
    }

    @RequestMapping(path = "/score", method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity getUserScore(
            @RequestParam("file") MultipartFile file, @RequestParam("nickName") String nickName,
            @RequestParam("dancingId") String dancingId) throws IOException {

        DanceScoreResDto dancingScore = dancingService.getDancingScore(file, nickName, dancingId);

        ResponseDto<DanceScoreResDto> score = ResponseDto.of(HttpStatus.OK, "score 계산 완료", dancingScore);
        return ResponseEntity.ok().body(score);
    }

}
