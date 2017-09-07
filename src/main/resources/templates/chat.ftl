<!DOCTYPE html>
<html>
<head>
<title>喷子基地</title>
</head>
<body>
<div id="a1"></div>
<script src="/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var webSocket = null;
var flag = true;//全局标记位，标记浏览器是否支持websocket
$(function() {
    if (!window.WebSocket) {
        $("body").append("<h1>你的浏览器不支持WebSocket</h1>");
        flag = false;
        return;
    }

});
connectWebsocket();
function connectWebsocket() {
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {	        		         
		var strConn = "ws://localhost:7080/chatServer?";
 				websocket = new WebSocket(strConn); 				
	} else {
		alert('browser Not support websocket')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
	};

	//连接成功建立的回调方法
	websocket.onopen = function() {
alert("opne");
	}					             
	//接收到消息的回调方法
	websocket.onmessage = function(event) {					
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		//setMessageInnerHTML("WebSocket closed");
	}
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		closeWebSocket();
	}
}
</script>
</body>
</html>