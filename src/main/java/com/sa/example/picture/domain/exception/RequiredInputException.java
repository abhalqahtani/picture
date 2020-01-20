package com.sa.example.picture.domain.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RequiredInputException extends Exception {

    public RequiredInputException() {

        super("Required Input Exception, please make sure you have set all required inputs");
        log.error("Required Input Exception, please make sure you have set all required inputs");
    }
}
