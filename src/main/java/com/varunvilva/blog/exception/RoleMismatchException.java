package com.varunvilva.blog.exception;

public class RoleMismatchException extends RuntimeException {
    public RoleMismatchException(String msg) {
        super(msg);
    }
}
