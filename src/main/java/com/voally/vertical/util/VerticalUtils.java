package com.voally.vertical.util;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.mapper.UserMapper;

import java.text.ParseException;
import java.util.List;

public class VerticalUtils {

    private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private static ArticleMapper articleMapper = SpringContextHolder.getBean(ArticleMapper.class);

    /**
     * 首页文章
     * */
    public static List<ArticleDTO> getArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(getThinker(articleDTO.getArticleThinkerId()));
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    /**
     * 首页推荐作者
     * */
    public static List<Thinker> getRecommendThinkers() {
        List<Thinker> thinkers = userMapper.getRecommendThinkers();
        return thinkers;
    }

    public static List<ArticleDTO> getArticlesByThinker(Thinker thinker) {
        List<ArticleDTO> articleDTOS = articleMapper.getArticlesByThinkerId(thinker.getId());
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(thinker);
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }

    public static String getTimeAgo(Long time){
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

    public static List<ArticleDTO> getRecommendArticles() {
        List<ArticleDTO> articleDTOS = articleMapper.getRecommendArticles();
        for (ArticleDTO articleDTO:articleDTOS) {
            articleDTO.setThinker(getThinker(articleDTO.getArticleThinkerId()));
            articleDTO.setTimeAgo(getTimeAgo(articleDTO.getArticleCreateTime()));
        }
        return articleDTOS;
    }
}
