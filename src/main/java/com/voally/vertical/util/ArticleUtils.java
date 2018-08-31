package com.voally.vertical.util;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.mapper.UserMapper;

import java.text.ParseException;
import java.util.List;

public class ArticleUtils {

    private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private static ArticleMapper articleMapper = SpringContextHolder.getBean(ArticleMapper.class);

    public static List<ArticleDTO> getArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(getThinker(articleDTO.getArticleThinkerId()));
            articleDTO.setPastTimes(pastTimes(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static List<ArticleDTO> getArticlesByThinker(Thinker thinker) {
        List<ArticleDTO> articleDTOS = articleMapper.getArticlesByThinkerId(thinker.getId());
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(thinker);
            articleDTO.setPastTimes(pastTimes(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static String pastTimes(Long time){
        try {
            return GlobalFunc.getTimeAgo(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "刚刚";
    }

    public static Thinker getThinker(String id){
        Thinker thinker = new Thinker();
        User user = userMapper.selectByPrimaryKey(id);
        BeanCopierUtil.copy(user, thinker);
        return thinker;
    }
}
