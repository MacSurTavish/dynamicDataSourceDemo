package com.qinccy.admin.service.impl;

import com.qinccy.admin.annotation.DataSource;
import com.qinccy.admin.domain.TestDTO;
import com.qinccy.admin.mapper.TestMapper;
import com.qinccy.admin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    @DataSource("slave")
    public List<TestDTO> selectAll() {
        return testMapper.selectAll();
    }

    @Override
    @DataSource("other")
    public List<TestDTO> selectOne(String testId) {
        return testMapper.selectOne();
    }
}
