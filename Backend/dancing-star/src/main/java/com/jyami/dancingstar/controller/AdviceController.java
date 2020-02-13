package com.jyami.dancingstar.controller;

import com.jyami.dancingstar.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * Created by jyami on 2020/02/13
 */
@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ResponseDto> handleIOException(IOException ex) {
        ex.printStackTrace();
        return ResponseEntity.ok() // 501
                .body(ResponseDto.of(HttpStatus.NOT_IMPLEMENTED, ""));
    }
}
