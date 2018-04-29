package com.wl.lch.service.impl;

import com.wl.lch.core.NotificationMapper;
import com.wl.lch.core.PostEstherMapper;
import com.wl.lch.core.ReplyEstherMapper;
import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Notification;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.entity.ReplyEsther;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.exception.BusinessException;
import com.wl.lch.service.ReplyService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class ReplyServiceImpl implements ReplyService {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);

    @Resource
    private SubscriberMapper subscriberMapper;

    @Resource
    private ReplyEstherMapper replyEstherMapper;

    @Resource
    private PostEstherMapper postEstherMapper;

    @Resource
    private NotificationMapper notificationMapper;

    @Override
    @Transactional
    public String reply(String content, int postsId, String accountNumber) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        ReplyEsther replyEsther = new ReplyEsther();
        replyEsther.setContent(content);
        replyEsther.setInitTime(Calendar.getInstance().getTime());
        replyEsther.setPostsId(postsId);
        replyEsther.setUserId(subscriber.getId());
        replyEsther.setUp(0);
        int num = replyEstherMapper.insert(replyEsther);
        if (num != 1) {
            logger.error("插入回帖失败！");
            throw new BusinessException("插入回帖失败！");
        }
        PostEsther postEsther = postEstherMapper.selectByPrimaryKey(postsId);
        int count = postEsther.getReplyCount();
        postEsther.setReplyCount(++count);
        int num2 = postEstherMapper.updateByPrimaryKey(postEsther);
        if (num2 != 1) {
            logger.error("回复帖子，更新帖子数量失败！");
            throw new BusinessException("回复帖子，更新帖子数量失败！");
        }
        if(!subscriber.getId().equals(postEsther.getUserId())){
            Notification notification = new Notification();
            notification.setFromUserId(subscriber.getId());
            notification.setInitTime(Calendar.getInstance().getTime());
            notification.setIsRead(false);
            notification.setPostsId(postEsther.getId());
            notification.setToUserId(postEsther.getUserId());
            int num3 = notificationMapper.insert(notification);
            if (num3 != 1) {
                logger.error("回复帖子，更新提示表失败！");
                throw new BusinessException("回复帖子，更新提示表失败！");
            }
        }
        return Resp.SUCCESS;
    }


}
