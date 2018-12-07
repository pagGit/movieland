package com.pager.movieland.converter;

import com.pager.movieland.dto.UserLoginResponseDto;
import com.pager.movieland.entity.Session;

public class DtoConverter {
    public static UserLoginResponseDto convertToUserLoginResponseDto(Session session) {
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        userLoginResponseDto.setUuid(session.getUuid());
        userLoginResponseDto.setNickName(session.getUser().getNickName());

        return userLoginResponseDto;

    }
}
