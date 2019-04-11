<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<C:if test="${not empty  cookie.username.value}">
		<C:redirect url="/UserServlet?method=login"></C:redirect>
	</C:if>

<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登陆页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nprogress.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon.png">
<link rel="shortcut icon" href="images/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>

	<script>
        $(document).ready(function(){
            $("img[src='CodeServlet']").click(function(){
                $(this).attr("src","CodeServlet?sdfsf="+Math.random());
            });

            $("#verfy").blur(function(){

            	var code=$(this).val();

            	$.get("/UserServlet?method=checkCode&code="+code,function(data){
						if(data=='false'){
							alert('验证码输入错误！');
						}
				})



				//ajax是由js发起的，所以肯定要使用javascript提供的这个能发起请求的的ajax对象
				var  xhr=new XMLHttpRequest();//创建了一个ajax请求的对象

				xhr.onreadystatechange=function(){

					//一般来说只有ajax对象的解析状态为4，服务器状态码200，才来解析结果
					if (xhr.readyState==4 && xhr.status==200)
					{
						var result=xhr.responseText;
						if(result=='false'){
							alert('用户名不存在，请检查用户名是否是注册过的账户！');
						}

					}

				};//提前准备好告诉ajax当服务器给我回过来结构我应该调用那个方法来处理结果

				xhr.open("get","/UserServlet?method=checkUserExist&username="+username);//指定ajax要请求到后台地址

				xhr.send(null);//发起这个请求

			})






















            //这事焦点失去后判断用户名是否存在的ajax代码
            $("#username").blur(function(){
            	var  username=$(this).val();

				//ajax是由js发起的，所以肯定要使用javascript提供的这个能发起请求的的ajax对象
            	var  xhr=new XMLHttpRequest();//创建了一个ajax请求的对象

				xhr.onreadystatechange=function(){

					//一般来说只有ajax对象的解析状态为4，服务器状态码200，才来解析结果
					if (xhr.readyState==4 && xhr.status==200)
					{
						var result=xhr.responseText;
						if(result=='false'){
							alert('用户名不存在，请检查用户名是否是注册过的账户！');
						}

					}

				};//提前准备好告诉ajax当服务器给我回过来结构我应该调用那个方法来处理结果

				xhr.open("get","/UserServlet?method=checkUserExist&username="+username);//指定ajax要请求到后台地址

				xhr.send(null);//发起这个请求
			});

        })


	</script>
<script src="js/nprogress.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
<!--[if lt IE 9]>
<script>window.location.href='upgrade-browser.html';</script>

<![endif]-->
<style type="text/css">
	.panel
	{
		padding: 80px 20px 0px;
		min-height: 400px;
		cursor: default;
	}
	.text-center
	{
		margin: 0 auto;
		text-align: center;
		border-radius: 10px;
		max-width: 900px;
		-moz-box-shadow: 0px 0px 5px rgba(0,0,0,.3);
		-webkit-box-shadow: 0px 0px 5px rgba(0,0,0,.3);
		box-shadow: 0px 0px 5px rgba(0,0,0,.1);
	}
	.float-left
	{
		float: left !important;
	}
	.float-right
	{
		float: right !important;
	}
	img
	{
		border: 0;
		vertical-align: bottom;
	}
	h2
	{
		padding-top: 20px;
		font-size: 20px;
	}
	.padding-big
	{
		padding: 20px;
	}
	.alert
	{
		border-radius: 5px;
		padding: 15px;
		border: solid 1px #ddd;
		background-color: #f5f5f5;
	}
</style>
</head>
<body class="user-select">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
		<li><a href="#" >标签云</a></li>
		<li><a href="#" rel="nofollow" >读者墙</a></li>
		<li><a href="#" title="RSS订阅" >
			<i class="fa fa-rss">
			</i> RSS订阅
		</a></li>
	</ul>
			 勤记录 懂分享 </div>
  <div class="navbar-header">
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
	<h1 class="logo hvr-bounce-in"><a href="#" title="木庄网络博客"><img src="images/201610171329086541.png" alt="木庄网络博客"></a></h1>
  </div>
  <div class="collapse navbar-collapse" id="header-navbar">
	<form class="navbar-form visible-xs" action="/Search" method="post">
	  <div class="input-group">
		<input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
	<ul class="nav navbar-nav navbar-right">
	  <li><a data-cont="木庄网络博客" title="木庄网络博客" href="index.jsp">首页</a></li>
	  <li><a data-cont="列表页" title="列表页" href="list.jsp">列表页</a></li>
	  <li><a data-cont="详细页" title="详细页" href="show.jsp">详细页</a></li>
	  <li><a data-cont="404" title="404" href="404.jsp">404</a></li>
	  <li><a data-cont="MZ-NetBolg主题" title="MZ-NetBolg主题" href="#" >MZ-NetBolg主题</a></li>
	  <li><a data-cont="IT技术笔记" title="IT技术笔记" href="#" >IT技术笔记</a></li>
	  <li><a data-cont="源码分享" title="源码分享" href="#" >源码分享</a></li>
	  <li><a data-cont="靠谱网赚" title="靠谱网赚" href="#" >靠谱网赚</a></li>
	  <li><a data-cont="资讯分享" title="资讯分享" href="#" >资讯分享</a></li>
	</ul>
  </div>
</div>
</nav>
</header>
<section class="container">

<div class="panel">
<div class="text-center">
  <h2><stong>用户登陆</stong></h2>
	<div class="padding-big"> <a href="register.jsp" class="btn btn-primary" >注册</a>
	</div>
	<div class="padding-big">
		<% request.setCharacterEncoding("utf-8"); %>
		<b style="color: red;">${requestScope.errorMessage}</b>
		<form action="UserServlet?method=login" method="post">
			username:<input id="username" type="text" name="username" value="${cookie.username.value}"><br/>
			password:<input type="password" name="password" value="${cookie.password.value}"><br/>
			验证码:<input id="verfy" type="text" name="inputCode" style="width: 60px"/><img src="CodeServlet"/><br/>

			<C:choose>
				<C:when test="${empty cookie.username.value}">
					<input type="checkbox" name="rememberMe" value="true" />三天免登陆<br/>
				</C:when>
				<C:otherwise>
					<input type="checkbox" name="rememberMe" value="true"  checked="checked"/>三天免登陆<br/>
				</C:otherwise>
			</C:choose>

			<input type="submit" value="登陆">
		</form>


	</div>

</div>
</div>
</section>
<footer class="footer">
<div class="container">
	<p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
  </div>
<div id="gotop" style="display: block;"><a class="gotop" ></a>
</div>
</footer>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<%-- test--%>
<%/** test**/%>
<!--test -->
</body>
</html>
