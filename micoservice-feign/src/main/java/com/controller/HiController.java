package com.controller;

import com.entity.User;
import com.feign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 下午2:42 2018/12/7
 * @ Version    ：1.0
 */
@Controller
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    @ResponseBody
    public String sayHi(@RequestParam String name) {

        return schedualServiceHi.sayHiFromClientOne( name );

    }


    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(){

        User user = new User();
        user.setNickname("yu");
        user.setPassword("123456");
        user.setRoles("chun");
        user.setUsername("xiao");
    }
}
