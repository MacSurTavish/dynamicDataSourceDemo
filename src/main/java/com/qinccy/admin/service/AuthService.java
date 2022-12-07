package com.qinccy.admin.service;

import com.qinccy.admin.domain.AuthEntity;

import java.util.List;

public interface AuthService {

    /**
     * 查询全部
     */
    List<AuthEntity> selectAll();
}
