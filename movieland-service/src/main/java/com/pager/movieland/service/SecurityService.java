package com.pager.movieland.service;

import com.pager.movieland.entity.Session;

import com.pager.movieland.service.exception.AuthenticationException;

public interface SecurityService {
    Session getSession(String uuid);

    Session auth(String email, String password) throws AuthenticationException;

    void logout(String uuid);
}
