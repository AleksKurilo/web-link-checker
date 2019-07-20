package com.web.weblinkchecker.dto;

import com.web.weblinkchecker.entity.LinkEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDto extends BaseDto {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @Valid
    private Set<LinkEntity> links;

}
