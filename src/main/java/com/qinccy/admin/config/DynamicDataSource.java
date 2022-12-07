package com.qinccy.admin.config;

import com.qinccy.admin.holder.DynamicDataSourceContextHolder;
import com.qinccy.admin.mapper.AuthMapper;
import com.qinccy.admin.provider.DynamicDataSourceProvider;
import com.qinccy.admin.service.AuthService;
import com.qinccy.admin.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    DynamicDataSourceProvider dynamicDataSourceProvider;

    public DynamicDataSource(DynamicDataSourceProvider dynamicDataSourceProvider) {
        this.dynamicDataSourceProvider = dynamicDataSourceProvider;
        Map<Object, Object> targetDataSources = new HashMap<>(dynamicDataSourceProvider.loadDataSources());
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(dynamicDataSourceProvider.loadDataSources().get(DynamicDataSourceProvider.DEFAULT_DATASOURCE));
        super.afterPropertiesSet();
    }

    public void refresh() {
        //更改为从数据库查询
        AuthService bean = SpringUtils.getBean(AuthService.class);
        Map<Object, Object> targetDataSources = new HashMap<>(dynamicDataSourceProvider.reloadDataSources(bean));
        DynamicDataSource dataSource = SpringUtils.getBean(DynamicDataSource.class);
        dataSource.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
