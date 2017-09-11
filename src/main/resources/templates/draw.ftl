<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>乐聊TV幸运大抽奖</title>
<style>
/* 页面 css */
* { margin: 0; padding: 0;}
h1 { width: 900px; margin: 40px auto; font: 32px "Microsoft Yahei"; text-align: center;}
.vad { margin: 50px 0 5px; font-family: Consolas,arial,宋体; text-align:center;}
.vad a { display: inline-block; height: 36px; line-height: 36px; margin: 0 5px; padding: 0 50px; font-size: 14px; text-align:center; color:#eee; text-decoration: none; background-color: #222;}
.vad a:hover { color: #fff; background-color: #000;}
.thead { width: 728px; height: 90px; margin: 0 auto; border-bottom: 40px solid transparent;}

/* demo css */
#dowebok { position: relative; width: 780px; height: 390px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; background: url(images/ly-plate-c.gif) 20px 20px no-repeat;}
.plate { position: relative; float: left; width: 390px; height: 390px; background-image: url(images/lyplate.png);}
.prize { float: right; width: 360px; height: 390px; font: 14px/1.5 "Microsoft Yahei";}
.prize h4 { margin: 80px 0 20px; padding: 10px; background-color: #eee;}
.prize ul { list-style-type: none;}
.prize li { margin: 10px;}
#plateBtn { position: absolute; left: 88px; top: 88px; width: 214px; height: 214px; background-image: url(images/rotate-static.png); text-indent: -9999px; overflow: hidden;}
#result { display: none; position: absolute; left: 65px; top: 155px; width: 300px; height: 120px; background-color: rgba(0,0,0,0.75); filter: alpha(opacity=90);}
#resultTxt { padding: 45px 15px 0; font: 16px "Microsoft Yahei"; color: #fff; text-align: center;}
#resultTxt em { color: #ffea76; font-style: normal;}
#resultBtn { position: absolute; right: 5px; top: 5px; width: 25px; height: 25px; text-indent: -100px; background-image: url(images/close.png); overflow: hidden;}
</style>
</head>

<body>
<h1>乐聊TV幸运大抽奖</h1>

<div id="dowebok">
	<div class="plate">
		<a id="plateBtn" href="javascript:" title="开始抽奖">开始抽奖</a>
	</div>

	<div class="prize">
		<h4>奖品设置</h4>
		<ul>
			<li><strong>一等奖：</strong>iPhone 6 Plus（1名）</li>
			<li><strong>二等奖：</strong>iPhone 6（2名）</li>
			<li><strong>三等奖：</strong>iPad Air 2（5名）</li>
			<li><strong>参与奖：</strong>充电宝（20名）</li>
		</ul>
	</div>

	<div id="result">
		<p id="resultTxt"></p>
		<a id="resultBtn" href="javascript:" title="关闭">关闭</a>
	</div>
</div><script src="/js/jquery.min.js"></script>
<script src="/js/jquery.rotate.min.js"></script>
<script>
$(function(){
	var $plateBtn = $('#plateBtn');
	var $result = $('#result');
	var $resultTxt = $('#resultTxt');
	var $resultBtn = $('#resultBtn');

	$plateBtn.click(function(){
		var data = [0, 1, 2, 3, 4, 5, 6, 7];
		data = data[Math.floor(Math.random()*data.length)];
		switch(data){
			case 1: 
				rotateFunc(1,157,'恭喜你中了 <em>一等奖</em>');
				break;
			case 2: 
				rotateFunc(2,65,'恭喜你中了 <em>二等奖</em>');
				break;
			case 3: 
				rotateFunc(3,335,'恭喜你中了 <em>三等奖</em>');
				break;
			case 4: 
				rotateFunc(4,247,'恭喜你中了 <em>四等奖</em>');
				break;
			case 5: 
				rotateFunc(5,114,'谢谢参与，请再接再厉');
				break;
			case 6: 
				rotateFunc(6,24,'谢谢参与，请再接再厉');
				break;
			case 7: 
				rotateFunc(7,292,'谢谢参与，请再接再厉');
				break;
			default:
				rotateFunc(0,203,'恭喜你中了 <em>参与奖</em>');
		}
	});

	var rotateFunc = function(awards,angle,text){  //awards:奖项，angle:奖项对应的角度
		$plateBtn.stopRotate();
		$plateBtn.rotate({
			angle: 0,
			duration: 5000,
			animateTo: angle + 1440,  //angle是图片上各奖项对应的角度，1440是让指针固定旋转4圈
			callback: function(){
				$resultTxt.html(text);
				$result.show();
			}
		});
	};

	$resultBtn.click(function(){
		$result.hide();
	});
});
</script>

</body>
</html>