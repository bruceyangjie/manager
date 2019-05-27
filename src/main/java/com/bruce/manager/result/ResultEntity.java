package com.bruce.manager.result;

import java.io.Serializable;

//统一的返回体
public class ResultEntity implements Serializable {
    private int code;
    private String msg;
    private Object data;

    private static class Holder {
        private static ResultEntity resultEntity = new ResultEntity();
    }

    static ResultEntity getInstance() {
        return Holder.resultEntity;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
