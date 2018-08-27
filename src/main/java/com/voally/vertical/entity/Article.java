package com.voally.vertical.entity;

import lombok.Data;

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
    private String articleTitle;

    /**
     * 归属标签
     * */
    private String articleTags;

    /**
     * 作者Id
     * */
    private String articleAuthorId;

    /**
     * 固定链接
     * */
    private String articlePermalink;

    /**
     * 创建时间
     * */
    private Long articleCreateTime;

    /**
     * 修改时间
     * */
    private Long articleUpdateTime;

    /**
     * 状态
     * */
    private Integer articleStatus;

    /**
     * 类型
     * */
    private Integer articleType;

    /**
     * 内容
     * */
    private String articleContent;

    /**
     * 摘要
     * */
    private String articleSummary;
}
