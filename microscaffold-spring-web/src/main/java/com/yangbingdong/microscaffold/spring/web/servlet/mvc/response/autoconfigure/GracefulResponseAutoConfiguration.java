package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.autoconfigure;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.GlobalExceptionHandler;
import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.GlobalResponseBodyAdvice;
import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.ValidationExceptionAdvice;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author yangbingdong1994@gmail.com
 */
@AutoConfiguration
public class GracefulResponseAutoConfiguration {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public GlobalResponseBodyAdvice globalResponseBodyAdvice() {
        return new GlobalResponseBodyAdvice();
    }

    @Bean
    public ValidationExceptionAdvice validationExceptionAdvice() {
        return new ValidationExceptionAdvice();
    }
}
