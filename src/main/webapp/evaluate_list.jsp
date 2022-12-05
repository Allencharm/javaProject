<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/main.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>

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
<form class="form-inline definewidth m20" action="#" method="get">
     <font color="#777777"><strong>查询评价：</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询评价</button>&nbsp;&nbsp; 
	
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>评价内容</th>
        <th>评价人</th>
        <th>博客标题</th>
        <th>评价时间</th>
        <th>操作</th>
    </tr>
    </thead>
	    <tbody id="evaTbody">
        <tr>
                
                <td>你来人间一趟，你要看看太阳，和你的心上人，一起走在街上。</td>
				<td><a href="user_detail.jsp">小强</a></td>
                <td>你好,李焕英观后感</td>
                <td>2016.02.12</td>
                <td><button type="button"  id="deletecomment">删除</button></td>
               
        </tr>
        </tbody>
</table>

<script type="text/javascript">

    $(function () {
        showEvalute();
    })

    function showEvalute() {
        $.ajax({
            url:'evaluate/list',
            dataType:'json',
            success:function(obj) {
                console.log(obj);
                $("#evaTbody").empty();
                $.each(obj.list,function (index,eva) {
                    $("#evaTbody").append(
                        '<tr>'+
                        '<td>' + eva.econtent + '</td>'+
                        '<td><a href="user_detail.jsp">'+ eva.user.uname +'</a></td>'+
                        '<td>'+eva.blog.btitle+'</td>'+
                        '<td>'+ msToString(eva.etime) +'</td>'+
                        '<td><button type="button"  id="deletecomment">删除</button></td>'+
                        '</tr>'
                    )
                })
            }
        })
    }
</script>
</body>
</html>
