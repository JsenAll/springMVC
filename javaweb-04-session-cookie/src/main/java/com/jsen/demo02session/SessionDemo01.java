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

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决乱码
        req.setCharacterEncoding("Utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取session
        HttpSession session = req.getSession();

        //geiSession 塞东西
        session.setAttribute("name", new User("蒋厚森", 20));

        //获取sessionid
        String sessionId = session.getId();

        //判断session 是不是新创建的
        if (session.isNew())
            resp.getWriter().write("session 创建成功--ID:" + sessionId);
        else
            resp.getWriter().write("已存在--ID:" + sessionId);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
