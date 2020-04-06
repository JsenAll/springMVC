package com.jsen.controller.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.text.normalizer.UnicodeSet;

/**
 * 前端请求 url  与 后端  接受 方法
 */
@Controller
public class Demo01 {

    //http://localhost:8080/demo?userName=jhs
    @RequestMapping("/demo")
    public String text01(String userName, Model model) {
        model.addAttribute("msg", userName);
        return "hello";
    }

    //http://localhost:8080/demo01?name=jhs
    @RequestMapping("/demo01")
    public String text02(@RequestParam("name") String userName, Model model) {
        model.addAttribute("msg", userName);
        return "hello";
    }

    @RequestMapping("/demo03")
    public String text03(User user, Model model) {
        model.addAttribute("msg", user);
        return "hello";

    }

}
