package com.wl.lch.core;

import com.wl.lch.entity.Subscriber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubscriberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subscriber record);

    int insertSelective(Subscriber record);

    Subscriber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subscriber record);

    int updateByPrimaryKey(Subscriber record);

    public Subscriber selectByAccount(@Param("account") String Account);

    public Subscriber selectByName(@Param("name") String name);

}