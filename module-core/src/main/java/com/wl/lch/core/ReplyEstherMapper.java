package com.wl.lch.core;

import com.wl.lch.entity.ReplyEsther;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyEstherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyEsther record);

    int insertSelective(ReplyEsther record);

    ReplyEsther selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyEsther record);

    int updateByPrimaryKeyWithBLOBs(ReplyEsther record);

    int updateByPrimaryKey(ReplyEsther record);

    public List<ReplyEsther> selectByPostId(@Param("posts_id") Integer posts_id,@Param("start") Integer start,@Param("number") Integer number);
}