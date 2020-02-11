package com.jyami.dancingstar.controller;

import com.jyami.dancingstar.dto.admin.SaveDanceReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jyami on 2020/02/11
 */
@RestController
public class AdminController {

    @PostMapping("dacing/save")
    public ResponseEntity saveServiceDancingVideo(@RequestBody SaveDanceReqDto saveDanceReqDto){
        return ResponseEntity.ok().build();
    }
}
