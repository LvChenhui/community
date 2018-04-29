package com.wl.lch.service.impl;

import com.wl.lch.core.NotificationMapper;
import com.wl.lch.core.PostEstherMapper;
import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.domain.Resp;
import com.wl.lch.dto.NotificationDTO;
import com.wl.lch.dto.PostEstherDTO;
import com.wl.lch.entity.Notification;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.NotificationService;
import com.wl.lch.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Resource
    private NotificationMapper notificationMapper;

    @Resource
    private SubscriberMapper subscriberMapper;

    @Resource
    private PostEstherMapper postEstherMapper;

    @Resource
    private PostService postService;

    @Override
    public int messageCount(String accountNumber) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        return notificationMapper.selectMessageCount(subscriber.getId());
    }

    @Override
    public List<NotificationDTO> getNotification(int id) {
        Subscriber toUser = subscriberMapper.selectByPrimaryKey(id);
        List<Notification> notifications = notificationMapper.selectByToUserId(toUser.getId());
        List<NotificationDTO> resultList = new ArrayList<>();
        for (Notification notification : notifications) {
            Subscriber fromUser = subscriberMapper.selectByPrimaryKey(notification.getFromUserId());
            PostEsther postEsther = postEstherMapper.selectByPrimaryKey(notification.getPostsId());
            NotificationDTO result = new NotificationDTO();
            result.setId(notification.getId());
            result.setFromUser(postService.getUserDTO(fromUser));
            result.setToUser(postService.getUserDTO(toUser));
            PostEstherDTO post = new PostEstherDTO();
            post.setId(postEsther.getId());
            post.setTitle(postEsther.getTitle());
            result.setPosts(post);
            result.setInitTime(notification.getInitTime());
            result.setRead(notification.getIsRead());
            resultList.add(result);
        }
        return resultList;
    }

    @Override
    public String delNotification(int id) {
        notificationMapper.updateByToUserId(id);
        return Resp.SUCCESS;
    }
}
