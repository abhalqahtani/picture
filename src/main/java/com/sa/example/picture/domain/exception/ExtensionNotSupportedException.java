package com.sa.example.picture.domain.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExtensionNotSupportedException extends Exception{

    public ExtensionNotSupportedException(){
        super("File Extension is Not Supported by the System");
       log.error("File Extension is Not Supported by the System");
    }
}
