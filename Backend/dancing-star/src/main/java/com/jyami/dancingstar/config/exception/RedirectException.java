package com.jyami.dancingstar.config.exception;

/**
 * Created by jyami on 2020/02/13
 */
public class RedirectException extends RuntimeException {
    public RedirectException(String message) {
        super(message);
    }
}