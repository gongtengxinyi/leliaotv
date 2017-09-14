<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>乐聊TV首页</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="/css/style.css">
	
	<!-- Owl Carousel Assets -->
    <link href="/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="/owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="/font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	
	<!-- jQuery -->
	<script src="/js/jquery.min.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="/js/bootstrap.min.js"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    .index_img{
    width: 200px;
    height: 150px;
    }
    </style>
</head>

<body>
<header>
	<!--Navigation-->
    <nav id="menu" class="navbar">
		<div class="container">
			<div class="navbar-header">
			  <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/liver/gotoliveRegister"><i class="fa fa-home"></i> 开启直播</a></li>
		<li class="dropdown">
		<a href="https://github.com/gongtengxinyi"  target="_blank">
		<i class="fa fa-user">
		</i>github 账号
		</a>				
					</li>
					
					
					<li class="dropdown">
		<a href="/dispatcherLogin" >
		<i class="fa fa-user">
		</i>登录
		</a>				
					</li>
					
					<li>
		<a id="modal-482295" href="#modal-container-482295" role="button" class="btn" data-toggle="modal"><i class="fa fa-play-circle-o"></i>
		 视频</a>				
					</li>
						<li>
		<a id="modal-482292" href="#contact" role="button" class="btn" data-toggle="modal"><i class="fa fa-cubes"></i>
		 联系作者</a>				
					</li>
						<li>
		<a id="modal-482296" href="#dashang" role="button" class="btn" data-toggle="modal"><i class="fa fa-cubes"></i>
		打赏</a>				
					</li>				
				</ul>
			</div>
		</div>
	</nav>	
</header>
			
			
	<div class="modal fade" id="dashang" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								友情提示
							</h4>
						</div>
						<div class="modal-body">
						<img src="/images/b.png"  style="height: 300px;width: 300px" class="img-rounded">
                     	<img src="/images/c.png"  style="height: 300px;width: 300px" class="img-rounded">
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
			
			<div class="modal fade" id="contact" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								友情提示
							</h4>
						</div>
						<div class="modal-body">
						<p> qq:1251272104</p>
						<img src="/images/a.png"  style="height: 300px;width: 300px" class="img-rounded">
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
			
			
			<div class="modal fade" id="modal-container-482295" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								友情提示
							</h4>
						</div>
						<div class="modal-body">
						爬虫正在编写，近期开放，请稍等~
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
	<div id="page-content" class="index-page">
	
		<div class="container">
			<div class="row">
				<div class="featured">
					<div class="main-vid">
						<div class="col-md-6">
							<div class="zoom-container">
								<div class="zoom-caption">
									<span>视频标签</span>
									<a href="/room/enter/1?chatUserId=${chatUserId }">
										<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
									</a>
									<p>作者直播间</p>
								</div>
								<img src="/images/1.jpg" />
							</div>
						</div>
					</div>
					<div class="sub-vid">
						<div class="col-md-3">
						
						<#list roomListTop as roomTop>
						<div class="zoom-container">
								<div class="zoom-caption">
									<span>${roomTop.liveType }</span>
									<a href="/room/enter/${roomNum}?chatUserId=${chatUserId }">
										<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
									</a>
									<p>${roomTop.roomName }</p>
								</div>
								<img  style="width: 200px;height: 150px"  src="${roomTop.roomImg }" />
							</div>
						</#list>
						
							
						
						</div>
						<div class="col-md-3">
						<#list roomListBottom as roomBottom>
							<div class="zoom-container">
								<div class="zoom-caption">
									<span>${roomBottom.liveType }</span>
								<a href="/room/enter/${roomNum}?chatUserId=${chatUserId }">
										<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
									</a>
									<p>${roomBottom.roomName }</p>
								</div>
								<img style="width: 200px;height: 150px" src="${roomBottom.roomImg }" />
							</div>
							</#list>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-8">
					<div class="box">
						<div class="box-header">
							<h2><i class="fa fa-globe"></i>热门视频</h2>
						</div>
						<div class="box-content">
							<div class="row">
								<div class="col-md-6">
									<div class="wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span>视频标签</span>
												<a href="www.youku.com" >
													<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
												</a>
												<p>视频名字</p>
											</div>
											<img src="/images/7.jpg" />
										</div>
										<h3 class="vid-name"><a href="#">视频名字</a></h3>
										<div class="info">
											<h5>By <a href="/room/enter/1?chatUserId=${chatUserId }"></h5>
											<span><i class="fa fa-calendar"></i>25/3/2017</span> 
											<span><i class="fa fa-heart"></i>1,200</span>
										</div>
									</div>
									<p class="more">一只焦虑的程序狗的课程
									一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程
									一只焦虑的程序狗的课程
									</p>						
								</div>
								<div class="col-md-6">
									<div class="wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span>视频标签</span>
												<a href="single.html">
													<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
												</a>
												<p>视频名字</p>
											</div>
											<img src="/images/9.jpg" />
										</div>
										<h3 class="vid-name"><a href="#">视频名字</a></h3>
										<div class="info">
											<h5>By <a href="/room/enter/1?chatUserId=${chatUserId }"></h5>
											<span><i class="fa fa-calendar"></i>25/3/2017</span> 
											<span><i class="fa fa-heart"></i>1,200</span>
										</div>
									</div>
									<p class="more">
									一只焦虑的程序狗的课程
									一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程一只焦虑的程序狗的课程
									一只焦虑的程序狗的课程
									</p>					
									
								</div>
							</div>
						</div>		
					</div>						
				</div>
				<div id="sidebar" class="col-md-4">
					<!---- Start Widget ---->
					<div class="widget wid-follow">
					<br>
					<br>
			
						<div class="content">

							<img src="/images/banner.jpg" />
						</div>
						<div class="line"></div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-tags">
						<div class="heading"><h4><i class="fa fa-tags"></i>标签</h4></div>
						<div class="content">
							<ul class="list-inline">
								<li><a href="#">spring-boot</a></li>
								<li><a href="#">spring-data-jpa</a></li>
								<li><a href="#">nginx</a></li>
								<li><a href="#">rtmp</a></li>
								<li><a href="#">jsoup</a></li>
								<li><a href="#">mongodb</a></li>
								<li><a href="#">redis</a></li>								
							</ul>
						</div>
					</div>					
				</div>
			</div>
		</div>
		
	</div>

<div class="row">
<div  style="height: 80px;background-color: black;" align="center">
<span align="center">版权所有</span>
</div>
</div>




	<script src="/owl-carousel/owl.carousel.js"></script>
    <script>
    $(document).ready(function() {
      $("#owl-demo").owlCarousel({
        autoPlay: 3000,
        items : 5,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4]
      });

    });
    </script>
	
</body>
</html>
