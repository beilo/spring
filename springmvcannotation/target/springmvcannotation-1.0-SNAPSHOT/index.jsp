<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/4
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index jsp</title>
</head>
<body>
This is my Spring MVC index!

<a href="${pageContext.request.contextPath}/person/all.action">显示人员列表</a>
<img src="${pageContext.request.contextPath}/11/dog.gif" alt="">
</body>
</html>
