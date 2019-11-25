package com.lijunyan.mvpframe.http;

import com.google.gson.annotations.SerializedName;

public class BaseEntity<E> {

    @SerializedName("code")
    private int code;
    @SerializedName("success")
    private boolean success;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private E data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "code=" + code +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}