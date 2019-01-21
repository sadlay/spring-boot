package com.lay.spring.filter.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:16 2019/1/14
 * @Modified By:IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FilterController.class)
public class FilterControllerTest {

    private static final Logger log= LoggerFactory.getLogger(FilterControllerTest.class);
    @Autowired
    private MockMvc mvc;

    @Test
    public void testFilter() throws Exception {
        RequestBuilder request=MockMvcRequestBuilders.get("/filter");
        MvcResult result=mvc.perform(request).andDo(print()).andReturn();
        String content=result.getResponse().getContentAsString();
        int status=result.getResponse().getStatus();
        log.info("返回结果：{}",status);
        log.info("内容：{}",content);
        Assert.assertEquals(200,status);

    }
}