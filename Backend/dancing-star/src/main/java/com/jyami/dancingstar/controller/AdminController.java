package com.jyami.dancingstar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.jyami.dancingstar.domain.Dancing;
import com.jyami.dancingstar.domain.DancingSpot;
import com.jyami.dancingstar.dto.ResponseDto;
import com.jyami.dancingstar.dto.dacing.SaveOriginDanceReqDto;
import com.jyami.dancingstar.service.DancingService;
import com.jyami.dancingstar.service.NcloudAPIService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final NcloudAPIService ncloudAPIService;
    private final DancingService dancingService;

    @PostMapping("newDancing")
    public ResponseEntity saveServiceDancingVideo(@RequestBody SaveOriginDanceReqDto saveOriginDanceReqDto) throws IOException {
        Dancing dancing = dancingService.saveDancingDataFromVideo(saveOriginDanceReqDto);//dancing.mp4;
        ResponseDto<Dancing> responseDto = ResponseDto.of(HttpStatus.OK, saveOriginDanceReqDto.getTitle() + "DB 저장 완료", dancing);
        return ResponseEntity.ok().body(responseDto);
    }


    //TODO : DEL
    @GetMapping("test")
    public ResponseEntity getPose() {
        JsonNode face = ncloudAPIService.callFaceRecognition("static/dance.jpeg");
        JsonNode pose = ncloudAPIService.callPoseEstimation("static/dance.jpeg");

        return ResponseEntity.ok(face.toString() + pose.toString());
    }

}
