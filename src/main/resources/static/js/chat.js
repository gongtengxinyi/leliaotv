//创建聊天消息	
function createChatMessage() {
				var jsonObj = {};
				jsonObj.uuid=UUID();
				jsonObj.indentId = indentId;
				jsonObj.messageMode = "INDENT_MESSAGE";
				jsonObj.messageType = "TEXT";
				jsonObj.message = document.getElementById('text').value;
				return JSON.stringify(jsonObj);
			}
//发送图片或者文件
	function  preView()    {    	 
        var img = document.getElementById('img');
                var suffix=img.value;
        var strs= new Array(); //定义一数组用来接收后缀
        strs=suffix.split(".");
        var fileSuffix=strs[1];
        var imgFile = new FileReader();
        imgFile.readAsDataURL(img.files[0]);       
        imgFile.onload = function () {
        	if(fileSuffix=='GIF'||fileSuffix=='gif'||fileSuffix=='JPEG'||fileSuffix=='jpeg'||fileSuffix=='PNG'||fileSuffix=='png'||fileSuffix=='JPG'||fileSuffix=='jpg'){
        		sendImageNo(this.result);	
        		return ;
        	}    else{
        		sendBinary(this.result,fileSuffix);
        	}         		        	       
        }
       }
	/**
	发送二进制文件
	**/
	 function sendBinary(binary,fileSuffix){
	        var jsonObj = {};
	        jsonObj.uuid=UUID();
			jsonObj.indentId = indentId;
			jsonObj.messageMode = "INDENT_MESSAGE";
			jsonObj.messageType ="BINARY";
			jsonObj.suffix =fileSuffix;
			jsonObj.imageBase64=binary;
			var messageJson=JSON.stringify(jsonObj);
			websocket.send(messageJson);
		    }
	// uuid
     function UUID()   {
         var s = [];
         var hexDigits = "0123456789abcdef";
         for (var i = 0; i < 36; i++) {
             s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
         }
         s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
         s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
         s[8] = s[13] = s[18] = s[23] = "-";
         var uuid = s.join("");
         return uuid;
 }
    function sendImageNo(image)
    {
        var jsonObj = {};
		jsonObj.indentId = indentId;
		jsonObj.uuid=UUID();
		jsonObj.messageMode = "INDENT_MESSAGE";
		jsonObj.messageType ="IMAGE";		
		jsonObj.imageBase64=image;
		var messageJson=JSON.stringify(jsonObj);
		websocket.send(messageJson);
    }
	  function showSelectButton(){
	    	 $("#img").click();
	    }