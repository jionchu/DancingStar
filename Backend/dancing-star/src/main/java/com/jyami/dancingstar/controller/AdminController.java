package com.jyami.dancingstar.controller;

import com.jyami.dancingstar.dto.admin.SaveDanceReqDto;
import com.jyami.dancingstar.service.PoseEstimationAPIService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final PoseEstimationAPIService poseEstimationAPIService;

    @PostMapping("dacing/save")
    public ResponseEntity saveServiceDancingVideo(@RequestBody SaveDanceReqDto saveDanceReqDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping("test")
    public ResponseEntity getPose() {
        String s = poseEstimationAPIService.callAPI("static/dance.jpeg");
        return ResponseEntity.ok(s);
    }
}
