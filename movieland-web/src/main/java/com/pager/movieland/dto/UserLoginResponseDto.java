package com.pager.movieland.dto;

public class UserLoginResponseDto {
    private String uuid;
    private String nickName;

    public UserLoginResponseDto(String uuid, String nickName) {
        this.uuid = uuid;
        this.nickName = nickName;
    }

    public UserLoginResponseDto() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserLoginResponseDto{" +
                "uuid='" + uuid + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
