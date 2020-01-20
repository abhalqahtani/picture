package com.sa.example.picture.domain.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UnknownException extends Exception {

    public UnknownException(Exception e) {

        super("Unknown Exception " + e);
        log.debug("stackTrace ", super.fillInStackTrace());
    }
}
