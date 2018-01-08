package com.wl.lch.entity;

import java.io.Serializable;
import java.util.Date;

public class NubbinReply extends NubbinReplyKey implements Serializable{
    private static final long serialVersionUID = -144022499588314111L;

    private Integer fabulous;

    private Date createTime;

    private Date reviseTime;

    private String content;

    public Integer getFabulous() {
        return fabulous;
    }

    public void setFabulous(Integer fabulous) {
        this.fabulous = fabulous;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}