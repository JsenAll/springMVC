<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/18
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录成功页面</h1>
<hr>
${user}
<a href="${pageContext.request.contextPath}/logout">注销</a>
</body>
</html>
