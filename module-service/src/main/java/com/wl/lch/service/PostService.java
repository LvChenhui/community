package com.wl.lch.service;

import com.wl.lch.dto.EstherDTO;
import com.wl.lch.dto.EstherDetailDTO;

import java.util.List;

public interface PostService {

    public List<EstherDTO> findPostEsther(int pageNo, int length, String type, String search);

    public int sumPageSize();

    public EstherDetailDTO findReplyEsther(int postId, int pageNo, int length);
}
