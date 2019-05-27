<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Success</title>
<style>
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
}
.show{
margin-right:450px;
margin-top:300px;
font-family:"微軟正黑體";
font-size:40px;
color:#FF8888
}
.back {

	width: 150px;
	margin-left: 20px;
	margin-top: 20px;
}
.sad{
position: absolute;
    z-index: 2;
    left: 380px;
    top: 340px;
}
</style>
</head>
<body>
	<a href="index.html"><img src="res/back.png" class="back"></a>
	<img src="res/sad.gif" class='sad'>
<div style="text-align:center"><h2 class="show">學校編號${check},<br>資料刪除成功。</h2></div>
</body>
</html>