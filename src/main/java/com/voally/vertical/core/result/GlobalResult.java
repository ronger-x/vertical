package com.voally.vertical.core.result;

import lombok.Data;
import org.jsoup.helper.StringUtil;

@Data
public class GlobalResult<T> {
    private boolean success = false;
    private T data;
    private T rows;
    private long total;
    private int code;
    private String message;

    private static GlobalResult GLOBALRESULT;

    static {
        GLOBALRESULT = null;
    }

    private GlobalResult() {}

    /**
     * 同步代码快的加锁，安全高效
     */
    public static   GlobalResult newInstance() {
        if (GLOBALRESULT == null){
            synchronized (GlobalResult.class){
                if (GLOBALRESULT == null) {
                    GLOBALRESULT = new GlobalResult();
                }
            }
        }
        return GLOBALRESULT;
    }

    public void success(T data){
        success("",data);
    }

    public void success(String message,T data){
        this.success = true;
        this.code = ResultCode.SUCCESS.getCode();
        this.data = data;

        if(StringUtil.isBlank(message))
            this.message = ResultCode.SUCCESS.getMessage();
        else
            this.message = message;
    }

    public void error(){
        error("");
    }

    public void error(String message){
        this.success = false;
        this.code = ResultCode.FAIL.getCode();

        if(StringUtil.isBlank(message))
            this.message = ResultCode.FAIL.getMessage();
        else
            this.message = message;
    }

    public void error(Integer code,String message){
        this.success = false;
        this.code = code;
        this.message = message;
    }

}
