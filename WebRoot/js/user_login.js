var xmlHttp; //使用ajax完成数据的验证
var callbackflag = "false";
var flag;
function createXMLHttp() {
	if (window.XMLHttpRequest) { //判断浏览器的使用类型
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function validateCode(code) {
	createXMLHttp(); //创建xmlHttp对象
	xmlHttp.open("POST", "frontUserAction_validateCode.action?code=" + code); //发送数据
	xmlHttp.onreadystatechange = validateCodeCallback; //调用回调函数
	xmlHttp.send(null);
}
function validateCodeCallback() {
	if (xmlHttp.readyState == 4) { //数据返回完毕
		if (xmlHttp.status == 200) { //http操作完成
			callbackflag = xmlHttp.responseText;
			if (callbackflag == "true") {
				//验证成功，给出正确的提示
				document.getElementById("codeMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">验证码输入正确！！！</font>";
				flag = true;
			} else {
				//验证码错误
				document.getElementById("codeMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">验证码输入错误！！！</font>";
				flag = false;
			}
		}
	}
}
function validateUserid(userid) {
	if (userid != "") {
		document.getElementById("useridMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">用户ID输入正确！！！</font>";
		return true;
	} else {
		document.getElementById("useridMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">用户ID输入错误！！！</font>";
		return false;
	}

}
function validatePassword(password) {
	if (password != "") {
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">密码输入正确！！！</font>";
		return true;
	} else {
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">密码输入错误！！！</font>";
		return false;
	}
}
function validateForm() {
	return validateUserid(document.getElementById("user.userid").value) && validatePassword(document.getElementById("user.password")) && flag;
}