<!DOCTYPE html>
<html>
<head>
<title>乐聊tv</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="国内首家喷人平台 打造第一发泄地噪音发生地"./>

</script>
<script src="/js/jquery.min.js"></script>
<!--webfonts-->
<!-- <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,200,100,500,600,700' rel='stylesheet' type='text/css'> -->
<!--//webfonts-->
</head>
<video id="example-video"  style="width:650px; height:550"  controls>
  <source
     src="http://192.168.1.33/hls/ding.m3u8"
     type="application/x-mpegURL">
</video>
<script src="/video-js/video.js"></script>
<script src="/video-js/videojs-contrib-hls.min.js"></script>
<script>
var player = videojs('a1');
player.play();
player.size(640,480);
</script>
</html>