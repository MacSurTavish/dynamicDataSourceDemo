package com.qinccy.admin.provider;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.qinccy.admin.config.DruidProperties;
import com.qinccy.admin.domain.AuthEntity;
import com.qinccy.admin.mapper.AuthMapper;
import com.qinccy.admin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class DynamicDataSourceProviderImp implements DynamicDataSourceProvider {
    @Autowired
    DruidProperties druidProperties;

    @Override
    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSource> ds = new HashMap<>(druidProperties.getDs().size());
        try {
            Map<String, Map<String, String>> map = druidProperties.getDs();
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(map.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Map<String, DataSource> reloadDataSources(AuthService authService) {
        Map<String, Map<String, String>> dsMap = druidProperties.getDs();
        List<AuthEntity> dataList = authService.selectAll();
        int size = dsMap.size() + dataList.size();

        //处理数据源数据
        Map<String, Map<String, String>> dataMap = new HashMap<>(dataList.size());
        for (AuthEntity authEntity : dataList) {
            Map<String, String> map = new HashMap<>();
            map.put("username", authEntity.getUsername());
            map.put("password", authEntity.getPassword());
            map.put("url", authEntity.getUrl());
            dataMap.put(authEntity.getUserId(), map);
        }

        Map<String, DataSource> ds = new HashMap<>(size);
        //动态加载，从数据库获取
        try {
            //配置文件的数据源
            Set<String> dsKeySet = dsMap.keySet();
            for (String s : dsKeySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(dsMap.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
            //数据库内的数据源
            Set<String> dataKeySet = dataMap.keySet();
            for (String s : dataKeySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(dataMap.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Map<String, DataSource> addDataSources(String name, Map<String, String> newDataSource) {
        Map<String, DataSource> ds = new HashMap<>(druidProperties.getDs().size());
        try {
            Map<String, Map<String, String>> map = druidProperties.getDs();
            map.put(name, newDataSource);
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(map.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
