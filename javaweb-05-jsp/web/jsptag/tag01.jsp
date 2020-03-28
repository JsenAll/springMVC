<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>tag01</title>

</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");//防止中文乱码
%>
<jsp:forward page="tag02.jsp">
    <jsp:param name="name" value="蒋厚森"/>
    <jsp:param name="pwd" value="jhs123"/>
</jsp:forward>


</body>

</html>