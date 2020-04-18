package com.jsen.controller; /*
 *@author Jsen
 *@description
 */

import com.jsen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/jumplogin")
    public String jumplogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        System.out.println(user.toString());
        session.setAttribute("user", user);
        return "success";
    }


    @RequestMapping("/logout")
    public String logout(User user, HttpSession session) {
        System.out.println(user.toString());
        session.invalidate();
        return "login";
    }
}
