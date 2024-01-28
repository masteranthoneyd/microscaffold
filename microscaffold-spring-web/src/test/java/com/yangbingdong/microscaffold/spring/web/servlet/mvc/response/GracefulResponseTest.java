package com.yangbingdong.microscaffold.spring.web.servlet.mvc.response;

import com.yangbingdong.microscaffold.spring.web.servlet.mvc.response.autoconfigure.GracefulResponseAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yangbingdong1994@gmail.com
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = {
        GracefulResponseAutoConfiguration.class,
        TestHomeController.class
})
class GracefulResponseTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testHelloWorld() throws Exception {
        mvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("HelloWorld")));
    }

    @Test
    void testGetHome() throws Exception {
        mvc.perform(get("/home/brandon")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is(ApiResponseConstants.GLOBAL_SUCCESS_MSG)))
                .andExpect(jsonPath("$.body.name", is("brandon")));
    }

    @Test
    void testClientError() throws Exception {
        mvc.perform(get("/error/client"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.msg", is("MockClientException")))
                .andExpect(jsonPath("$.code", is(ApiResponseConstants.GLOBAL_ERROR_CODE)));
    }

    @Test
    void testServerError() throws Exception {
        mvc.perform(get("/error/server"))
                .andDo(print())
                .andExpect(status().is(500))
                .andExpect(jsonPath("$.msg", is("MockServerException")))
                .andExpect(jsonPath("$.code", is(ApiResponseConstants.GLOBAL_ERROR_CODE)));
    }
}