package com.wl.lch.service.impl;

import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.domain.EncryptCode;
import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.RedisUtil;
import com.wl.lch.util.StringEncryptUtil;
import com.wl.lch.util.VerificationCodeUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private SubscriberMapper subscriberMapper;

    @Override
    public String signOut(String token) {
        if (StringUtils.isNotEmpty(token)) {
            RedisUtil.del(Resp.SESSIONACCOUNT + token);
            return Resp.SUCCESS;
        }
        return Resp.FAIL;
    }

    @Override
    public String signIn(String accountNumber, String password) {
        if (StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(accountNumber)) {
            Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
            if (subscriber != null) {
                String pwd = StringEncryptUtil.encryptStr(password, EncryptCode.PWDECODE);
                if (pwd.equals(subscriber.getPassword())) {
                    return Resp.SUCCESS;
                }
            }
        }
        return Resp.FAIL;
    }

    @Override
    public String regist(String accountNumber, String name, String password, String verificationCode) {
        if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(accountNumber)) {
//            if (verificationCode.equals(VerificationCodeUtil.create())) {
            Subscriber subsciber = subscriberMapper.selectByAccount(accountNumber);
            if (subsciber != null) {
                return Resp.EXIST;
            }
            subsciber = subscriberMapper.selectByName(name);
            if (subsciber != null) {
                return Resp.NAMEEXIST;
            }
            subsciber = new Subscriber();
            subsciber.setAccount(accountNumber);
            subsciber.setName(name);
            subsciber.setPassword(StringEncryptUtil.encryptStr(password, EncryptCode.PWDECODE));
            int num = subscriberMapper.insertSelective(subsciber);
            if (num == 1) {
                return Resp.SUCCESS;
            }
//            }
        }
        return Resp.FAIL;
    }

    @Override
    public String forget(String accountNumber, String newpsd, String oldpsd) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        if (subscriber == null) {
            return Resp.NOTEXIST;
        }
        if (!StringEncryptUtil.encryptStr(oldpsd, EncryptCode.PWDECODE).equals(subscriber.getPassword())) {
            return Resp.PWDERROR;
        }
        subscriber.setPassword(StringEncryptUtil.encryptStr(newpsd, EncryptCode.PWDECODE));
        int num = subscriberMapper.updateByPrimaryKeySelective(subscriber);
        if (num == 1) {
            return Resp.SUCCESS;
        }
        return Resp.FAIL;
    }

    @Override
    public String sessionAccount(String accountNumber) {
        if (StringUtils.isNotEmpty(accountNumber)) {
            String token = UUID.randomUUID().toString();
            RedisUtil.set(Resp.SESSIONACCOUNT + token, accountNumber, 2 * 60 * 60);
            return token;
        }
        return null;
    }

    @Override
    public String checkSession(String token) {
        String accountNumber = (String) RedisUtil.get(Resp.SESSIONACCOUNT + token);
        if (StringUtils.isNotEmpty(accountNumber)) {
            return accountNumber;
        }
        return null;
    }

    @Override
    public Subscriber findSubscriberDeatail(String accountNumber) {
        return subscriberMapper.selectByAccount(accountNumber);
    }

    @Override
    public String updateUser(String accountNumber, String username, String signature, String sex) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        if (StringUtils.isNotEmpty(username)) {
            subscriber.setName(username);
        }
        if (StringUtils.isNotEmpty(signature)) {
            subscriber.setSignature(signature);
        }
        if (StringUtils.isNotEmpty(sex)) {
            subscriber.setGender(sex);
        }
        int num = subscriberMapper.updateByPrimaryKeySelective(subscriber);
        if (num == 1) {
            return Resp.SUCCESS;
        }
        return Resp.FAIL;
    }

    @Override
    public String uploadIcon(String accountNumber, String icon) {
        Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
        if (subscriber != null) {
            subscriber.setImageUrl(icon);
            int num = subscriberMapper.updateByPrimaryKeySelective(subscriber);
            if(num == 1){
                return Resp.SUCCESS;
            }
        }
        return Resp.FAIL;
    }
}
