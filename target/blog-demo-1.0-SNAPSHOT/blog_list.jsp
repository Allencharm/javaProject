<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/ckform.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<style type="text/css">
body {font-size: 20px;
	padding-bottom: 40px;
	background-color: #e9e7ef;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
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
	<a href="documentAdd.jsp">发布博客</a>

	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr align="center">
				<th>博客标题</th>
				<th>博客类别</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>管理菜单</th>
			</tr>
		</thead>
		<tbody id="tbody">
		   <%--存放行数据--%>
		   <%--<tr align="center">
			   <td>蒹葭</td>
			   <td>策</td>
			   <td>小强</td>
			   <td>2016.07.22</td>
			   <td>
				   <a href="javascripe:deleteInfo()">删除 </a>
				   &nbsp;&nbsp;&nbsp;&nbsp;
				   <a href="blog_detail.jsp">博客详情</a>
			   </td>
		   </tr>--%>
		</tbody>
		<tfoot id="tfoot">
			<%--设置分页信息--%>
			<tr>
				<td colspan="5" style="text-align: right">
					<a>首页</a>
					<a>上一页</a>
					[]
					<a>下一页</a>
					<a>尾页</a>
				</td>
			</tr>
		</tfoot>
	</table>
<script type="text/javascript">
	//预加载函数，页面刚开始就执行
	$(function () {
		showList(1);
	})

	//展示列表
	function showList(currentPage) {
		$.ajax({
			url:'blog/list',
			data:'currentPage' + currentPage,
			dataType:'json',
			success:function (obj) {
				console.log(obj);
				$("#tbody").empty();

				$.each(obj.list,function (index, blog) {
					$("#tbody").append(
							'<tr align="center">' +
							'<td>' + blog.btitle + '</td>' +
							'<td>' + blog.btype.typename + '</td>' +
							'<td>' + blog.user.uname + '</td>' +
							'<td>' + msToString(blog.date) + '</td>' +
							'<td>' +
							'<a href="javascript:deleteInfo('+ blog.bid +')">删除 </a>' +
							'&nbsp;&nbsp;&nbsp;&nbsp;' +
							'<a href="blog_detail.jsp?bid='+ blog.bid + '">博客详情</a>' +
							'</td> ' +
							'</tr>'
					);
				});

				//分页
				var nums = obj.navigatepageNums;
				var str = '';
				for (var i = 0; i < nums.length; i++){
					var num = nums[i];
					if (obj.pageNum == num){
						str += '<a href="javascript:showList(' + num +')" style="color: red">' + num + '</a>';
					}else {
						str += '<a href="javascript:showList(' + num +')">' + num + '</a>';
					}
				}
				$("#tfoot").empty();
				$("#tfoot").append(
					'<tr>'+
					'<td colspan="5" style="text-align: right">'+
						'<a href="javascript:showList(1)">首页 </a>'+
						'<a href="javascript:showList('+ (obj.pageNum - 1) +')">上一页 </a>'+
								'[' + str + '] '+
						'<a href="javascript:showList('+ (obj.pageNum + 1) +')">下一页 </a>'+
						'<a href="javascript:showList('+ (obj.pages) +')">尾页</a>'+
					'</td>' +
					'</tr>'
				);
			}
		})
	}

	//删除
	function deleteInfo(bid) {
		if (confirm('是否要删除当前博客')){
			$.ajax({
				url:'blog/delete',
				data:'bid=' + bid,
				dataType:'json',
				success:function (obj) {
					console.log(obj);
					location.reload();
				}
			})
		}else{
			alert('取消了删除操作')
		}
	}
</script>
</body>
</html>
