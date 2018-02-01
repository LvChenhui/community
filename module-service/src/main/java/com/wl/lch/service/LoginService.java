package com.wl.lch.service;

import com.wl.lch.entity.Subscriber;

public interface LoginService {

    public String signOut(String token);

    public String signIn(String accountNumber, String password);

    //public String signOut(String );

    public String regist(String accountNumber, String name, String password, String verificationCode);

    public String forget(String accountNumber, String newpsd, String oldpsd);

    public String sessionAccount(String accountNumber);

    public String checkSession(String token);

    public Subscriber findSubscriberDeatail(String accountNumber);

    public String updateUser(String accountNumber, String username, String signature, String sex);

    public String uploadIcon(String accountNumber, String icon);
}
