DROP TABLE IF EXISTS vertical.user;
DROP TABLE IF EXISTS vertical.article;

CREATE TABLE vertical.user
(
    id varchar(64) PRIMARY KEY NOT NULL,
    user_no int(11) NOT NULL COMMENT '用户编号',
    user_email varchar(100) NOT NULL COMMENT '用户邮箱',
    user_password varchar(100) COMMENT '用户密码',
    user_url varchar(500) COMMENT '用户链接',
    user_avatar_type int(11) COMMENT '头像类型',
    user_avatar_url varchar(1000) COMMENT '头像路径',
    user_name varchar(100) COMMENT '用户名',
    nick_name varchar(100) COMMENT '用户昵称'
);
CREATE UNIQUE INDEX user_id_uindex ON vertical.user (id);
CREATE UNIQUE INDEX user_user_email_uindex ON vertical.user (user_email);
CREATE TABLE vertical.article
(
    id decimal(32) PRIMARY KEY NOT NULL,
    article_title varchar(1000) COMMENT '文章标题',
    article_tags varchar(500) COMMENT '归属标签',
    article_thinker_id varchar(64) COMMENT '作者ID',
    article_permalink varchar(500) COMMENT '固定链接',
    article_create_time mediumtext COMMENT '创建时间',
    article_update_time mediumtext COMMENT '更新时间',
    article_status int(11) COMMENT '状态',
    article_type int(11) COMMENT '类型',
    article_content text COMMENT '内容',
    article_summary varchar(200) COMMENT '摘要'
);
CREATE UNIQUE INDEX article_id_uindex ON vertical.article (id);