package com.wl.lch.core;

import com.wl.lch.entity.NubbinTalk;
import com.wl.lch.entity.NubbinTalkKey;

public interface NubbinTalkMapper {
    int deleteByPrimaryKey(NubbinTalkKey key);

    int insert(NubbinTalk record);

    int insertSelective(NubbinTalk record);

    NubbinTalk selectByPrimaryKey(NubbinTalkKey key);

    int updateByPrimaryKeySelective(NubbinTalk record);

    int updateByPrimaryKeyWithBLOBs(NubbinTalk record);

    int updateByPrimaryKey(NubbinTalk record);
}