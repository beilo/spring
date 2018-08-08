<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/7
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>新增人员列表</title>
</head>
<body>

<sf:form
        enctype="multipart/form-data"
        action="${pageContext.request.contextPath}/person/updatePersonToAllList.action"
        method="post">
    <div style="padding:20px">
        新增人员列表
    </div>

    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age" value=""/></td>
        </tr>
        <tr>
            <td>图片:</td>
            <td><input type="file" name="photo" value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="btnOK" value="保存"/>
            </td>
        </tr>
    </table>
</sf:form>

<%--<form action="${pageContext.request.contextPath}/person/updatePersonToAllList.action" method="post">--%>
<%----%>
<%--</form>--%>
</body>
</html>
