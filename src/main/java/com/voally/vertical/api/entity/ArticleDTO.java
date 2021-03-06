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
     * 作者Id
     * */
    private String articleThinkerId;

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
     * 摘要
     * */
    private String articleContent;

    /**
     * 作者信息
     * */
    private Thinker thinker;

    /**
     * 创建时间
     * */
    private Long articleCreateTime;

    /**
     * 过去时长
     * */
    private String timeAgo;

}
