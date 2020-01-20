package com.sa.example.picture.rest;

import com.sa.example.picture.domain.exception.ExtensionNotSupportedException;
import com.sa.example.picture.domain.exception.NoRecordFoundException;
import com.sa.example.picture.domain.exception.RequiredInputException;
import com.sa.example.picture.domain.exception.UnknownException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnknownException.class)
    public UnknownException handleUnknownOdsException(UnknownException cause) {
        return new UnknownException(cause);
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoRecordFoundException.class)
    public NoRecordFoundException handleNoRecordFoundException() {
        return new NoRecordFoundException();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExtensionNotSupportedException.class)
    public ExtensionNotSupportedException handleExtensionNotSupportedException() {
        return new ExtensionNotSupportedException();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RequiredInputException.class)
    public RequiredInputException handleRequiredInputException() {
        return new RequiredInputException();
    }

}
