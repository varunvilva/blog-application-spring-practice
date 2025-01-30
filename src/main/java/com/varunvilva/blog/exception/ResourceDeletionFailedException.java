package com.varunvilva.blog.exception;

public class ResourceDeletionFailedException extends RuntimeException{
    public ResourceDeletionFailedException(String message) {
        super(message);
    }
}
