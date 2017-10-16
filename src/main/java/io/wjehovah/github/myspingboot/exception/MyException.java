package io.wjehovah.github.myspingboot.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyException extends RuntimeException {
    private String code;
    private String msg;
    private String error;

    public MyException(String msg) {
        super(msg);
    }

    public MyException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.error = getClass().getName() + "-" + getMessage();
    }
}
