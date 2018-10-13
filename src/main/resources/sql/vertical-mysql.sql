DROP TABLE IF EXISTS vertical.user;
DROP TABLE IF EXISTS vertical.article;
DROP TABLE IF EXISTS vertical.tag;

create table article
(
  id                  decimal(32)     not null
    primary key,
  article_title       varchar(1000)   null
  comment '文章标题',
  article_tags        varchar(500)    null
  comment '归属标签',
  article_thinker_id  varchar(64)     null
  comment '作者ID',
  article_permalink   varchar(500)    null
  comment '固定链接',
  article_create_time mediumtext      null
  comment '创建时间',
  article_update_time mediumtext      null
  comment '更新时间',
  article_status      int default '0' null
  comment '状态',
  article_type        int default '0' null
  comment '类型',
  article_content     text            null
  comment '内容',
  article_summary     varchar(200)    null
  comment '摘要',
  constraint article_id_uindex
  unique (id)
)
  comment '文章表';

create table tag
(
  id                  decimal(32)     not null
    primary key,
  tag_title           varchar(64)     null
  comment '标签名',
  tag_uri             varchar(500)    null
  comment '标签 URI',
  tag_icon_path       varchar(500)    null
  comment '标签图标路径',
  tag_description     longtext        null
  comment '标签描述',
  tag_status          int default '0' null
  comment '标签状态 0：正常1：停用',
  tag_reference_count int default '0' not null
  comment '标签引用（帖子/用户自评等）计数',
  tag_follower_count  int default '0' not null
  comment '标签关注者计数',
  constraint tag_id_uindex
  unique (id)
)
  comment '标签表';

create table user
(
  id               varchar(64)     not null
    primary key,
  user_no          int             not null
  comment '用户编号',
  user_email       varchar(100)    not null
  comment '用户邮箱',
  user_password    varchar(100)    null
  comment '用户密码',
  user_url         varchar(500)    null
  comment '用户链接',
  user_avatar_type int             null
  comment '头像类型',
  user_avatar_url  varchar(1000)   null
  comment '头像路径',
  user_name        varchar(100)    null
  comment '用户名',
  nick_name        varchar(100)    null
  comment '用户昵称',
  user_create_time mediumtext      null
  comment '用户创建时间',
  user_update_time mediumtext      null
  comment '用户更新时间',
  user_status      int default '0' null
  comment '用户状态，0正常1禁用2注销',
  constraint user_id_uindex
  unique (id),
  constraint user_user_email_uindex
  unique (user_email)
)
  comment '用户表';



