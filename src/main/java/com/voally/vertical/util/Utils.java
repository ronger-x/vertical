package com.voally.vertical.util;

public class Utils {

    private static final long WORKER_ID = 1L;
    private static final long DATA_CENTER_ID = 1L;
    private static final long SEQUENCE = 0L;

    public static Long idBuilder(){
        IdWorker idWorker = new IdWorker(WORKER_ID,DATA_CENTER_ID,SEQUENCE);
        return idWorker.nextId();
    }

}
