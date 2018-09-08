package com.voally.vertical.service;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.service.Service;
import com.voally.vertical.entity.Article;

public interface ArticleService extends Service<Article> {

    /**
     * 根据article_id 获取 article
     * @param id article_id
     * @return Article.class
     */
    Article getArticleDetail(Long id);

    /**
     * 根据Article 获取 ArticleDTO
     * @param article Article对象
     * @return ArticleDTO.class
     */
    ArticleDTO detail(Article article);

    ArticleDTO detail(Long id);
}
