function connectWebsocket(websocket) {
	// 判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		var strConn = "ws://localhost:7080/chatServer?";
		websocket = new WebSocket(strConn);
	} else {
		alert('browser Not support websocket')
	}

	// 连接发生错误的回调方法
	websocket.onerror = function() {
	};

	// 连接成功建立的回调方法
	websocket.onopen = function() {
		alert("open");
	}
	// 接收到消息的回调方法
	websocket.onmessage = function(event) {
		if (event.data == 'SUCCESS') {
			alert("弹幕连接成功!");
		}
		var jsonObj = JSON.parse(event.data);
		setMessageOnHtml(jsonObj);
	}

	// 连接关闭的回调方法
	websocket.onclose = function() {
		// setMessageInnerHTML("WebSocket closed");
	}

}
      function setMessageOnHtml(jsonObj) {
	if (jsonObj.messageMode == 'CHAT_MESSAGE') {

	} else if (jsonObj.messageMode == 'ADMIN_MESSAGE') {

	} else {

	}

}
