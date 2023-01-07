package com.example.practice66ezhikov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleException(BindException e) {
        StringBuilder sb = new StringBuilder();
        for (var error : e.getAllErrors()) {
            sb.append(error.getDefaultMessage()).append("\n");
        }
        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }
}
