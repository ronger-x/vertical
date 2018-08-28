CREATE TABLE user
(
  id varchar(64) PRIMARY KEY NOT NULL,
  user_no int NOT NULL COMMENT '用户编号',
  user_email varchar(100) NOT NULL COMMENT '用户邮箱',
  user_name varchar(100) COMMENT '用户昵称',
  user_password varchar(100) COMMENT '用户密码',
  user_url varchar(500) COMMENT '用户链接',
  user_avatar_type int COMMENT '头像类型',
  user_avatar_url varchar(1000) COMMENT '头像路径'
);
CREATE UNIQUE INDEX user_id_uindex ON user (id);

CREATE UNIQUE INDEX user_user_email_uindex ON user (user_email);

ALTER TABLE user COMMENT = '用户表';

CREATE TABLE article
(
  id decimal(32) PRIMARY KEY NOT NULL,
  article_title varchar(1000) COMMENT '文章标题',
  article_tags varchar(500) COMMENT '归属标签',
  article_author_id varchar(64) COMMENT '作者ID',
  article_permalink varchar(500) COMMENT '固定链接',
  article_create_time long COMMENT '创建时间',
  article_update_time long COMMENT '更新时间',
  article_status int COMMENT '状态',
  article_type int COMMENT '类型',
  article_content text COMMENT '内容',
  article_summary varchar(200) COMMENT '摘要'
);

CREATE UNIQUE INDEX article_id_uindex ON article (id);

ALTER TABLE article COMMENT = '文章表';