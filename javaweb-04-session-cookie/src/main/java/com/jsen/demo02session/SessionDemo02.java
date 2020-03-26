package com.jsen.demo02session;
/**
 * @author Jsen
 * @description session
 */

import com.jsen.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决乱码
        req.setCharacterEncoding("Utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取session
        HttpSession session = req.getSession();

        //geiSession 塞东西
        User name = (User) session.getAttribute("name");


        //判断session 是不是新创建的
        if (name != null)
            resp.getWriter().write(name.toString());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
