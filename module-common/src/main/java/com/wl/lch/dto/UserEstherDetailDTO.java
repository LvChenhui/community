package com.wl.lch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wl.lch.entity.Subscriber;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEstherDetailDTO implements Serializable {
    private static final long serialVersionUID = 9007288364609543221L;

    private List<EstherDTO> posts;

    private UserDTO user;

    public List<EstherDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<EstherDTO> posts) {
        this.posts = posts;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
