create table article
(
  id                  decimal(32)   not null
    primary key,
  article_title       varchar(1000) null
  comment '文章标题',
  article_tags        varchar(500)  null
  comment '归属标签',
  article_thinker_id  varchar(64)   null
  comment '作者ID',
  article_permalink   varchar(500)  null
  comment '固定链接',
  article_create_time mediumtext    null
  comment '创建时间',
  article_update_time mediumtext    null
  comment '更新时间',
  article_status      int           null
  comment '状态',
  article_type        int           null
  comment '类型',
  article_content     text          null
  comment '内容',
  article_summary     varchar(200)  null
  comment '摘要',
  constraint article_id_uindex
  unique (id)
)
  comment '文章表';

create table user
(
  id               varchar(64)   not null
    primary key,
  user_no          int           not null
  comment '用户编号',
  user_email       varchar(100)  not null
  comment '用户邮箱',
  user_password    varchar(100)  null
  comment '用户密码',
  user_url         varchar(500)  null
  comment '用户链接',
  user_avatar_type int           null
  comment '头像类型',
  user_avatar_url  varchar(1000) null
  comment '头像路径',
  user_name        varchar(100)  null
  comment '用户昵称',
  constraint user_id_uindex
  unique (id),
  constraint user_user_email_uindex
  unique (user_email)
)
  comment '用户表';

