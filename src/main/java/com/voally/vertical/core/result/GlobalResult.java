package com.voally.vertical.core.result;

import lombok.Data;

@Data
public class GlobalResult<T> {
    private boolean success = false;
    private T data;
    private int code;
    private String message;

    private static GlobalResult GLOBALRESULT = new GlobalResult();

    private GlobalResult() {}

    /**
     * 同步代码快的加锁，安全高效
     */
    public static GlobalResult newInstance() {
        return GLOBALRESULT;
    }

}
