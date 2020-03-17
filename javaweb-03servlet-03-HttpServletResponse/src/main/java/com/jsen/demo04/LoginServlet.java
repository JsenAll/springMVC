package com.jsen.demo04; /*
 *@author Jsen
 *@description
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入方法");
        req.setCharacterEncoding("utf-8");
        String usernam = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobbys");
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }

        System.out.println("用户" + usernam);
        System.out.println("密码" + password);
        System.out.println("爱好" + hobbys.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
