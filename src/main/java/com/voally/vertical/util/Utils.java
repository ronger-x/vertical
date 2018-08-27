package com.voally.vertical.util;

import com.voally.vertical.api.entity.ArticleDTO;

import java.util.List;

public class Utils {

    private static final long WORKER_ID = 1L;
    private static final long DATA_CENTER_ID = 1L;
    private static final long SEQUENCE = 0L;



    public static Long idBuilder(){
        IdWorker idWorker = new IdWorker(WORKER_ID,DATA_CENTER_ID,SEQUENCE);
        return idWorker.nextId();
    }

    public static List<ArticleDTO> getArticles() {
        return null;
    }

}
