<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/4
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作信息 PersonWork</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/demowizard.action" method="post">
        <table>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="id" value="${p.age}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="_target1" value="上一步"/>
                    <input type="submit" name="_cancel" value="取消"/>
                    <input type="submit" name="_finish" value="完成"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
