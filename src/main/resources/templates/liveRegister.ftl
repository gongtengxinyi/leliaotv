<!DOCTYPE html>
<html>
<head>
<title>如何成为乐聊tv主播</title>
<link rel="stylesheet" href="/css/bootstrap.min.css"  type="text/css">
<style type="text/css">
body{
background-position: center 0;
background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;
 -webkit-background-size: cover;
no-repeat;background-size:contain}
</style>
</head>
<body >
<div class="container">
<div style="height: 80px">
</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 align="center">
				乐聊tv主播申请
			</h2>
		</div>
	</div>
	<div style="height: 40px">
</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
			<form id="form" role="form"  action="/liver/becomeLiver" method="post" enctype="multipart/form-data">
				<div class="form-group">
					 <label for="exampleInputEmail1">直播类型</label><input required type="text" class="form-control" id="liveType" name="liveType"/>
				</div>
				<div class="form-group">
	 <label for="exampleInputPassword1">房间名字</label>
	 <input type="text" class="form-control" id="roomName" name="roomName"  required/>
	 
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">房间号</label>
					 <input type="text" class="form-control" id="roomNum" name="roomNum" onblur="checkRoom()"  required/>
				</div>
					<div class="form-group">
					 <label for="exampleInputPassword1">房间描述</label>
					<textarea class="form-control" rows="3"  name="roomIntroduce" required></textarea>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">个人美照</label>
					 <input type="file" id="exampleInputFile" name="file" />		
				</div>
				<div class="form-group">
				<div style="float: left">
			<a id="" href="/index/gotoIndex" role="button" class="btn" >
			<h5>
			回到首页>></h5>
			</a>	
		</div>
		<div style="float: right">
			<a id="modal-482295" href="#modal-container-482295" role="button" class="btn" data-toggle="modal">
			<h4>
			点击注册</h4>
			</a>	
		</div>
				</div>
			</form>
			
			
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
                     	<img src="/images/b.png"  style="height: 300px;width: 300px" class="img-rounded">
                     	<img src="/images/c.png"  style="height: 300px;width: 300px" class="img-rounded">
						</div>
						<p align="center">
						请意思一下，尊重劳动者的劳动吧，服务器不便宜~注册成功~
						</p>
												<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							  <button type="button" class="btn btn-primary" id="save" onclick="upload()">保存</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
</div>
    
			
			<div class="modal fade" id="modal-container-522766" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
							温馨提示
							</h4>
						</div>
						<div class="modal-body">
							您申请的房间号太热门了，被人抢了~~
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					
				</div>
				</div>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
function checkRoom(){
	var roomNum=$("#roomNum").val();	
    $.ajax({
		type : "POST",
		url : "/room/checkRoom?roomNum="+roomNum,	
		dataType : "json",
		   error:function(message){
			   alert("请求出错，请联系管理员");
		        alert(message);
		   },
		       
		success : function(data) {
	         if(data.status=='NO'){
	        	 $('#modal-container-522766').modal('show')
// 	        	 $("#modal-container-522766").show();
	        	 $("#roomNum").focus();
	         }
		}  
	});
 
}
function upload(){	
	
$("#form").submit();
}
</script>
</body>
</html>