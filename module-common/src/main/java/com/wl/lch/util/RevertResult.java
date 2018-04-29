package com.wl.lch.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevertResult<T> implements Serializable {

    private static final long serialVersionUID = 7329218059481508496L;

    private int status;
    private String msg;
    private T data;
    private int pageSize;
    private int total;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public RevertResult() {
    }

    public RevertResult(int status) {
        this.status = status;
    }

    public RevertResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public RevertResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public RevertResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RevertResult(int status, String msg, T data, int pageSize, int total) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    public static RevertResult ok() {
        return new RevertResult(StateEnum.SUCCESS.getState());
    }

    public static <T> RevertResult ok(T data) {
        return new RevertResult(StateEnum.SUCCESS.getState(), data);
    }

    public static RevertResult ok(String msg) {
        return new RevertResult(StateEnum.SUCCESS.getState(), msg);
    }

    public static <T> RevertResult ok(String msg, T data) {
        return new RevertResult(StateEnum.SUCCESS.getState(), msg, data);
    }

    public static <T> RevertResult ok(String msg, T data, int pageSize, int total) {
        return new RevertResult(StateEnum.SUCCESS.getState(), msg, data, pageSize, total);
    }

    public static RevertResult warn() {
        return new RevertResult(StateEnum.WARN.getState());
    }

    public static RevertResult warn(String msg) {
        return new RevertResult(StateEnum.WARN.getState(), msg);
    }

    public static RevertResult error() {
        return new RevertResult(StateEnum.ERROR.getState());
    }

    public static RevertResult error(String msg) {
        return new RevertResult(StateEnum.ERROR.getState(), msg);
    }

    @Override
    public String toString() {
        return "RevertResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }
}
