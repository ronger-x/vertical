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

    @Column(name = "user_no")
    private Integer userNo;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_url")
    private String userUrl;

    @Column(name = "user_avatar_type")
    private Integer userAvatarType;

    @Column(name = "user_avatar_url")
    private String userAvatarUrl;
}
