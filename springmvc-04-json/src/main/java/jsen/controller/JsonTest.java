package jsen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jsen.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Jsen
 * // @RestController : 注解到类上面  这个类 下面的所有的 方法 都不走 视图解析 器
 * // @RequestMapping(value = "/test01", produces = "application/json;charset=utf-8") 解决乱码
 * // @RequestMapping("/test01") 没有其他的 配置话(如:统一在spring mvc 的配置文件 进行配置将不会出现乱码)  这里中文 会乱码
 */
@RestController
public class JsonTest {
    /**
     * 将 一个 对象 转化成 json  并传回 前端
     */
    @RequestMapping("/test01")
    public String test01() {
        try {
            User user = new User("蒋厚森", 10, "男");
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(user);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将 一个 集合对象 转化成 json  并传回 前端
     */
    @RequestMapping("/test02")
    public String test02() {
        try {
            User user1 = new User("蒋厚森", 10, "男");
            User user2 = new User("蒋厚森", 10, "男");
            User user3 = new User("蒋厚森", 10, "男");
            List<User> list = Arrays.asList(user1, user2, user3);
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(list);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建时间一个对象，java.util.Date
        Date date = new Date();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }
}
