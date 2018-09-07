package com.voally.vertical.util;

import com.voally.vertical.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


public class Utils {

    private static final long WORKER_ID = 1L;
    private static final long DATA_CENTER_ID = 1L;
    private static final long SEQUENCE = 0L;

    public static final String LOCALHOST_HREF = "http://voall.com";
    public static final String ARTICLE_HREF = LOCALHOST_HREF+"/article";



    public static Long idBuilder(){
        IdWorker idWorker = new IdWorker(WORKER_ID,DATA_CENTER_ID,SEQUENCE);
        return idWorker.nextId();
    }

    public static User getUser(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        User user = (User) session.getAttribute("");
        return user;
    }

}
