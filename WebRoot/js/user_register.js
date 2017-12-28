var xmlHttp;
var checkflag;
var flag;
function createXMLHttp() { //创建XMLHttpRequest对象
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Mcirosoft.XMLHTTP");
	}
}
function validateUserid(userid) {
	if (userid != "") {
		createXMLHttp(); //创建xmlHttp;
		xmlHttp.open("POST", path + "/frontUserAction_checkuserid.action?user.userid=" + userid); //发送数据
		xmlHttp.onreadystatechange = validateUseridCallback;
		xmlHttp.send(null);
	} else {
		document.getElementById("useridMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
	}
}
function validateUseridCallback() {
	if (xmlHttp.readyState == 4) { //数据传送完毕
		if (xmlHttp.status == 200) { //http操作完成
			checkflag = xmlHttp.responseText;
			if (checkflag == "true") {
				//用户id合法
				document.getElementById("useridMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">用户名合法!</font>";
				flag = true;
			} else {
				//用户id不合法
				document.getElementById("useridMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">用户id已经存在!</font>";
				flag = false;
			}
		}
	}
}

function validatePassword(password) {
	if (password != "") {
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">输入正确!</font>";
		return true; //正确
	} else {
		//密码输入为空
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
		return false;
	}
}
function validateConfpassword(confpassword) {
	if (confpassword == document.getElementById("user.password").value) {
		document.getElementById("confpasswordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">输入一致!</font>";
		return true;
	} else {
		document.getElementById("confpasswordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">两次输入不一致!</font>";
		return false;
	}
}
function validateEmail(email) {
	if (/\w+@\w+\.\w+/.test(email)) {
		document.getElementById("emailMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">输入正确!</font>";
		return true;
	} else {
		document.getElementById("emailMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">输入错误!</font>";
		return false;
	}
}
function validateForm() {
	return validatePassword(document.getElementById("user.password").value) && validateConfpassword(document.getElementById("confpassword").value) && validateEmail(document.getElementById("user.email").value) && flag;
}