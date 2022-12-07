package com.qinccy.admin.service;

import com.qinccy.admin.domain.TestDTO;

import java.util.List;

public interface TestService {

    /**
     * 查询全部
     */
    List<TestDTO> selectAll();

    /**
     * 查询单挑
     */
    List<TestDTO> selectOne(String testId);
}
