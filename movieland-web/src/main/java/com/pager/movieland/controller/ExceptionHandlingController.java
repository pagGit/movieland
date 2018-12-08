package com.pager.movieland.controller;

import com.pager.movieland.service.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionHandlingController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect user or password.")
    public void handleAuthenticationException(AuthenticationException e) {
        logger.error("AuthenticationException: {}", e);

    }
}
