package com.wl.lch.core;

import com.wl.lch.entity.PostEsther;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostEstherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostEsther record);

    int insertSelective(PostEsther record);

    PostEsther selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostEsther record);

    int updateByPrimaryKeyWithBLOBs(PostEsther record);

    int updateByPrimaryKey(PostEsther record);

    List<PostEsther> selectLimit(@Param("start") int start,@Param("number") int number);

    List<PostEsther> selectAll();

    int sumPageSize();
}