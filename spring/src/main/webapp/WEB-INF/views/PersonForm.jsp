<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/4
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员列表</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/personform.action" method="post">
        <table>
            <tr>
                <td>编号:</td>
                <td><intput type="text" name="id" /></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><intput type="text" name="name" /></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><intput type="text" name="age" /></td>
            </tr>
            <tr>
                <td colspan="2"><intput type="button" name="btnOK" value="submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
