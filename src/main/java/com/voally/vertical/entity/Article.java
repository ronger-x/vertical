package com.voally.vertical.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    private Long id;

    /**
     * 文章标题
     * */
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 归属标签
     * */
    @Column(name = "article_tags")
    private String articleTags;

    /**
     * 作者Id
     * */
    @Column(name = "article_author_id")
    private String articleAuthorId;

    /**
     * 固定链接
     * */
    @Column(name = "article_permalink")
    private String articlePermalink;

    /**
     * 创建时间
     * */
    @Column(name = "article_create_time")
    private Long articleCreateTime;

    /**
     * 修改时间
     * */
    @Column(name = "article_update_time")
    private Long articleUpdateTime;

    /**
     * 状态
     * */
    @Column(name = "article_status")
    private Integer articleStatus;

    /**
     * 类型
     * */
    @Column(name = "article_type")
    private Integer articleType;

    /**
     * 内容
     * */
    @Column(name = "article_content")
    private String articleContent;

    /**
     * 摘要
     * */
    @Column(name = "article_summary")
    private String articleSummary;
}
