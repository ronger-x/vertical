package com.voally.vertical.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;

    /**
     * 编号
     * */
    @Column(name = "user_no")
    private Integer userNo;

    /**
     * 邮箱
     * */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户名
     * */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     * */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户密码
     * */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户主页
     * */
    @Column(name = "user_url")
    private String userUrl;

    /**
     * 头像文件类型
     * */
    @Column(name = "user_avatar_type")
    private Integer userAvatarType;

    /**
     * 头像路径
     * */
    @Column(name = "user_avatar_url")
    private String userAvatarUrl;

    /**
     * 创建时间
     * */
    @Column(name = "user_create_time")
    private Long userCreateTime;

    /**
     * 修改时间
     * */
    @Column(name = "user_update_time")
    private Long userUpdateTime;

    /**
     * 状态
     * */
    @Column(name = "user_status")
    private Integer userStatus;

}
