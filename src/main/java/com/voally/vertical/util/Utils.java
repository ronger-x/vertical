package com.voally.vertical.util;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Author;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.mapper.UserMapper;

import java.util.List;

public class Utils {

    private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private static ArticleMapper articleMapper = SpringContextHolder.getBean(ArticleMapper.class);

    private static final long WORKER_ID = 1L;
    private static final long DATA_CENTER_ID = 1L;
    private static final long SEQUENCE = 0L;



    public static Long idBuilder(){
        IdWorker idWorker = new IdWorker(WORKER_ID,DATA_CENTER_ID,SEQUENCE);
        return idWorker.nextId();
    }

    public static List<ArticleDTO> getArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            Author author = new Author();
            User user = userMapper.selectByPrimaryKey(articleDTO.getArticleAuthorId());
            BeanCopierUtil.copy(user,author);
            articleDTO.setAuthor(author);
            articleDTO.setPastTimes(Utils.pastTimes(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static String pastTimes(Long time){
        return "1 小时前";
    }

}
