package com.qinccy.admin.service.impl;

import com.qinccy.admin.annotation.DataSource;
import com.qinccy.admin.domain.AuthEntity;
import com.qinccy.admin.mapper.AuthMapper;
import com.qinccy.admin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Override
    @DataSource()
    public List<AuthEntity> selectAll() {
        return authMapper.selectAll();
    }
}
