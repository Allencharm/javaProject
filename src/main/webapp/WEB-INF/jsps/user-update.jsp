<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/11/18
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/edit" method="post">
    <input type="hidden" name="_method" value="put">
    <p><input name="uid" value="${user.uid}" readonly></p>
    <p><input name="uname" value="${user.uname}"></p>
    <p><input name="upwd" value="${user.upwd}"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
