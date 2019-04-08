package com.lay.spring.event.controller;

import com.lay.spring.event.publisher.DemoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 18:49 2019/1/9
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class EventController {
    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping("/send-event")
    @ResponseBody
    public Object sendEvent(@RequestParam String msg) {
        DemoEvent demoEvent = new DemoEvent(this, msg);

        try {
            applicationEventPublisher.publishEvent(demoEvent);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("失败", e);
        }
        log.info("finish publish event");
        return "success";
    }


    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }
}
