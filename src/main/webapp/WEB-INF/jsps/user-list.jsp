<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/11/17
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
</head>
<body>
<table border="1" cellpadding="0" width="100%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>pwd</th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <th>${user.uid}</th>
            <th>${user.uname}</th>
            <th>${user.upwd}</th>
            <th>
                <a href="edit/${user.uid}" >修改</a>
                <form action="delete" method="post" id="deleteForm">
                    <input type="hidden" name="_method" value="delete">
                    <input type="hidden" name="uid" id="uid">
                    <a href="javascript:deleteUser(${user.uid})" >删除</a>
                </form>
            </th>
        </tr>
    </c:forEach>

</table>
<script>
    function deleteUser(id) {
        if (confirm("确定要删除当前项吗？")){
            //location.href = "delete?uid=" + id;
            $("#uid").val(id);
            $("#deleteForm").submit();
        }else{
            alert("取消删除操作")
        }
    }
</script>
</body>
</html>
