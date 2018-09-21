package com.voally.vertical.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Tag {

    @Id
    private Long id;

    private String tagTitle;

    @Column(name = "tag_uri")
    private String tagURI;

    private String tagDescription;

    private String tagIconPath;

    private int tagStatus;

}
