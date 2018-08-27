package com.voally.vertical.api.entity;

import lombok.Data;

@Data
public class ArticleDTO {

    private Long id;

    /**
     * 文章标题
     * */
    private String articleTitle;

    /**
     * 归属标签
     * */
    private String articleTags;

    /**
     * 固定链接
     * */
    private String articlePermalink;

    /**
     * 摘要
     * */
    private String articleSummary;

    /**
     * 作者信息
     * */
    private Author author;
}
