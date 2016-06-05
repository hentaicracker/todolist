package com.cjs.util.exception;

/**
 * 2016/5/8
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

