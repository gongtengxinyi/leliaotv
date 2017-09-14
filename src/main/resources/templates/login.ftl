<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>乐聊tv</title>
<link href="css/loginstyle.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="国内首家喷人平台 打造第一发泄地噪音发生地"./>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<script src="js/jquery.min.js"></script>
<!--webfonts-->
<!-- <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,200,100,500,600,700' rel='stylesheet' type='text/css'> -->
<!--//webfonts-->
</head>
<body>
	<h1> </h1>
	<br>
		<div class="app-video">
			<div class="img-play">
				<a class="play-icon popup-with-zoom-anim" href="#small-dialog5"><img src="images/play.png" class="img-responsive" alt="" /></a></div>
				<div id="small-dialog5" class="mfp-hide">
					<iframe src="https://player.vimeo.com/video/57866624" width="500" height="281" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
				</div>
				
			 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>								  
			<!--pop-up-box--> 
			<link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all">
			<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!--pop-up-box-->
			<h1>登录</h1>
			<form action="/login">
				<input name="username" type="text" class="text" value="" placeholder="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" >
				<input name="password"  type="password" value="" placeholder="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}">
				<div class="submit"><input type="submit" onclick="myFunction()" value="登录" ></div>
				<div class="clear"></div>				
				<div class="new">
					<p><a href="#">忘记密码 ?</a></p>
					<p class="sign">没有账号？  <a href="/dispatcherRegister"> 注册</a></p>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	<!--start-copyright-->
   		<div class="copy-right">
				<p>Copyright &copy; 2017  All rights  Reserved |  dingjianlei</p>
		</div>
	<!--//end-copyright-->
</body>
</html>