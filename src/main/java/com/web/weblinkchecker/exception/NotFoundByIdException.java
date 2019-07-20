package com.web.weblinkchecker.exception;

import lombok.Getter;

public class NotFoundByIdException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "'%s' with id='%s' doesn't exist.";

    @Getter
    private final String id;

    @Getter
    private final Class clazz;

    public NotFoundByIdException(String id, Class clazz) {
        super(String.format(MESSAGE_TEMPLATE, clazz.getSimpleName(), id));
        this.id = id;
        this.clazz = clazz;
    }

}
