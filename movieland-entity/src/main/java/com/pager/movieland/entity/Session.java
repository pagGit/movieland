package com.pager.movieland.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session {
    private String uuid;
    private User user;
    private LocalDateTime expireDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(uuid, session.uuid) &&
                Objects.equals(user, session.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, user);
    }

    @Override
    public String toString() {
        return "Session{" +
                "uuid='" + uuid + '\'' +
                ", user=" + user +
                '}';
    }
}
