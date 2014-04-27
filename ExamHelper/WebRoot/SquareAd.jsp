<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>发布答疑广场广告</title>
<link href="./css/uploadify.css" rel="stylesheet" type="text/css" />
<link href="./css/ad.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript" src="js/jquery.uploadify.v2.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.event.drag-1.5.min.js"></script>
<script type="text/javascript" src="js/jquery.touchSlider.js"></script>
<script type="text/javascript">
var flag="true";
		 $(document).ready(function() {
		  $("#uploadify").uploadify({
		   'uploader'       : 'js/uploadify.swf',
		   'script'         : 'SquareAdImageUpload',//servlet的路径或者.jsp 这是访问servlet 'scripts/uploadif' 
		   'method'         :'GET',  //如果要传参数，就必须改为GET
		   'cancelImg'      : 'js/cancel.png',
		   'folder'         : 'AdImages', //要上传到的服务器路径，
		   'queueID'        : 'fileQueue',
		   'auto'           : false, //选定文件后是否自动上传，默认false
		   'multi'          : true, //是否允许同时上传多文件，默认false
		   'simUploadLimit' : 8, //一次同步上传的文件数目  
		   'sizeLimit'      : 20480, //设置单个文件大小限制，单位为byte  
		   'queueSizeLimit' : 8, //限制在一次队列中的次数（可选定几个文件）。默认值= 999，而一次可传几个文件有 simUploadLimit属性决定。
		   'fileDesc'       : '支持格式:jpg或gif或png', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
		   'fileExt'        : '*.jpg;*.gif;*.png',//允许的格式
		   
		   　onComplete: function (event, queueID, fileObj, response, data) {
		    var value = response ;
		   　},  
		   　onError: function(event, queueID, fileObj) {  
		   　 alert("文件:" + fileObj.name + "上传失败");  
		    flag = "false";
		   　},  
		   　onCancel: function(event, queueID, fileObj){  
		   　} 
		  });
		 });
		 
		 function uploasFile(){ 
		      //上传
		 	 jQuery('#uploadify').uploadifyUpload(); 
		 }

//图片轮播
$(document).ready(function () {
	$(".main_visual").hover(function(){
		$("#btn_prev,#btn_next").fadeIn()
		},function(){
		$("#btn_prev,#btn_next").fadeOut()
		})
	$dragBln = false;
	$(".main_image").touchSlider({
		flexible : true,
		speed : 200,
		btn_prev : $("#btn_prev"),
		btn_next : $("#btn_next"),
		paging : $(".flicking_con a"),
		counter : function (e) {
			$(".flicking_con a").removeClass("on").eq(e.current-1).addClass("on");
		}
	});
	$(".main_image").bind("mousedown", function() {
		$dragBln = false;
	})
	$(".main_image").bind("dragstart", function() {
		$dragBln = true;
	})
	$(".main_image a").click(function() {
		if($dragBln) {
			return false;
		}
	})
	timer = setInterval(function() { $("#btn_next").click();}, 5000);
	$(".main_visual").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() { $("#btn_next").click();}, 5000);
	})
	$(".main_image").bind("touchstart", function() {
		clearInterval(timer);
	}).bind("touchend", function() {
		timer = setInterval(function() { $("#btn_next").click();}, 5000);
	})
});
 </script>
</head>
<body>
	
    <div id="fileQueue"></div> 
	<input type="file" name="uploadify" id="uploadify" />
	<p>
		<a href="javascript:uploasFile()">开始上传</a>&nbsp;
		<a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>
	</p>
	<div class="main_visual">
         <div class="flicking_con">
              <div class="flicking_inner">
                    <a href="">1</a>
                    <a href="">2</a>
                    <a href="">3</a>
                    <a href="">4</a>
                    <a href="">5</a>
              </div>
         </div>
		<div class="main_image">
			<ul>					
				<li><span class="img_1" style="background: url('./images/img_main_1.jpg') center top no-repeat"></span></li>
				<li><span class="img_2" style="background: url('./images/img_main_2.jpg') center top no-repeat"></span></li>
				<li><span class="img_3" style="background: url('./images/img_main_3.jpg') center top no-repeat"></span></li>
				<li><span class="img_4" style="background: url('./images/img_main_4.jpg') center top no-repeat"></span></li>
				<li><span class="img_5" style="background: url('./images/img_main_5.jpg') center top no-repeat"></span></li>
			</ul>
			<a href="javascript:;" id="btn_prev"></a>
			<a href="javascript:;" id="btn_next"></a>
		</div>
	</div>
</body>
</html>
