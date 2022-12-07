package com.qinccy.admin.domain;

import lombok.Data;

@Data
public class AuthEntity {
    /**
     * id
     */
    private String id;

    /**
     * id
     */
    private String userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 地址
     */
    private String url;
}
