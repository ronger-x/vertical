package com.voally.vertical.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;

    private int userNo;

    private String userEmail;

    private String userName;

    private String userPassword;

    private String userURL;

    private int userAvatarType;

    private String userAvatarURL;
}
