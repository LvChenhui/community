package com.wl.lch.entity;

import java.io.Serializable;

public class NubbinTalkKey implements Serializable {
    private static final long serialVersionUID = 9031897945621285685L;

    private Integer talkId;

    private String userId;

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}