package com.qinccy.admin.mapper;

import com.qinccy.admin.domain.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    /**
     * 查询全部
     */
    List<TestDTO> selectAll();

    /**
     * 查询单挑
     */
    List<TestDTO> selectOne();
}
