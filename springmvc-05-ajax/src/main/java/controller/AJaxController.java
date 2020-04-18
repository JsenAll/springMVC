package controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/a1")
    public User a1(String name) {
        String[] split = name.split(",");
        for (String s : split) {
            String[] strings = s.split("\"");
            String m = strings[1].replaceAll("\"", "");
            int i = name.indexOf(m);
            String substring = name.substring(i - 1, i + m.length() + 1);
            name = name.replaceAll(substring, m);
        }
        User user = new User();
        user.setAddress(name);
        return user;
    }

    @RequestMapping("/a2")
    public List<User> ajax2() {
        List<User> list = new ArrayList<User>();
        list.add(new User("秦疆1号", 3, "男"));
        list.add(new User("秦疆2号", 3, "男"));
        list.add(new User("秦疆3号", 3, "男"));
        return list; //由于@RestController注解，将list转成json格式返回
    }

}
