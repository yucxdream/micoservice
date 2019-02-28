package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Author     ：yucx
 * @ Date       ：Created in 上午11:41 2018/12/10
 * @ Version    ：1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    public static void main(String[] args) {

        System.out.println("dev1");
        System.out.println("dev2");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
    }
}
