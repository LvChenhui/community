package com.wl.lch.entity;

import java.io.Serializable;

public class NubbinReplyKey implements Serializable{
    private static final long serialVersionUID = 3471356715243695577L;

    private Integer userId;

    private Integer affiliateTalkId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAffiliateTalkId() {
        return affiliateTalkId;
    }

    public void setAffiliateTalkId(Integer affiliateTalkId) {
        this.affiliateTalkId = affiliateTalkId;
    }
}