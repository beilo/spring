<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/7
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>人员修改</title>
</head>
<body>
<!-- 其中，modelAttribute 属性用于接收设置在 Model 中的对象，必须设置，否则会报 500 的错误 -->
<sf:form
        enctype="multipart/form-data"
        modelAttribute="person"
        action="${pageContext.request.contextPath}/person/updatePersonToAllList" method="post">
    <!-- 添加隐藏域，隐藏 id  -->
    <input type="hidden" name="id" value="${person.id}"/>
    <div style="padding:20px;">
        修改人员信息
    </div>
    <div style="padding:10px">
        错误信息: <font color="red"><sf:errors path="*"/> </font>
    </div>

    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" value="${person.name}"/></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age" value="${person.age}"/></td>
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
</body>
</html>
