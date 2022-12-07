package com.qinccy.admin.controller;

import com.qinccy.admin.domain.TestDTO;
import com.qinccy.admin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/selectAll")
    public List<TestDTO> selectAll() {
        return testService.selectAll();
    }

    @GetMapping("/selectOne/{testId}")
    public List<TestDTO> selectOne(@PathVariable String testId) {
        return testService.selectOne(testId);
    }
}
