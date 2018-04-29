package com.wl.lch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDTO implements Serializable {
    private static final long serialVersionUID = 5190446058006301840L;

    private Integer id;

    private Boolean isRead;

    private UserDTO fromUser;

    private PostEstherDTO posts;

    private UserDTO toUser;

    private Date initTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public UserDTO getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDTO fromUser) {
        this.fromUser = fromUser;
    }

    public PostEstherDTO getPosts() {
        return posts;
    }

    public void setPosts(PostEstherDTO posts) {
        this.posts = posts;
    }

    public UserDTO getToUser() {
        return toUser;
    }

    public void setToUser(UserDTO toUser) {
        this.toUser = toUser;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }
}
