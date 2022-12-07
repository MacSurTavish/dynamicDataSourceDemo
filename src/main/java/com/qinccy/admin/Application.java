package com.qinccy.admin;

import com.qinccy.admin.config.DynamicDataSource;
import com.qinccy.admin.service.AuthService;
import com.qinccy.admin.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        DynamicDataSource bean = SpringUtils.getBean(DynamicDataSource.class);
        bean.refresh();
        System.out.println("启动成功");
    }
}
