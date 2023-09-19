package com.villacamp.hn.excellence.exception;

import com.villacamp.hn.excellence.model.ApiError;
import io.jsonwebtoken.ExpiredJwtException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleNoSuchElementException(MethodArgumentNotValidException ex, WebRequest webRequest) {
        var servletWebRequest = (ServletWebRequest) webRequest;
        return new ResponseEntity<>(
                ApiError.builder()
                        .message(ex.getMessage())
                        .path(servletWebRequest.getRequest().getServletPath())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNoFoundException(NotFoundException ex, WebRequest webRequest) {
        var servletWebRequest = (ServletWebRequest) webRequest;
        return new ResponseEntity<>(
                ApiError.builder()
                        .message(ex.getMessage())
                        .path(servletWebRequest.getRequest().getServletPath())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<ApiError> handleInvalidLoginException(InvalidLoginException ex, WebRequest webRequest) {
        var servletWebRequest = (ServletWebRequest) webRequest;
        return new ResponseEntity<>(
                ApiError.builder()
                        .message(ex.getMessage())
                        .path(servletWebRequest.getRequest().getServletPath())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ApiError> handlePSQLException(PSQLException ex, WebRequest webRequest) {
        var servletWebRequest = (ServletWebRequest) webRequest;
        return new ResponseEntity<>(
                ApiError.builder()
                        .message(ex.getMessage().split("Detail: ")[1])
                        .path(servletWebRequest.getRequest().getServletPath())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    //ToDo fix this expired exception when extracting claims
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiError> handleExpiredJwtException(ExpiredJwtException ex, WebRequest webRequest) {
        var servletWebRequest = (ServletWebRequest) webRequest;
        return new ResponseEntity<>(
                ApiError.builder()
                        .message(ex.getMessage())
                        .path(servletWebRequest.getRequest().getServletPath())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.FORBIDDEN);
    }
}
