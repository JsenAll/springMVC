<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/31
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--
    文件上传必须要: enctype="multipart/form-data"


--%>
<form action="/downfile" enctype="multipart/form-data" method="post">
    <input type="file" name="file1">
    <input type="submit">
    <input type="reset">

</form>
</body>
</html>
