<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>

</head>
<body>
<%
    pageContext.setAttribute("name1", "秦疆1号"); //保存的数据只在一个页面中有效
    request.setAttribute("name2", "秦疆2号"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3", "秦疆3号"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4", "秦疆4号");  //保存的数据只在服务器中有效，从打开服务器到关闭服务器

    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
%>
<h1> 取值 <h1>
    ${name1}
    ${name2}
    ${name3}
    ${name4}

</body>

</html>
