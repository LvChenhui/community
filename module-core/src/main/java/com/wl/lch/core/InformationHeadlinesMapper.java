package com.wl.lch.core;

import com.wl.lch.entity.InformationHeadlines;

public interface InformationHeadlinesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InformationHeadlines record);

    int insertSelective(InformationHeadlines record);

    InformationHeadlines selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InformationHeadlines record);

    int updateByPrimaryKeyWithBLOBs(InformationHeadlines record);

    int updateByPrimaryKey(InformationHeadlines record);
}