package com.jyami.dancingstar.controller;

import com.jyami.dancingstar.dto.admin.SaveDanceReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class AdminController {

    RestTemplate restTemplate;

    @PostMapping("dacing/save")
    public ResponseEntity saveServiceDancingVideo(@RequestBody SaveDanceReqDto saveDanceReqDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping("test")
    public ResponseEntity getPose() {


        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
                .builder("form-data")
                .name("file")
                .filename("dance.jpeg")
                .build();
        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(fileMap);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileEntity);

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(body);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://naveropenapi.apigw.ntruss.com/vision-pose/v1/estimate",
                    HttpMethod.POST,
                    requestEntity,
                    String.class);


        return ResponseEntity.ok().build();
    }
}
