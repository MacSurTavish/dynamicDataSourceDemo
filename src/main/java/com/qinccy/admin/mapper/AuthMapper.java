package com.qinccy.admin.mapper;

import com.qinccy.admin.domain.AuthEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {

    /**
     * 查询全部
     */
    List<AuthEntity> selectAll();
}
