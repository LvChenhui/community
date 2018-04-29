package com.wl.lch.service;

import com.wl.lch.dto.EstherDTO;
import com.wl.lch.dto.EstherDetailDTO;
import com.wl.lch.dto.UserDTO;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.entity.Subscriber;

import java.util.List;

public interface PostService {

    public List<EstherDTO> findPostEsther(int pageNo, int length, String type, String search);

    public int sumPostPageSize(String type, String search);

    public EstherDetailDTO findReplyEsther(int postId, int pageNo, int length);

    public int sumReplyPageSize(int postsId);

    public EstherDTO getEstherDTO(PostEsther postEsther);

    public UserDTO getUserDTO(Subscriber subscriber);
}
