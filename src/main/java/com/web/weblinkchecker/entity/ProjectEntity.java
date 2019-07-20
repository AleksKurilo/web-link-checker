package com.web.weblinkchecker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@Document(collection = "project")
@TypeAlias("project")
@EqualsAndHashCode(callSuper = true)
public class ProjectEntity extends BaseEntity {

    private String name;

    @DBRef
    @Field("links")
    private Set<LinkEntity> links;

}
