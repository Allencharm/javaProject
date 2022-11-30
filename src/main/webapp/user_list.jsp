<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>

<form id="form1" class="form-inline definewidth m20" action="#" method="get">
     <font color="#777777"><strong>用户名：</strong></font>
    <input type="text" name="uname" id="uname" class="abc input-default " placeholder="请填写用户名" value="">&nbsp;&nbsp;
    <button type="button" class="btn btn-primary queryBtn">查询</button>
</form>

<table id="usertable" class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>Email</th>
        <th>注册日期</th>
        <th>冻结账户</th>
     </tr>
    </thead>
   <tbody id="tbody">
       <%--填写用户列表数据--%>
       <tr>
           <td><a href="user_detail.jsp">小强</a></td>
           <td>何方强</td>
           <td>154987@163.com</td>
           <td>2021-4-4 15:45</td>
           <td><button type="submit">注销</button></td>
       </tr>
   </tbody>
</table>

</body>
</html>