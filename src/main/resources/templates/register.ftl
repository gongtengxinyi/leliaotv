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


<script src="js/bootstrap.min.js"></script>
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
			 
			 function checkUserNameInfo(){	
					var username=$("#username").val();
			 if(username=''){
				 alert("用户名不能为空！");
			 }
			 
               $.ajax({
						type : "POST",
						url : "checkInfo/1?username="+username,	
						dataType : "json",
						success : function(data) {
							console.log(data);
						}
					});
				return;
			 } 
			function  checkUserEmailInfo(){	
				var email=$("#email").val();
				if(email==''){
					alert("邮箱不能为空");
				}
				   var reg = /\w+[@]{1}\w+[.]\w+/;
				   if(reg.test(email)){
				 
				   }else{
				    alert("请输入正确的email地址");
				   }
			    $.ajax({
					type : "POST",
					url : "checkInfo/0?email="+email,	
					dataType : "json",
					success : function(data) {
						console.log(data);
					}
				});
			return;
			}
			function myFunction(){
				var username=$("#username").val();
				var checkcode=$("#checkcode").val();
				var email=$("#email").val();;
				var password=$("#password").val();
				if(password==""){
					alert("密码不能为空");
					return;
				}
				if(username==""){
					alert("用户名不能为空");
					return;
				}
				if(email==""){
					alert("邮箱不能为空");
					return;
				}if(checkcode==''){
					alert("验证码不能为空");
					return;
				}
			}
			//
			function checkAndSendEmail(){
				
				
				return;
				var checkcode=$("#checkcode").val();
				   $.ajax({
						type : "POST",
						url : "checkInfo/0?email="+email,	
						dataType : "json",
						success : function(data) {
							console.log(data);
						}
					});
			}
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
			<form>
<input  id="username" class="username"  type="text" class="text" value="" placeholder="用户名" onfocus="this.value = '';" onblur="checkUserNameInfo()" >
<input id="email" type="text"   name ="email" class="email" value="" placeholder="邮箱@" onfocus="this.value = '';" onblur="checkUserEmailInfo()" >
<input id="checkcode"  class="checkcode" type="text" value="" placeholder="邮箱验证码" onfocus="this.value = '';" onblur="checkAndSendEmail()">
<input id="password" type="password" value="" placeholder="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}">
<span id="repeatCode"  style="font-family: Microsoft YaHei UI; font-size: 18px; color: green"> </span>
	<div class="submit"><input type="submit" onclick="myFunction()" value="注册" ></div>
<div class="clear"></div>				
<div class="new">
	<p class="sign">已有账号？  <a href="login.ftl">登录</a></p>
		<div class="clear"></div>
		</div>
			</form>
		</div>
		<!-- 模态框 -->
		
		
	<!--start-copyright-->
   		<div class="copy-right">
				<p>Copyright &copy; 2017  All rights  Reserved |  dingjianlei</p>
		</div>
	<!--//end-copyright-->
</body>
</html>