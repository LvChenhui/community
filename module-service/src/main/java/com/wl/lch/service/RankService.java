package com.wl.lch.service;

import com.wl.lch.dto.UserDTO;
import com.wl.lch.entity.PostEsther;

import java.util.List;

public interface RankService {

    public List<UserDTO> findNewUser();

    public List<PostEsther> findTopPost();
}
