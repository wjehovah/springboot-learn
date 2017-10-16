package io.wjehovah.github.myspingboot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends MyException {

    public BadRequestException(String msg) {
        super(msg);
    }
}
