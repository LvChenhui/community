package com.wl.lch.entity;

import java.io.Serializable;
import java.util.Date;

public class InformationImage implements Serializable{
    private static final long serialVersionUID = 6550168408476846632L;

    private Integer id;

    private String imageUrl;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}