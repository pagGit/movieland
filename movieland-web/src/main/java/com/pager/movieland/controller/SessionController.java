package com.pager.movieland.controller;

import com.pager.movieland.converter.DtoConverter;
import com.pager.movieland.entity.Session;
import com.pager.movieland.dto.UserLoginResponseDto;
import com.pager.movieland.entity.User;
import com.pager.movieland.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;


@RestController
public class SessionController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private SecurityService securityService;

    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) throws Throwable {
        logger.debug("[user = {}]", user);

        String email = user.getEmail();
        String password = user.getPassword();
        Session session;
        try {
            session = securityService.auth(email, password);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("User could not be authenticated: " + email).initCause(e);
        }
        if (session != null) {
            UserLoginResponseDto userLoginResponseDto = DtoConverter.convertToUserLoginResponseDto(session);
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(userLoginResponseDto);
            response.getWriter().flush();
            response.getWriter().close();

        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @DeleteMapping("/logout")
    void logout(@RequestHeader String uuid){
        securityService.logout(uuid);
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
