package com.jsen.controller;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jsen
 * @description
 */
@RestController//不走视图解析器
public class InterceptorController {

    @RequestMapping("task_01")
    public String task_01() {
        System.out.println("task_01");
        return "jhs";
    }
}
