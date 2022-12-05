<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquerypicture.js"></script>

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
<body><br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<font color="#777777"><strong>添加小类：</strong></font> 
<form class="definewidth m20" id="typeForm2">
<table style="margin-left:10px;margin-top:3px;">
    <%--页面传递的typeid 充当typePid--%>
    <input type="hidden" name="typePid" value="${param.typeid}"/>
    <tr>
         <td>小类名称：</td>
		 <td><input type="text" name="typename" style="width:400px;" placeholder='请输入小类名称'/></td>
    </tr>

	<tr>
         <td>介绍：</td>
		 <td><input type="text" name="typedes" style="height: 100px;width:400px;" placeholder='请输入小类详情'/></td>
    </tr>
	
    <tr>
        <td></td>
       <td>
           <a style="margin-left:5px;" class="btn btn-primary" onclick="smallAdd()" >保&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp存</a>
           <a style="margin-left:5px;" class="btn btn-success" href="type_list.jsp"> 返回列表</a>
        </td>
    </tr>
</table>
</form>
<script type="text/javascript">

    function smallAdd() {
        $.ajax({
            url:'type/smallAdd',
            type:'post',
            data:$("#typeForm2").serialize(),
            dataType:'json',
            success:function(obj) {
                console.log(obj);
                location.href = 'subtype_list.jsp?bid=${param.typeid}';
            }
        })
    }
</script>
</body>
</html>


