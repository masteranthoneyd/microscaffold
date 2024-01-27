package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ApiResponse;
import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ClientException;
import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ServerException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yangbingdong1994@gmail.com
 */
@Order(200)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ApiResponse> clientExceptionHandler(ClientException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail(ex));
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ApiResponse> serverExceptionHandler(ServerException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail(ex));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiResponse> exceptionHandler(Throwable t) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail(t.getMessage()));
    }
}
