package io.wjehovah.github.myspingboot.exception;

public class EntityNotFoundException extends MyException {

    public EntityNotFoundException(String code, String msg) {
        super(code, msg);
    }
}
