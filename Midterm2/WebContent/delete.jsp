<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<style>
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
	font-family: '微軟正黑體';
}

.back {
	width: 150px;
	margin-left: 20px;
	margin-top: 20px;
}

.h {
	margin-top: 50px;
	margin-left: 400px;
	border: 5px solid #FF8888;
	border-radius: 20px;
	color: #FF8888;
	font-weight: bold;
	font-size: 30px;
	display: inline;
	padding: 10px;
}

.showtable {
	margin-top: 50px;
	margin-left: 160px;
	line-height: 45px;
	font-size: 20px;
}

td {
	border: 3px solid #FF8888;
	border-radius: 5px;
}

.show {
	text-align: center;
	margin-left: 170px;
}

.f1 {
	margin-left: 460px;
}

.d {
	margin-left: 270px;
}

.butt {
	margin-right: 50px;
	background-color: white;
	border: 2px solid #FF8888;
	border-radius: 30px;
	width: 150px;
	font-size: 20px;
	padding: 10px;
	font-weight: bold;
	color: #FF8888;
	font-family: '微軟正黑體';
}

.butt:hover {
	box-shadow: 4px 4px 3px rgba(20%, 20%, 40%, 0.5);
}

.tr1 {
	font-weight: bold;
	color: white;
	background-color: #FF8888;
}

.buttom {
	width:60px;
	background-color: #FF8888;
	color:white;
	border:2px solid #FF8888;
}
</style>
</head>
<body>
	<a href="index.html"><img src="res/back.png" class="back"></a>
	<div>
		<h3 class="h">請輸入要刪除的學校編號</h3>
		<br> <br> <br>
		<form action="Delete.do" class='f1'>
			<input type="text" name="code" size="20" /> <input type="submit"
				value="搜尋" class="buttom" style="height: 30px;"><br> <span>${error}</span>
		</form>

	</div>


	<div class="showtable">
		<table id="t" class="show">${table}</table>
		<br>
		<div id="d" class="d">${button}</div>
		<br>

	</div>

	<script>
		
	</script>

</body>
</html>