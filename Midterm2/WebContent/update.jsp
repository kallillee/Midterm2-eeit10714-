<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style>
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
	font-family: '微軟正黑體';
}

h3 {
	margin-top: 100px;
}


.show {
	margin: auto;
}
.f1 {
	margin-left: 460px;
}

.back {
	width: 150px;
	margin-left: 20px;
	margin-top: 20px;
}

.h {
	margin-top: 50px;
	margin-left: 400px;
	border: 5px solid #55AA00;
	border-radius: 20px;
	color: #55AA00;
	font-weight: bold;
	font-size: 30px;
	display: inline;
	padding: 10px;
}
.buttom {
	width:60px;
	background-color: #55AA00;
	color:white;
	border:2px solid #55AA00;
}
.showtable {
	margin-top: 50px;
	margin-left: 30px;
	line-height: 45px;
	font-size: 20px;
}
.show {
	text-align: center;
	margin-left: 170px;
}
td {
	border:3px solid #55AA00;
	border-radius: 5px;
}

.tr1 {
	font-weight: bold;
	color: white;
	background-color: #55AA00;
}
.up{
width:300px;
text-align:left;
}

td input{
margin-left:5px;
margin-right:10px;
}

.butt {
	margin-right: 50px;

	background-color: white;
	border: 2px solid #55AA00;
	border-radius: 30px;
	width: 150px;
	font-size: 20px;
	padding: 10px;
	font-weight: bold;
	color: #55AA00;
	font-family: '微軟正黑體';
}

.butt:hover {
	box-shadow: 4px 4px 3px rgba(20%, 20%, 40%, 0.5);
}
.xx{
margin-left:370px; 
}

</style>
</head>
<body>
	<a href="index.html"><img src="res/back.png" class="back"></a>
	<div>
		<h3 class="h">請輸入要修改的學校編號</h3>
		<br> <br><br>
		<form action="Update.do" class='f1'>
			<input type="text" name="code" size="20" /> <input type="submit"
				value="搜尋" class="buttom" style="height:30px;"><br> <span>${error}</span>
		</form>

	</div>
	<div class="showtable">
		<form action="Updatecheck.do?code=${code}" method="GET">
			<table id="t" class="show" >${table}</table>
			<div class="xx"><br>${button}</form></div>
		<br>
	</div>
</body>
</html>