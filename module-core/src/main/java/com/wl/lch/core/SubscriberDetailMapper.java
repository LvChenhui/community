package com.wl.lch.core;

import com.wl.lch.entity.SubscriberDetail;

public interface SubscriberDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubscriberDetail record);

    int insertSelective(SubscriberDetail record);

    SubscriberDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubscriberDetail record);

    int updateByPrimaryKey(SubscriberDetail record);
}