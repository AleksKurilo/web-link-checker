package com.web.weblinkchecker.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

}
