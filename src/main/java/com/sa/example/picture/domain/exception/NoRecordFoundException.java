package com.sa.example.picture.domain.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NoRecordFoundException extends Exception {

    public NoRecordFoundException() {
        super("No Record Found Exception ");
        log.warn("Record Not Found Exception  ");

    }
}
