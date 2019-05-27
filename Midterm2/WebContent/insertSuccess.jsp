<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertSuccess</title>
<style>body {
    background-image: url(res/giphy.gif);
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: 900px 0px;
    background-size: 50% 100%;   
}
.back{
width:150px;
margin-left:20px;
margin-top:20px;

}
td{
border:5px solid rgba(248,181,81);
line-height:50px;
font-family:'微軟正黑體';
font-size:20px;
}
h2{
font-family:'微軟正黑體';
margin-top:80px;
margin-left:100px;
color:rgba(248,181,81);
font-size:40px;
}
table{
margin-left:7%;
}
</style>
</head>
<body>
<a href="index.html"  ><img src="res/back.png" class="back" ></a>   
<h2>×新增學校資料成功×</h2>
<table style="text-align:center;">
<tr><td style="color:rgba(248,181,81);width:100px;font-weight:bold;">編號<td style="width:700px">${Bean.code}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">學校名稱<td>${Bean.name}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">公/私立<td>${Bean.pborpv}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">所在縣市<td>${Bean.city}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">學校地址<td>${Bean.addr}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">學校電話<td>${Bean.phone}</tr>
<tr><td style="color:rgba(248,181,81);font-weight:bold;">學校網站<td>${Bean.url}</tr>
</table>
</body>
</html>