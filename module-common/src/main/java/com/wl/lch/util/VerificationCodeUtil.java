package com.wl.lch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerificationCodeUtil {

    public static String create(){
        return dateToString(new Date());
    }

    private static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        String time = sdf.format(date);
        return time;
    }

    public static void main(String[] args) {
        System.out.println(dateToString(new Date()));
    }
}
