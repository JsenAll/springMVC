<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>tag01</title>

</head>
<body>

<form action="tag03.jsp" method="get" accept-charset="UTF-8">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="提交">
</form>
<%--<form action="tag03.jsp" method="get">--%>
<%--    &lt;%&ndash;--%>
<%--    EL表达式获取表单中的数据--%>
<%--    ${param.参数名}--%>
<%--    &ndash;%&gt;--%>
<%--    <input type="text" name="username" value="${param.username}">--%>
<%--    <input type="submit" value="登录">--%>
<%--</form>--%>

<%--判断如果提交的用户名是管理员，则登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎您！"/>
</c:if>
<%= request.getParameter("username")%>

<c:out value="${isAdmin}"/>

<%--自闭合标签--%>

</body>

</html>