package com.wl.lch.service.impl;

import com.wl.lch.core.LabelMapper;
import com.wl.lch.core.PostEstherMapper;
import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Label;
import com.wl.lch.entity.PostEsther;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.exception.BusinessException;
import com.wl.lch.service.AddService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;

@Service
public class AddServiceImpl implements AddService {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(AddServiceImpl.class);

    @Resource
    private PostEstherMapper postEstherMapper;

    @Resource
    private LabelMapper labelMapper;

    @Resource
    private SubscriberMapper subscriberMapper;

    @Override
    @Transactional
    public String add(String title, String content, int labelId, String accountNumber) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        PostEsther postEsther = new PostEsther();
        postEsther.setContent(content);
        postEsther.setReplyCount(0);
        postEsther.setGood(false);
        postEsther.setLabelId(labelId);
        postEsther.setTitle(title);
        postEsther.setTop(false);
        postEsther.setUserId(subscriber.getId());
        postEsther.setInitTime(Calendar.getInstance().getTime());
        int num = postEstherMapper.insertSelective(postEsther);
        if (num != 1) {
            logger.error("发帖失败,无法存入数据库！");
            throw new BusinessException("发帖失败，无法存入数据库！");
        }
        Label label = labelMapper.selectByPrimaryKey(labelId);
        int count = label.getPostsCount();
        label.setPostsCount(++count);
        int num2 = labelMapper.updateByPrimaryKeySelective(label);
        if (num2 != 1) {
            logger.error("发帖更新标签数量失败！");
            throw new BusinessException("发帖更新标签数量失败！");
        }
        return Resp.SUCCESS;
    }
}
