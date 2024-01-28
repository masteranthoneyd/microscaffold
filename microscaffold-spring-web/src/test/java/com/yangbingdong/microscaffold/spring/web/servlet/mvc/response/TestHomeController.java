package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ClientException;
import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.model.ServerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangbingdong1994@gmail.com
 */
@RestController
public class TestHomeController {

    @RequestMapping("/hello")
    public String greeting() {
        return "HelloWorld";
    }

    @GetMapping("/home/{name}")
    public TestHome getHome(@PathVariable String name) {
        return new TestHome(name);
    }

    @GetMapping("/error/client")
    public void clientError() {
        throw new ClientException("MockClientException");
    }

    @GetMapping("/error/server")
    public void serverError() {
        throw new ServerException("MockServerException");
    }

    public record TestHome(String name) {}

}
