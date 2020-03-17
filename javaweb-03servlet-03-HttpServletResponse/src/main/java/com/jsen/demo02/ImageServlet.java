package com.jsen.demo02;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Jsen
 * @description 验证码
 */

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //让浏览器3秒自动刷新
        resp.setHeader("refresh", "3");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D graphics = (Graphics2D) image.getGraphics();//获取画笔
        //设置画笔的颜色
        graphics.setColor(Color.BLACK);
        //填充
        graphics.fillRect(0, 0, 80, 20);
        graphics.setColor(Color.BLUE);
        //设置字体
        graphics.setFont(new Font(null, Font.BOLD, 20));

        graphics.drawString(makeNum(), 0, 20);

        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");


        //把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    //生成随机数
    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        System.out.println(Thread.currentThread().getName() + "-->num=" + num);
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
