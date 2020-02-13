package com.jyami.dancingstar.controller;

import com.jyami.dancingstar.dto.admin.SaveDanceReqDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final RestTemplate restTemplate;

    @PostMapping("dacing/save")
    public ResponseEntity saveServiceDancingVideo(@RequestBody SaveDanceReqDto saveDanceReqDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping("test")
    public ResponseEntity getPose() throws IOException {

        HttpHeaders httpHeaders = new HttpHeaders();

        URL resource = this.getClass().getClassLoader().getResource("static/dance.jpeg");
        byte[] fileContent = Files.readAllBytes(new File(resource.getFile()).toPath());

        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition  contentDisposition = ContentDisposition.builder("form-data")
                .name("file")
                .filename("dance.jpeg")
                .build();

        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        fileMap.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");
        HttpEntity<byte[]> entity = new HttpEntity<>(fileContent, fileMap);
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("image", entity);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, httpHeaders);

        restTemplate.postForEntity(
                "https://naveropenapi.apigw.ntruss.com/vision-pose/v1/estimate",
                requestEntity,
                Map.class);

        return ResponseEntity.ok().build();
    }
}
