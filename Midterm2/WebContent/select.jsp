<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
<style>
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
	font-family: '微軟正黑體';
}

.bt{
line-height:30px;
margin-top:20px;
margin-left:30px;
border:5px solid #003C9D;
border-radius:5px;
background-color:#003C9D;
color:white;
font-family: '微軟正黑體';
font-weight:bold;
display:inline;
}
.bt:hover{
opacity:0.5;
}
table{
background-color:rgba(255,255,255,0.7);
text-align:center;
line-height:30px;
}
tr{

color:#003C9D;
}
.back {
	width: 150px;
	margin-left: 20px;
	margin-top: 20px;
	
}
.d{
overflow:auto;
}
form{
display:inline;
margin-top:10px;
}
.show{
margin-left:30px;
margin-top:30px;
}
td{
border:5px solid #003C9D;

}
</style>
</head>
<body>

<div><a href="index.html"><img src="res/back.png" class="back"></a></div>
<button type="button" class= "bt" value="顯示全部" onclick="javascript:location.href='Select.do'">顯示全部</button>
<form style="margin-left:100px;" action="SelectCity.do" method="POST">
<select id="s" name="city"></select>
<input class="bt" type="submit" value="搜尋">

</form>

<table class="show" id="show">
${alldata}
</table>
<script>
var xhttp = new XMLHttpRequest();
xhttp.onload = function(){ innerHTML=
	document.getElementById("s").innerHTML=this.responseText;
}
xhttp.open("POST","Selectnew.do",true);
xhttp.send();
</script>
</body>
</html>