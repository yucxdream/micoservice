package com.controller;

import com.entity.User;
import com.feign.SchedualServiceHi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 下午2:42 2018/12/7
 * @ Version    ：1.0
 */
@Controller
public class HiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    @ResponseBody
    public String sayHi(@RequestParam String name) {

        return schedualServiceHi.sayHiFromClientOne( name );

    }


    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveUser(){

        User user = new User();
        user.setNickname("yu");
        user.setPassword("123456");
        user.setRoles("chun");
        user.setUsername("xiao");
    }



    @RequestMapping("/testLogger")
    public void testLog(){

        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");

    }
}
