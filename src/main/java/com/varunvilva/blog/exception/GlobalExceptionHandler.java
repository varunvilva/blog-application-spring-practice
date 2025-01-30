package com.varunvilva.blog.exception;

import com.varunvilva.blog.dto.out.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(Exception ex){
        return ResponseEntity.status(HttpStatus.valueOf(400)).body(new ErrorResponse(ex.getMessage(), "BAD REQUEST"));
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(Exception ex){
        return ResponseEntity.status(HttpStatus.valueOf(409)).body(new ErrorResponse(ex.getMessage(), "CONFLICT"));
    }
    @ExceptionHandler(ResourceNotFoundExcpetion.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundExcpetion(Exception ex){
        return ResponseEntity.status(HttpStatus.valueOf(404)).body(new ErrorResponse(ex.getMessage(), "NOT FOUND"));
    }
    @ExceptionHandler(ResourceDeletionFailedException.class)
    public ResponseEntity<ErrorResponse> handleResourceDeletionFailedException(Exception ex){
        return ResponseEntity.status(HttpStatus.valueOf(409)).body(new ErrorResponse(ex.getMessage(), "BAD REQUEST"));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(Exception ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Incorrect username or password", "BAD CREDENTIALS"));
    }

    @ExceptionHandler(RoleMismatchException.class)
    public ResponseEntity<ErrorResponse> handleRoleMismatchException(Exception ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(ex.getMessage(), "BAD CREDENTIALS"));
    }




}
