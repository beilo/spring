<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/7
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页 index.jsp</title>
</head>
<body>
This is my Spring MVC index <br/><br/><br/>
<a href="${pageContext.request.contextPath}/person/all.action">显示人员列表</a> <br/><br/><br/>
<img src="${pageContext.request.contextPath}/11/dog.gif" alt="加载图片失败"/>
</body>
</html>
