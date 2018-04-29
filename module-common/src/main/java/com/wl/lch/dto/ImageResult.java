package com.wl.lch.dto;

import java.io.Serializable;

public class ImageResult<T> implements Serializable {

    private static final long serialVersionUID = 6893617270909767639L;

    private int code;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
