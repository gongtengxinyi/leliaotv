<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,minimal-ui" />
<meta charset="utf-8">
<title>纯HLS(m3u8)跨平台技术(跨平台多终端测试)HLSPlayer,m3u8Player</title>
<meta name="keywords" content="HLSPlayer,m3u8Player,支持PC终端,Android安卓终端,iOS苹果终端,WindowsPhone终端" />
<meta name="description" content="支持PC终端,Android安卓终端,iOS苹果终端,WindowsPhone终端,纯HLS(m3u8)跨平台技术(跨平台多终端测试)" />
</head>

<body>


<!--HLSPlayer代码开始-->
<div class="video"  align="center" id="HLSPlayer" >
<SCRIPT LANGUAGE=JavaScript>
<!--
/*
* HLSPlayer参数应用=========================<br>
* @Contact QQ:261532593 
* @param {Object} vID        ID
* @param {Object} vWidth     播放器宽度设置
* @param {Object} vHeight    播放器宽度设置
* @param {Object} vPlayer    播放器文件
* @param {Object} vHLSset    HLS配置
* @param {Object} vPic       视频缩略图
* @param {Object} vCssurl    移动端CSS应用文件
* @param {Object} vHLSurl    HLS(m3u8)地址
* ==========================================
*/
var vID        = ""; 
var vWidth     = "60%";                //播放器宽度设置
var vHeight    = 400;                   //播放器宽度设置
var vPlayer    = "/HLSplayer.swf?v=1.5"; //播放器文件
var vHLSset    = "/HLS.swf";             //HLS配置
var vPic       = "/images/start.jpg";    //视频缩略图
var vCssurl    = "";     //移动端CSS应用文件

//HLS(m3u8)地址,适配PC,安卓,iOS,WP
var vHLSurl    = "http://192.168.1.33/hls/ding.m3u8";


</SCRIPT> 
<script type="text/javascript" src="/js/hls.min.js?rand=20141217"></script>
</div>



</body>
</html>
