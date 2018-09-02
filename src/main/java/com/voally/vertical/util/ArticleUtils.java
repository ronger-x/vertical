package com.voally.vertical.util;

import com.voally.vertical.mapper.ArticleMapper;

public class ArticleUtils {

    private static ArticleMapper articleMapper = SpringContextHolder.getBean(ArticleMapper.class);

}
