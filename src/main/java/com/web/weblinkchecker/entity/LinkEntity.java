package com.web.weblinkchecker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "link")
@TypeAlias("link")
@EqualsAndHashCode(callSuper = true)
public class LinkEntity extends BaseEntity {

    private String location;
    private String href;
    private boolean dofollow;
    private String anchor;

}
