<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<link href="css/bootstrap/fileinput.min.css" rel="stylesheet">
<!--引入bootstrap -->
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/fileinput.js"></script>
<script src="js/bootstrap-3.3.7-dist/js/zh.js" type="text/javascript"></script> 
<title>Insert title here</title>
</head>
<body width="700px">
			
			<div id="pic_update">
			<form method="post" action="/Final_PRJ//picchange.jhtml" enctype="multipart/form-data">
			   		<p>个人头像上传</p>
			      	<input id="myFile" type="file" name="myFile" class="fileloading">
			      	<input type="hidden" name="user.logo" id="logo">
			  		<input type="submit" id="savebtn" value="确定">
			</form>	
			</div>
</body>
<script>
$("#myFile").fileinput({
    language : 'zh',
    uploadUrl : "",
    autoReplace : true,
    maxFileCount : 1,
    allowedFileExtensions : [ "jpg", "png", "gif" ],
    browseClass : "btn btn-primary", //按钮样式 
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
}).on("fileuploaded", function(e, data) {
    var res = data.response;
    alert(res.success);
    $("#logo").attr("value", res.success);
})
</script>
</html>