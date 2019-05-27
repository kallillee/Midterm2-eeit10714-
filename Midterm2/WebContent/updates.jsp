<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Success</title>
<style >
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
	font-family: '微軟正黑體';
}
table{
line-height:30px;
font-family: '微軟正黑體';
margin-left:200px;
}
td{
border:3px solid #55AA00;
text-align:center;
border-radius:5px;
}

.back {
	width: 150px;
	margin-left: 20px;
	margin-top: 20px;
}

h2{
margin-left:11%;
color:#55AA00;
display:inline;
}
.tr1{
width:110px;
background-color:#55AA00;
color:white;
font-weight:bold;
}
</style>
</head>
<body>
<a href="index.html"><img src="res/back.png" class="back"></a>
<table style="margin-top:40px" >
<tr><td class="tr1">學校編號</td><td width="300px">${beanold.code}</td></tr>
<tr><td class="tr1">學校名稱</td><td>${beanold.name}</td></tr>
<tr><td class="tr1">公/私立</td><td>${beanold.pborpv}</td></tr>
<tr><td class="tr1">所在縣市</td><td>${beanold.city}</td></tr>
<tr><td class="tr1">學校地址</td><td>${beanold.addr}</td></tr>
<tr><td class="tr1">學校電話</td><td>${beanold.phone}</td></tr>
<tr><td class="tr1">學校網站</td><td>${beanold.url}</td></tr>
</table>
<div><h2>已將資料更新成↓</h2><img src="res/change.gif" width='200px'></div> 
<table  >
<tr><td class="tr1">學校編號</td><td width="300px">${beanold.code}</td></tr>
<tr><td class="tr1">學校名稱</td><td>${beannew.name}</td></tr>
<tr><td class="tr1">公/私立</td><td>${beannew.pborpv}</td></tr>
<tr><td class="tr1">所在縣市</td><td>${beannew.city}</td></tr>
<tr><td class="tr1">學校地址</td><td>${beannew.addr}</td></tr>
<tr><td class="tr1">學校電話</td><td>${beannew.phone}</td></tr>
<tr><td class="tr1">學校網站</td><td>${beannew.url}</td></tr> 
</table>
</body>
</html>