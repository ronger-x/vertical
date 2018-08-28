package com.voally.vertical.service.impl;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.Article;
import com.voally.vertical.mapper.ArticleMapper;
import com.voally.vertical.service.ArticleService;
import com.voally.vertical.util.BeanCopierUtil;
import com.voally.vertical.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public ArticleDTO detail(Long id) {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = articleMapper.selectByPrimaryKey(id);
        BeanCopierUtil.copy(article,articleDTO);
        articleDTO.setAuthor(Utils.getAuthor(articleDTO.getArticleAuthorId()));
        articleDTO.setPastTimes(Utils.pastTimes(articleDTO.getArticleCreateTime()));
        return articleDTO;
    }
}
