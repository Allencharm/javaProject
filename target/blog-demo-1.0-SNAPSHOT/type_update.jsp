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
<body>
<font color="#777777"><strong>修改大类：</strong></font> 
<form id="typeForm2" action="#" method="post" class="definewidth m20" >
<table style="margin-left:10px;margin-top:3px;">
    <input type="hidden" id="typeid"  name="typeid"/>
    <tr>
         <td>大类名称：</td>
		 <td><input type="text" id="typename"  name="typename"/></td>
    </tr>
	<tr>
         <td>介绍：</td>
		 <td><input type="text" id="typedes" name="typedes" style="height: 200px;wight:200px;"/></td>
    </tr>
    <tr>
       <td>
            <button style="margin-left:5px;" onclick="updateBigType()" class="btn btn-primary" >保&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp存</button> &nbsp;&nbsp;
           <button type="button" class="btn btn-success" name="backid" id="backid"> <a href="type_list.jsp"> 返回列表</a></button>
        </td>
    </tr>
</table>
</form>

<script type="text/javascript">
    $(function () {
        showOne();
    })

    //更新大类内容
    function updateBigType() {
        $.ajax({
            url:'type/updateBigType',
            type:'post',
            data:$("#typeForm2").serialize(),
            dataType:'json',
            success:function(obj) {
                console.log(obj);
                alert("更改成功")
                location.href = "type_list.jsp";
            }
        })
    }

    //显示大类内容
    function showOne() {
        $.ajax({
            url:'type/showOne',
            data:'tid=${param.bid}',
            dataType:'json',
            success:function(obj) {
                console.log(obj);
                $("#typeid").val(obj.typeid);
                $("#typename").val(obj.typename);
                $("#typedes").val(obj.typedes);
            }
        })
    }
</script>

</body>
</html>

