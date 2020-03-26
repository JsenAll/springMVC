package com.jsen.demo01cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");//防止页面乱码


        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                if ("name".equals(name)) {
                    String value = cookies[i].getValue();
                    System.out.println("解码前2-1" + value);
                    value = URLDecoder.decode(value, "UTF-8");//防止乱码
                    System.out.println("解码后2-2" + value);
                    resp.getWriter().println(value);
                }
            }
        }
        String myName = "蒋厚森";
        System.out.println(URLEncoder.encode(myName, "GBK"));
        System.out.println("转码前1-1" + myName);
        myName = URLEncoder.encode(myName, "UTF-8");
        System.out.println("转码后1-2" + myName);
        Cookie cookie = new Cookie("name", myName);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}