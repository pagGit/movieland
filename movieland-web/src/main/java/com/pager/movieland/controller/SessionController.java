package com.pager.movieland.controller;

import com.pager.movieland.converter.DtoConverter;
import com.pager.movieland.entity.Session;
import com.pager.movieland.dto.UserLoginResponseDto;
import com.pager.movieland.entity.User;
import com.pager.movieland.service.SecurityService;
import com.pager.movieland.service.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private SecurityService securityService;

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody User user) throws AuthenticationException {
        logger.debug("[user = {}]", user);

        String email = user.getEmail();
        String password = user.getPassword();
        Session session = securityService.auth(email, password);
        UserLoginResponseDto userLoginResponseDto = DtoConverter.convertToUserLoginResponseDto(session);

        return userLoginResponseDto;
    }

    @DeleteMapping("/logout")
    void logout(@RequestHeader String uuid) {
        securityService.logout(uuid);
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
