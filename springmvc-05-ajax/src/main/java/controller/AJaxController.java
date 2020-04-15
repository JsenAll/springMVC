package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jsen
 * @description
 */
@RestController
public class AJaxController {
    @RequestMapping("/hello")
    public String text() {

        System.out.println("测试成功");
        return "nihao";
    }
}
