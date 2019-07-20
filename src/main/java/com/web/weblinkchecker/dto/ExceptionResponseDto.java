package com.web.weblinkchecker.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ExceptionResponseDto {

    private final HttpStatus status;
    private final String message;

}
