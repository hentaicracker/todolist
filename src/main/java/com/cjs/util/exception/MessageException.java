package com.cjs.util.exception;

/**
 * Created by xiaowu on 2016/5/8.
 */
public class MessageException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private boolean isShow = true;
    public MessageException(String msg) {
        super(msg);
    }
    public String getMsg(){
        return isShow?getMessage():"";
    }
}

