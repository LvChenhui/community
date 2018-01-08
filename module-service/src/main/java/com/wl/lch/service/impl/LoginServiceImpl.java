package com.wl.lch.service.impl;

import com.wl.lch.core.SubscriberMapper;
import com.wl.lch.domain.EncryptCode;
import com.wl.lch.domain.Resp;
import com.wl.lch.entity.Subscriber;
import com.wl.lch.service.LoginService;
import com.wl.lch.util.StringEncryptUtil;
import com.wl.lch.util.VerificationCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Resource
    private SubscriberMapper subscriberMapper;

    @Override
    public String registLogin() {
        Subscriber subscriber = new Subscriber();
        subscriber.setName("zhangsan");
        subscriberMapper.insertSelective(subscriber);
        return null;
    }

    @Override
    public String signIn(String accountNumber,String password) {
        if(!StringUtils.isEmpty(password)&&!StringUtils.isEmpty(accountNumber)){
            Subscriber subscriber = subscriberMapper.selectByAccount(accountNumber);
            if(subscriber!=null){
                String pwd = StringEncryptUtil.encryptStr(password, EncryptCode.PWDECODE);
                if(pwd.equals(subscriber.getPassword())){
                    return Resp.SUCCESS;
                }
            }
        }
        return Resp.FAIL;
    }

    @Override
    public String regist(String accountNumber, String password,String verificationCode) {
        if(!StringUtils.isEmpty(password)&&!StringUtils.isEmpty(accountNumber)){
            if(verificationCode.equals(VerificationCodeUtil.create())){
                Subscriber subsciber = subscriberMapper.selectByAccount(accountNumber);
                if(subsciber!=null){
                    return Resp.EXIST;
                }
                subsciber = new Subscriber();
                subsciber.setAccount(accountNumber);
                subsciber.setPassword(StringEncryptUtil.encryptStr(password,EncryptCode.PWDECODE));
                int num = subscriberMapper.insertSelective(subsciber);
                if(num==1){
                    return Resp.SUCCESS;
                }
            }
        }
        return Resp.FAIL;
    }

    @Override
    public String forget(String accountNumber,String verificationCode,String newPwd) {
        if(!StringUtils.isEmpty(accountNumber)&&!StringUtils.isEmpty(verificationCode)){
            if(verificationCode.equals(VerificationCodeUtil.create())){
                Subscriber subsciber = subscriberMapper.selectByAccount(accountNumber);
                if(subsciber!=null){
                    subsciber.setPassword(StringEncryptUtil.encryptStr(newPwd, EncryptCode.PWDECODE));
                    int num = subscriberMapper.updateByPrimaryKey(subsciber);
                    if(num==1){
                        return Resp.SUCCESS;
                    }
                }
                return Resp.NOTEXIST;
            }
        }
        return Resp.FAIL;
    }
}
