<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert</title>
<style>
body {
	background-image: url(res/giphy.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 900px 0px;
	background-size: 50% 100%;
}

fieldset {
	border-top-left-radius: 20px;
	border-bottom-right-radius: 20px;
	margin-top: 50px;
	border: 10px solid rgba(248, 181, 81);
	padding: 30px;
	font-family: 'Baloo Bhai', cursive;
	line-height: 40px;
	font-size: 30px
}

.back {
	width: 150px;
	margin-left: 20px;
	float: left;
}

input {
	height: 20px;
}

.bu {
	background-color: white;
	border: 5px solid rgba(248, 181, 81);
	border-radius: 20px;
	height: 50px;
	width: 80px;
	font-family: 'Baloo Bhai', cursive;
	color: rgba(248, 181, 81);
	font-size: 20px;
}

.error {
	color: red;
	font-size: 15px;
	font-family: '微軟正黑體';
}
label{
color:rgba(248, 181, 81);
}
input{
font-family:"微軟正黑體";
}
</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	document.getElementById("idcode").addEventListener("blur",checkcode);
	document.getElementById("idname").addEventListener("blur",checkname);
	document.getElementById("idaddr").addEventListener("blur",checkaddr);
	document.getElementById("idphone").addEventListener("blur",checkphone);
	document.getElementById("idweb").addEventListener("blur",checkurl);
	
})

function checkcode(){
	var code = document.getElementById("idcode").value;
	var re= /^[0-9]{1,}$/;
	if(code=="" || code.length==0){
		alert("請輸入編號.");
	}

	if(code.length>0 && !(re.test(code))){
		alert("編號格式錯誤，請輸入數字.");
	}
	
}

function checkname(){
	var name = document.getElementById("idname").value;
	var re= /^[\u4e00-\u9fff]{1,}$/;
	if(name=="" || name.length==0){
		alert("請輸入學校名稱.");
	}
	if(name.length>0 && !(re.test(name))){
		alert("學校名稱格式錯誤，請輸入中文.");
	}
	
}
function checkaddr(){
	var addr = document.getElementById("idaddr").value;

	if(addr=="" || addr.length==0){
		alert("請輸入學校地址.");
	}
	
}

function checkphone(){
	var phone = document.getElementById("idphone").value;
	var re= /^\([0-9]{2}\)[0-9]{7,8}$/;
	if(phone=="" || phone.length==0){
		alert("請輸入學校電話.");
	}
	if(phone.length>0 && !(re.test(phone))){
		alert("學校電話格式錯誤.");
	}
	
}
function checkurl(){
	var url = document.getElementById("idweb").value;
	if(url=="" || url.length==0){
		alert("請輸入學校網站.");
	}

}
</script>

</head>
<body>
	<a href="index.html"><img src="res/back.png" class="back"></a>
	<form style="width: 900px; margin-left: 13%;" action="Insert.do"
		method="POST">
		<fieldset>
			<br>
			<legend style="font-size: 40px; color: rgba(248, 181, 81);">
				INSERT THE SCHOOL DATA</legend>
			<label>Code:</label><br> <input type="text" name="code"
				size="10" id="idcode" autocomplete="off" value="${param.code}">
			<span id="checkcode" class="error">${ErrorMsg.code}<br></span> <label>Name:</label><br>
			<input type="text" name="name" size="30" id="idname"
				value="${param.name}" placeholder="請輸入中文校名"> <span id="checkname" class="error">${ErrorMsg.name}<br></span>

			<label>Public or Private</label> <br> <input type="radio"
				name="pborpv" value="公立">公立<input type="radio" name="pborpv"
				value="私立">私立 <span id="checkpborpv" class="error">${ErrorMsg.pborpv}<br></span>

			<label>City:</label><br> <select name="city">
				<option value="[01]新北市">[01]新北市</option>
				<option value="[02]宜蘭縣">[02]宜蘭縣</option>
				<option value="[04]新竹縣">[04]新竹縣</option>
				<option value="[05]苗栗縣">[05]苗栗縣</option>
				<option value="[06]臺中市">[06]臺中市</option>
				<option value="[07]彰化縣">[07]彰化縣</option>
				<option value="[08]南投縣">[08]南投縣</option>
				<option value="[09]雲林縣">[09]雲林縣</option>
				<option value="[10]嘉義縣">[10]嘉義縣</option>
				<option value="[11]臺南市">[11]臺南市</option>
				<option value="[12]高雄市">[12]高雄市</option>
			</select> <span id="checkcity" class="error">${ErrorMsg.city}<br></span>

			<label>Address:</label><br> <input type="text" name="addr"
				size="50" id="idaddr" value="${param.addr}"> <span
				id="checkaddr" class="error">${ErrorMsg.addr}<br></span> <label>Phone:</label><br>
			<input type="text" name="phone" size="20" id="idphone"
				value="${param.phone}" placeholder="範例:(0X)XXXXXXXX"> <span id="checkphone" class="error">${ErrorMsg.phone}<br></span>

			<label>Website:</label><br> <input type="text" name="web"
				size="55" id="idweb" value="http://${param.web}"> <span
				id="checkweb" class="error">${ErrorMsg.web}<br></span> <br>

			<input type="reset" value="Reset" class="bu"> <input
				type="submit" value="OK" class="bu">


		</fieldset>
	</form>
</body>
</html>