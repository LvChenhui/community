package com.wl.lch.service;

public interface LoginService {

    public String registLogin();

    public String signIn(String accountNumber,String password);

    //public String signOut(String );

    public String regist(String accountNumber,String password,String verificationCode);

    public String forget(String accountNumber,String verificationCode,String newPwd);
}
