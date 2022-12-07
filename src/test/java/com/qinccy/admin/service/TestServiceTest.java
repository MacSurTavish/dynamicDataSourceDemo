package com.qinccy.admin.service;

import com.qinccy.admin.domain.AuthEntity;
import com.qinccy.admin.domain.TestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class TestServiceTest {

    @Autowired
    TestService testService;

    @Autowired
    AuthService authService;

    @Test
    void selectAll() {
        List<TestDTO> testDTOS = testService.selectAll();
        System.out.println(testDTOS.toString());
    }

    @Test
    void selectAuth() {
        List<AuthEntity> map = authService.selectAll();
        System.out.println(map.toString());
    }
}