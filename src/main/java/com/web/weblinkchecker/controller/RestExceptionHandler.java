package com.web.weblinkchecker.controller;

import com.web.weblinkchecker.dto.ExceptionResponseDto;
import com.web.weblinkchecker.exception.NotFoundByIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler implements AsyncUncaughtExceptionHandler {

    @ExceptionHandler(NotFoundByIdException.class)
    public ResponseEntity<ExceptionResponseDto> handleNotFoundByIdException(NotFoundByIdException ex) {
        log.error("NotFoundByIdException exception ('{}')", ex.getMessage());

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(WebExchangeBindException ex) {
        log.error("WebExchangeBindException exception ('{}')", ex.getMessage());

        BindingResult result = ex.getBindingResult();
        Map<String, String> errors = result.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> fieldError.getDefaultMessage() != null
                                ? fieldError.getDefaultMessage()
                                : "default message missing"
                ));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("Uncaught exception ('{}')", ex.getMessage());
    }

}
