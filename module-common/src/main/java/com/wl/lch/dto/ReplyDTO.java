package com.wl.lch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wl.lch.entity.Subscriber;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyDTO implements Serializable {
    private static final long serialVersionUID = 3663389085325321169L;

    private Integer id;

    private Date initTime;

    private Integer up;

    private String content;

    private UserDTO user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
