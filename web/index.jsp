
<%@ page import="edu.hbuas.blog.control.BlogServlet" %>
<%@ page import="edu.hbuas.blog.model.javabean.Blogs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<C:if test="${empty requestScope.allBlogs}">
	<C:redirect url="/BlogServlet?method=listTopBlogs&page=1&count=10"></C:redirect>
</C:if>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nprogress.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon.png">
<link rel="shortcut icon" href="images/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/nprogress.js"></script>

<!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>
<body class="user-select">

<!-- 这html的注释语法，这些语法会在客户端浏览器上看得到-->

<%-- 这事服务器注释语法，jsp注释语法，该语法不会发送到客户端，所以用户段看不到--%>

<% /**这事java代码，注释客户端依然看不到 **/  %>

<%@include file="top.jsp"%>
<section class="container">
<div class="content-wrap">
<div class="content">
  <div id="focusslide" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
	  <li data-target="#focusslide" data-slide-to="0" class="active"></li>
	  <li data-target="#focusslide" data-slide-to="1"></li>
	</ol>
	<div class="carousel-inner" role="listbox">
	  <div class="item active">
	  <a href="#" target="_blank" title="木庄网络博客源码" >
	  <img src="images//201610181557196870.jpg" alt="木庄网络博客源码" class="img-responsive"></a>
	  </div>
	  <div class="item">
	  <a href="#" target="_blank" title="专业网站建设" >
	  <img src="images//201610241227558789.jpg" alt="专业网站建设" class="img-responsive"></a>
	  </div>
	</div>
	<a class="left carousel-control" href="#focusslide" role="button" data-slide="prev" rel="nofollow"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">上一个</span> </a> <a class="right carousel-control" href="#focusslide" role="button" data-slide="next" rel="nofollow"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">下一个</span> </a> </div>
  <article class="excerpt-minic excerpt-minic-index">
		<h2><span class="red">【推荐】</span><a target="_blank" href="#" title="用DTcms做一个独立博客网站（响应式模板）" >用DTcms做一个独立博客网站（响应式模板）</a>
		</h2>
		<p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
	</article>
  <div class="title">
	<h3>最新发布</h3>
	<div class="more">                
			<a href="#" title="MZ-NetBlog主题" >MZ-NetBlog主题</a>
			<a href="#" title="IT技术笔记" >IT技术笔记</a>                
			<a href="#" title="源码分享" >源码分享</a>                
			<a href="#" title="靠谱网赚" >靠谱网赚</a>                
			<a href="#" title="资讯分享" >资讯分享</a>                
		</div>
  </div>

	<div id="allContent">
    <C:forEach var="b" items="${requestScope.allBlogs}"   varStatus="s">
        <article class="excerpt excerpt-5" style="">
			<div style="float: left; width: 70%;">
				<a class="focus" href="#" title="${b.title}" target="_blank" ><img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
				<header><a class="cat" href="#" title="java板块" >java板块<i></i></a>
					<h2><a href="BlogServlet?method=getDetailOfBlogById&blogid=${b.blogid}" title="${b.title}" target="_blank" >${b.blogid}---${b.title}</a>
					</h2>
				</header>
				<p class="meta">
					<time class="time"><i class="glyphicon glyphicon-time"></i>${b.publishtime}</time>
					<span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${b.visitedcount}</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i>0</a>
				</p>
				<p class="note">${fn:substring(b.content, 0,40)} ...</p>


			</div>
			<div style="float: left; width: 30%">
						<a href="/UserServlet?method=loadUserInfo&userid=${b.user.userid}"><img src="${b.user.image}" width="40px" height="40px" style="border: 1px solid gray; border-radius: 20px"/></a><br/>
						博主:${b.user.nickname}

			</div>
        </article>
    </C:forEach>

	</div>
	<img id="loadImg" src="images/load.gif" style="width: 200px;height: 60px;display: none;"/>
	<nav class="pagination" style="display: none;">
	<ul>
	  <li class="prev-page"></li>
	  <li class="active"><span>1</span></li>
	  <li><a href="?page=2">2</a></li>
	  <li class="next-page"><a href="?page=2">下一页</a></li>
	  <li><span>共 2 页</span></li>
	</ul>
  </nav>
</div>
</div>
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
<aside class="sidebar">
<div class="fixed">
  <div class="widget widget-tabs">
	<ul class="nav nav-tabs" role="tablist">
	  <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab" data-toggle="tab" >统计信息</a></li>
	  <li role="presentation"><a href="#contact" aria-controls="contact" role="tab" data-toggle="tab" >联系站长</a></li>
	</ul>
	<div class="tab-content">
	  <div role="tabpanel" class="tab-pane contact active"  id="notice">

	  </div>
		<div role="tabpanel" class="tab-pane contact" id="contact">
		  <h2>QQ:
			  <a href="" target="_blank" rel="nofollow" data-toggle="tooltip" data-placement="bottom" title=""  data-original-title="QQ:"></a>
		  </h2>
		  <h2>Email:
		  <a href="#" target="_blank" data-toggle="tooltip" rel="nofollow" data-placement="bottom" title=""  data-original-title="#"></a></h2>
	  </div>
	</div>
  </div>
  <div class="widget widget_search">
	<form class="navbar-form" action="/Search" method="post">
	  <div class="input-group">
		<input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
  </div>
</div>
<div class="widget widget_hot">
	  <h3>最新评论文章</h3>
	  <ul>            
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
				<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
			</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
				2016-11-01
			</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>

	  </ul>
 </div>
 <div class="widget widget_sentence">    
	<a href="#" target="_blank" rel="nofollow" title="专业网站建设" >
	<img style="width: 100%" src="images//201610241224221511.jpg" alt="专业网站建设" ></a>    
 </div>
 <div class="widget widget_sentence">    
	<a href="#" target="_blank" rel="nofollow" title="MZ-NetBlog主题" >
	<img style="width: 100%" src="images/ad.jpg" alt="MZ-NetBlog主题" ></a>    
 </div>
<div class="widget widget_sentence">
  <h3>友情链接</h3>
  <div class="widget-sentence-link">
	<a href="#" title="网站建设" target="_blank" >网站建设</a>&nbsp;&nbsp;&nbsp;
  </div>
</div>
</aside>
</section>
<%@include file="footer.jsp"%>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<input type="hidden" value="1" name="nowPage"/>
<script>
	$(document).ready(function() {
		$.get("http://localhost:8080/CarShop/CarServlet?method=mohuSearch&key=",function(data){
			alert(data);
		});



		$(window).scroll(function() {

			if ($(document).scrollTop()<=0){
				//alert("滚动条已经到达顶部");
			}

			if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
				//当鼠标滚动到网页底部，发起ajax加载下一页
				var nowPage=$("[name='nowPage']").val();



				$.ajax({
					type:"get",
					url:"/BlogServlet?method=listBlogsByAjaxPage&page="+(parseInt(nowPage)+1)+"&count=10",
					beforeSend:function(){
						$("#loadImg").show(50);
					},
					complete:function(){
						$("#loadImg").hide(1);
					},
					success:function(data){
						for(var n=0;n<data.length;n++){
							$("#allContent").append("<article class='excerpt excerpt-5' style=''><a class='focus' href='#' title='"+data[n].title+"' target='_blank' ><img class='thumb' data-original='images/201610181739277776.jpg' src='images/201610181739277776.jpg' alt='用DTcms做一个独立博客网站（响应式模板）'  style='display: inline;'></a><header><a class='cat' href='#' title='java板块' >java板块<i></i></a><h2><a href='BlogServlet?method=getDetailOfBlogById&blogid="+data[n].blogid+"' title='"+data[n].title+"' target='_blank' >"+data[n].blogid+"---"+data[n].title+"</a></h2></header><p class='meta'><time class='time'><i class='glyphicon glyphicon-time'></i>"+data[n].publishTime+"</time><span class='views'><i class='glyphicon glyphicon-eye-open'></i> "+data[n].visitedCount+"</span> <a class='comment' href='##comment' title='评论' target='_blank' ><i class='glyphicon glyphicon-comment'></i>0</a></p><p class='note'>"+data[n].content+" ...</p></article>\n");
						}
					}

						});
				$("[name='nowPage']").val(parseInt(nowPage)+1);
			}
		});
	});

</script>

<script src="js/jquery.lazyload.min.js"></script>
<script>
	function callbackAAA(data){
			$("#notice").append("您所在的城市："+data.city+"<br/>");
			$("#notice").append("PM2.5："+data.pm25+"<br/>");
			$("#notice").append("天气："+data.weather[0].weather+"<br/>");
			$("#notice").append("风力："+data.weather[0].wind+"<br/>");
			$("#notice").append("温度："+data.weather[0].temp+"<br/>");
	}

</script>
<script>
	$.ajax({
		type:"get",
		url:"https://api.asilu.com/weather/",
		data:{"city":"襄阳"},
		dataType:"jsonp",
		jsonpCallback:"callbackAAA"
	})

</script>
</body>
</html>
