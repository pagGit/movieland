package com.pager.movieland.service;

import com.pager.movieland.entity.Session;
import com.pager.movieland.entity.User;
import com.pager.movieland.service.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DefaultSecurityService implements SecurityService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, Session> sessions = new ConcurrentHashMap<>();
    private UserService userService;

    @Value("${security.sessionMaxDurationInSeconds}")
    private Long maxSessionDurationInSeconds;

    @Override
    public Session getSession(String uuid) {
        Session session = sessions.get(uuid);
        if (session.getExpireDate().isBefore(LocalDateTime.now())) {
            sessions.remove(session);
            return null;
        } else {
            return session;
        }
    }

    @Override
    public Session auth(String email, String password) throws AuthenticationException {

        User user = Optional.ofNullable(userService.getByEmail(email, password)).orElseThrow(() -> new AuthenticationException("Incorrect email or password for user - " + email));
        Session session = new Session();
        session.setUser(user);
        String uuid = UUID.randomUUID().toString();
        session.setUuid(uuid);
        session.setExpireDate(LocalDateTime.now().plusSeconds(maxSessionDurationInSeconds));
        sessions.put(uuid, session);

        return session;
    }

    @Scheduled(fixedDelayString = "${scheduler.fixedDelay}", initialDelayString = "${scheduler.initialDelay}")
    public void invalidateCache() {
        for (Map.Entry<String, Session> entry : sessions.entrySet()) {
            if (entry.getValue().getExpireDate().isBefore(LocalDateTime.now())) {
                String uuid = entry.getKey();
                logout(uuid);
                logger.info("Invalidated Cache for uuid {}", uuid);
            }
        }
    }

    @Override
    public void logout(String uuid) {
        if (sessions.remove(uuid) != null) {
            logger.info("Session [uuid = {}] was removed", uuid);
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
