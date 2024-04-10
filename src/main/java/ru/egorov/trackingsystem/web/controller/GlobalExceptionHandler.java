package ru.egorov.trackingsystem.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.egorov.trackingsystem.model.exception.MethodTrackTimeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodTrackTimeNotFoundException.class)
    public ResponseEntity<String> handleException(MethodTrackTimeNotFoundException e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.internalServerError()
                .body(e.getMessage());
    }
}
