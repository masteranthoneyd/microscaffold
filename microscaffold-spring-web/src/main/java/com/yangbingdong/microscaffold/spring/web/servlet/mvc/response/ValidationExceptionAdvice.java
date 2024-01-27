package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * @author yangbingdong1994@gmail.com
 *
 * 处理校验失败场景异常, 并返回 400 http code
 */
@Order(100)
@RestControllerAdvice
public class ValidationExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiResponse> bindExceptionHandler(BindException ex) {
        String msg = ex.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(joining(";"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail(msg));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        String msg = allErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(joining(";"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail(msg));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violationSet = ex.getConstraintViolations();
        String msg = violationSet.stream()
                .map(s -> s.getConstraintDescriptor().getMessageTemplate())
                .collect(Collectors.joining(";"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail(msg));
    }

}
