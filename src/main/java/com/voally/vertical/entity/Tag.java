package com.voally.vertical.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Tag implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tag_title")
    private String tagTitle;

    @Column(name = "tag_uri")
    private String tagURI;

    @Column(name = "tag_description")
    private String tagDescription;

    @Column(name = "tag_icon_path")
    private String tagIconPath;

    @Column(name = "tag_status")
    private Integer tagStatus;

    @Column(name = "tag_reference_count")
    private Integer tagReferenceCount;

    @Column(name = "tag_follower_count")
    private Integer tagFollowerCount;
}
