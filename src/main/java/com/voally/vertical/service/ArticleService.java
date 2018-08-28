package com.voally.vertical.service;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.service.Service;
import com.voally.vertical.entity.Article;

public interface ArticleService extends Service<Article> {
    ArticleDTO detail(Long id);
}
