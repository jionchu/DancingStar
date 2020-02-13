package com.jyami.dancingstar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.jyami.dancingstar.dto.admin.SaveDanceReqDto;
import com.jyami.dancingstar.service.NcloudAPIService;
import com.jyami.dancingstar.service.PythonExeService;
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
    private final PythonExeService pythonExeService;

    @GetMapping("dancing/save")
    public ResponseEntity saveServiceDancingVideo() throws IOException {
        pythonExeService.getImagesFromVideo("dancing.mp4");
        return ResponseEntity.ok().build();
    }

    @GetMapping("test")
    public ResponseEntity getPose() {
        JsonNode face = ncloudAPIService.callFaceRecognition("static/dance.jpeg");
        JsonNode pose = ncloudAPIService.callPoseEstimation("static/dance.jpeg");
        return ResponseEntity.ok(face.toString() + pose.toString());
    }

}
