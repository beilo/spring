<%--
  Created by IntelliJ IDEA.
  User: leipe
  Date: 2018/6/4
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>人员列表</title>

    <script language="JavaScript">
        /**
         * 批量提交方法
         */
        function deleteMuch() {
            document.forms[0].action = "${pageContext.request.contextPath}/person/deleteMuch.action";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form >
    <div style="padding:20px">
        人员列表
        ${pageContext}<br/><br/><br/>
        ${pageContext.request}<br/><br/><br/>
        ${pageContext.request.contextPath}<br/><br/><br/>
    </div>

    <div style="padding-left:40px;">
        <a href="${pageContext.request.contextPath}/person/toCreatePersonInfo.action">新增</a>   <!-- 跳转路径 -->
        <a href="#" onclick="deleteMuch()">批量删除</a>
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
                    <img src="${pageContext.request.contextPath}${p.photoPath}">
                </td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/person/toUpdatePersonInfo.action?id=${p.id}">修改</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/person/deleteById.action?id=${p.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
