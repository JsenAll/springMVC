
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index01</title>
</head>
<body>
$END$

<%
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>

<%= new java.util.Date() %>

<%!
    static {
        System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void kuang() {
        System.out.println("进入了方法Kuang！");
    }
%>




<%
  for (int i = 0; i < 5; i++) {
%>
<h1>Hello,World i </h1>
<%
  }
%>
</body>
</html>
