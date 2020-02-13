package com.jyami.dancingstar.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.jyami.dancingstar.service.DancingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
@RequiredArgsConstructor
public class DancingController {

    private final DancingService dancingService;

    @GetMapping("/oneImage/score")
    public ResponseEntity getOneImageScore() {

        String originFile = "images/original.jpeg";
        String userFile = "images/user.jpeg";
        String oneImageScore = dancingService.getOneImageScore(originFile, userFile);

        return ResponseEntity.ok(oneImageScore);
    }

}
