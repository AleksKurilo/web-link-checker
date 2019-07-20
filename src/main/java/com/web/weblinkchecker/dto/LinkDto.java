package com.web.weblinkchecker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = true)
public class LinkDto extends BaseDto {

    @NotEmpty
    private String location;

    @NotEmpty
    private String href;

    private boolean dofollow;

    @NotEmpty
    private String anchor;

}
