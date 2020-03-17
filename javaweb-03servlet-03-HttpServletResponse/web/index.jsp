<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/16
  Time: 16:39
  To change this template use File | Settings | File Templates.\
  http://119.23.74.253:8080/img/ .jpg
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body background="http://119.23.74.253:8080/img/24.jpg">

<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        爱好:
        <input type="checkbox" name="hobbys" value="女孩">女孩
        <input type="checkbox" name="hobbys" value="男孩">男孩
        <input type="checkbox" name="hobbys" value="美女">美女
        <input type="checkbox" name="hobbys" value="帅哥">帅哥
        <input type="checkbox" name="hobbys" value="苍老师">苍老师
        <input type="submit">
    </form>
</div>

</body>
</html>
