package com.visionet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 下午4:31 2018/12/7
 * @ Version    ：1.0
 */
@Controller
@RequestMapping("/testfree")
public class TestController {


    @RequestMapping("/hello")
    public String testPage(){

        return "biz/nihao";
    }
}
