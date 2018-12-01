package com.pager.movieland.service;

import com.pager.movieland.dao.jdbc.JdbcUserDao;
import com.pager.movieland.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DefaultUserServiceTest {
    @Test
    public void getById() {
        JdbcUserDao jdbcUserDao = mock(JdbcUserDao.class);

        User expectedUser = new User(2, "User2");

        DefaultUserService userService = new DefaultUserService();
        userService.setUserDao(jdbcUserDao);

        when(jdbcUserDao.getById(2)).thenReturn(expectedUser);

        User actualUser = userService.getById(2);
        assertEquals(expectedUser, actualUser);
        verify(jdbcUserDao, times(1)).getById(2);
    }

    @Test
    public void testEnrich() {
        JdbcUserDao jdbcUserDao = mock(JdbcUserDao.class);
        DefaultUserService userService = new DefaultUserService();
        userService.setUserDao(jdbcUserDao);

        User expectedUser = new User(2, "User2");
        User actualUser = new User(2);
        when(jdbcUserDao.getById(2)).thenReturn(expectedUser);

        userService.enrich(actualUser);

        assertEquals(expectedUser, actualUser);
        verify(jdbcUserDao, times(1)).getById(2);
    }
}
