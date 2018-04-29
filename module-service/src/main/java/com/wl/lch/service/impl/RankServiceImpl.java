package com.wl.lch.service.impl;

import com.wl.lch.core.PostEstherMapper;
import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.dto.UserDTO;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.PostService;
import com.wl.lch.service.RankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Resource
    private PostEstherMapper postEstherMapper;

    @Resource
    private SubscriberMapper subscriberMapper;

    @Resource
    private PostService postService;

    @Override
    public List<UserDTO> findNewUser() {
        List<Subscriber> subscribers = subscriberMapper.selectNewUser();
        List<UserDTO> users = new ArrayList<>();
        for (Subscriber s : subscribers) {
            users.add(postService.getUserDTO(s));
        }
        return users;
    }

    @Override
    public List<PostEsther> findTopPost() {
        return postEstherMapper.findTopPost();
    }
}
