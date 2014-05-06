<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>图片上传</title>
	
<script id="jquery_172" type="text/javascript" class="library" src="js/jquery-1.7.1.min.js"></script>
<link href="./css/upload.css" rel="stylesheet" type="text/css" />
<script>
	function setImagePreview() {

		var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {

			//火狐下，直接设img属性                          
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '15%';
			//imgObjPreview.style.height = '100%';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();  
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式          
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜                          
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");

			//必须设置初始大小                          
			localImagId.style.width = "10%";

			//图片异常的捕捉，防止用户修改后缀来伪造图片  
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}

		return true;
	}
$(function(){
	$("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
	$("input[type=file]").each(function(){
	if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("没有选择任何文件...");}
	});
});
function uploadNow() {
	var doc = document.getElementById("doc");
	if(doc.files && doc.files[0]){
		document.getElementById("uploadform").action = "${pageContext.request.contextPath}/MaterImageUploadServlet";
		document.getElementById("uploadform").submit();
	}else{
		alert("请选择文件！");
	}
}
</script>
</head>

<body>
	<table class="upTable">
		<tr style="vertical-align: top;">
			<td style="width: 30%;">
				  <form action='' id="uploadform" method='post' enctype='multipart/form-data'>
					<div class="uploader white">
						<input type="text" class="filename" readonly="readonly"/>
						<input type="button" name="file" class="buttonUp" value="浏览..."/>
						<input type="file" size="30" onchange="javascript:setImagePreview();" name='doc' id='doc' accept="images/*"/>
					</div>
					<div class="uploadBtnDiv"><input type="button" onclick="uploadNow();" class="uploadBtn" value='上传'></div>
				 </form>
			</td>
			<td>
				<div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /></div>
			</td>
		</tr>
	</table>
	
</body>
</html>
