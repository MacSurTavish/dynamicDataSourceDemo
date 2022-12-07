package com.qinccy.admin.provider;

import com.qinccy.admin.mapper.AuthMapper;
import com.qinccy.admin.service.AuthService;

import javax.sql.DataSource;
import java.util.Map;

public interface DynamicDataSourceProvider {
    String DEFAULT_DATASOURCE = "master";
    /**
     * 加载所有的数据源
     * @return 所有的数据源
     */
    Map<String, DataSource> loadDataSources();

    /**
     * 重新加载所有的数据源
     * @return 所有的数据源
     */
    Map<String, DataSource> reloadDataSources(AuthService authService);

    /**
     * 新增数据源
     * @param name 数据源名称
     * @param newDataSource 数据源信息
     * @return 新的数据源列表
     */
    Map<String, DataSource> addDataSources(String name, Map<String, String> newDataSource);
}
