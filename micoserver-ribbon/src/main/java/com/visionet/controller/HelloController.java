package com.visionet.controller;

import com.visionet.event.TestEvent;
import com.visionet.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 下午2:29 2018/12/7
 * @ Version    ：1.0
 */
@RestController
public class HelloController {


    @Autowired
    private ApplicationContext application;

    @Autowired
    HelloService helloService;

    List list =new ArrayList();

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }


    @RequestMapping("/testListener")
    public void test(){
        list.add(1);
        list.add(2);
        System.out.println("1111111111"+Thread.currentThread().getName());


        application.publishEvent(new TestEvent(list));

        System.out.println("333333333333");

    }
}
