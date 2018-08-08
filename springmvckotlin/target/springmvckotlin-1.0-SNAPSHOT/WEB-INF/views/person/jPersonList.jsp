<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/7
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>人员列表</title>

    <script language="JavaScript">

        function deleteList() {
            document.forms[0].action = "${pageContext.request.contextPath}/person/deleteList.action"
            document.forms[0].submit()
        }
    </script>
</head>
<body>
<form>
    <div style="padding: 20px;">
        人员列表<br/>
        ${pageContext}<br/>
        ${pageContext.request}<br/>
        ${pageContext.request.contextPath}<br/>
    </div>

    <div style="padding: 20px;">
        <a href="${pageContext.request.contextPath}/person/toCreatePersonInfo">新增人员</a>
        <a href="#" onclick="deleteList()">批量删除</a>
    </div>

    <table border="1">
        <tr>
            <td>选择:</td>
            <td>头像:</td>
            <td>编号:</td>
            <td>姓名:</td>
            <td>年龄:</td>
            <td>操作:</td>
        </tr>

        <c:forEach items="${personList}" var="p">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${p.id}"/>
                </td>
                <td>
                    <img src="${pageContext.request.contextPath}${p.photoPath}" alt="图片加载失败"/>
                </td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/person/toUpdatePersonInfo?id=${p.id}">修改</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/person/deleteById?id=${p.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
