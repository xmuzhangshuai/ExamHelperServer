<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图片上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script>
	function setImagePreview() {

		var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {

			//火狐下，直接设img属性                          
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '10%';
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
			//localImagId.style.height = "100%";

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
</script>

</head>

<body>

    <div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /></div>
	<form action='${pageContext.request.contextPath}/TestServlet' method='post' enctype='multipart/form-data'>
		请选择要上传的文件:<input type='file' name='doc' id='doc' onchange="javascript:setImagePreview();"   size='50'> 
		<input type='submit' value='提交'>
	</form>
	
</body>
</html>
