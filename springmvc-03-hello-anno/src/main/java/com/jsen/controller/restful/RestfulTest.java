package com.jsen.controller.restful;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestfulTest {

    //普通 url 形式
    //http://localhost:8080/add?a=2&b=6
    @RequestMapping("/add")
    public String add(int a, int b, Model model) {
        model.addAttribute("msg", a + "+" + b + "=" + (a + b));

        return "hello";
    }

    //使用 restful 风格后 url 形式
    // http://localhost:8080/addR/2/6
    @RequestMapping("/addR/{a}/{b}")
    public String addRestful(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("msg", a + "+" + b + "=" + (a + b));
        model.addAttribute("info", "使用了restful 风格的 url");
        return "hello";
    }

    // http://localhost:8080/addR/2/6
    @PostMapping("/addR/{a}/{b}")
    public String addRestful2(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("msg", a + "*" + b + "=" + (a * b));
        model.addAttribute("info", "post 后台接收 形式1:        @PostMapping(\"/addR/{a}/{b}\")\n");

        return "hello";
    }

    // http://localhost:8080/add3/2/0
    @RequestMapping(value = "/add3/{a}/{b}", method = RequestMethod.POST)
    public String addRestful3(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("msg", a + "*" + b + "=" + (a * b));
        model.addAttribute("info", "post 后台接收 形式2:    @RequestMapping(value = \"/add3/{a}/{b}\", method = RequestMethod.POST)");
        return "hello";
    }

}
