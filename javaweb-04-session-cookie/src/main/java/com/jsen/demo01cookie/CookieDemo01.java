package com.jsen.demo01cookie;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jsen
 * @description 利用Cookie 保存用户上一次使用时间
 */

public class CookieDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");//防止页面乱码
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();//获得Cookie

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                if ("lastTime".equals(name)) {
                    out.write("最后一次访问的时间是:" + cookies[i].getValue());
                } else {
                    out.println(name);
                }

            }
        } else {
            System.out.println("你是第一次访问  欢迎光临");
            out.write("你是第一次访问  欢迎光临");
        }
        Cookie cookie = new Cookie("lastTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(60); //设置cookie的有效期  24*60*60  =>24 小时  没设置 关闭浏览器 就失效了
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
