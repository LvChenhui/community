package com.wl.lch.core;

import com.wl.lch.entity.NubbinReply;
import com.wl.lch.entity.NubbinReplyKey;

public interface NubbinReplyMapper {
    int deleteByPrimaryKey(NubbinReplyKey key);

    int insert(NubbinReply record);

    int insertSelective(NubbinReply record);

    NubbinReply selectByPrimaryKey(NubbinReplyKey key);

    int updateByPrimaryKeySelective(NubbinReply record);

    int updateByPrimaryKeyWithBLOBs(NubbinReply record);

    int updateByPrimaryKey(NubbinReply record);
}