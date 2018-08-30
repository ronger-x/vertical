package com.voally.vertical.mapper;

import com.voally.vertical.api.entity.ArticleDTO;
import com.voally.vertical.core.mapper.Mapper;
import com.voally.vertical.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {

    List<ArticleDTO> getArticles();

    List<ArticleDTO> getArticlesByThinkerId(@Param("tinkerId") String id);
}
