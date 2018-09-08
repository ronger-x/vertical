package com.voally.vertical.service.impl;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.Article;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.service.ArticleService;
import com.voally.vertical.util.BeanCopierUtil;
import com.voally.vertical.util.Utils;
import com.voally.vertical.util.VerticalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public Article getArticleDetail(Long id){
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArticleDTO detail(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        BeanCopierUtil.copy(article,articleDTO);
        articleDTO.setThinker(VerticalUtils.getThinker(articleDTO.getArticleThinkerId()));
        articleDTO.setTimeAgo(VerticalUtils.getTimeAgo(articleDTO.getArticleCreateTime()));
        return articleDTO;
    }

    @Override
    public ArticleDTO detail(Long id) {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = getArticleDetail(id);
        BeanCopierUtil.copy(article,articleDTO);
        articleDTO.setThinker(VerticalUtils.getThinker(articleDTO.getArticleThinkerId()));
        articleDTO.setTimeAgo(VerticalUtils.getTimeAgo(articleDTO.getArticleCreateTime()));
        return articleDTO;
    }

    @Override
    public void save(Article article){
        article.setId(Utils.idBuilder());
        article.setArticlePermalink(Utils.ARTICLE_HREF+"/"+article.getId());
        article.setArticleCreateTime(new Date().getTime());
        article.setArticleUpdateTime(article.getArticleCreateTime());
        //article.setArticleThinkerId(Utils.getUser().getId());
        System.out.println(article);
    }
}
