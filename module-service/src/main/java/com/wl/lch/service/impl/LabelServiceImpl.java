package com.wl.lch.service.impl;

import com.wl.lch.core.LabelMapper;
import com.wl.lch.core.PostEstherMapper;
import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.dto.EstherDTO;
import com.wl.lch.entity.Label;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.service.LabelService;
import com.wl.lch.service.PostService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Resource
    private LabelMapper labelMapper;

    @Resource
    private PostEstherMapper postEstherMapper;

    @Resource
    private PostService postService;

    @Override
    public List<Label> findLabels() {
        return labelMapper.findLabels();
    }

    @Override
    public List<EstherDTO> findPostByLabel(int labelId, int pageNo, int length) {
        int start = (pageNo - 1) * length;
        List<PostEsther> postEsthers = postEstherMapper.findPostByLabel(labelId, start, length);
        List<EstherDTO> esthers = new ArrayList<>();
        for (PostEsther postEsther : postEsthers) {
            EstherDTO esther = postService.getEstherDTO(postEsther);
            esthers.add(esther);
        }
        return esthers;
    }

    @Override
    public int sumPageSizeByLabel(int labelId) {
        return postEstherMapper.sumPageSizeByLabel(labelId);
    }
}
