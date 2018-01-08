package com.wl.lch.core;

import com.wl.lch.entity.InformationImage;

public interface InformationImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InformationImage record);

    int insertSelective(InformationImage record);

    InformationImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InformationImage record);

    int updateByPrimaryKey(InformationImage record);
}