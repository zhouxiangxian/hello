var xmlHttp;
var codeflag;
var flag=false;
var userPointsCallback = 0; //用户分数，接收来自后台处理的值
var tempUserPoints; //临时保存来自前台的奖赏分数
var pointsflag = "false"; //分数标记，避免反复验证
function createXMLHttp() { //创建XMLHTTPRequest对象
	if (window.XMLHttpRequest) { //判断浏览器的类型
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
	}
}
function validateCode(code) { //验证验证码的正确性
	//创建对象
	createXMLHttp();
	xmlHttp.open("POST", path + "/jsp/front/frontQuestionAction_validateCode.action?code=" + code); //发送数据
	xmlHttp.onreadystatechange = validateCodeCallback;
	xmlHttp.send(null);
}
function validateCodeCallback() {
	if (xmlHttp.readyState == 4) { //发送数据完成
		if (xmlHttp.status == 200) { //http操作完成
			codeflag = xmlHttp.responseText;
			if (codeflag == "true") {
				//验证码正确
				document.getElementById("codeMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">验证码输入正确!</font>";
				flag = true;
			} else {
				//验证码错误
				document.getElementById("codeMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">验证码输入错误!</font>";
				flag = false;
			}
		}
	}
}
//验证标题
function validateTitle(title) {
	if (title != "") {
		document.getElementById("titleMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">标题输入正确!</font>";
		return true;
	} else {
		document.getElementById("titleMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">标题输入错误!</font>";
		return false;
	}
}
//验证内容
function validateContent(content) {
	if (content != "") {
		document.getElementById("contentMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">问题内容输入正确!</font>";
		return true;
	} else {
		document.getElementById("contentMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">问题内容输入错误!</font>";
		return false;
	}
}
//验证分数
function validatePoints(points, userid) {
	if (/^\d+$/.test(points)) {
		getUserPoints(userid); //获取用户的分数
		tempUserPoints = parseInt(points);
		if (tempUserPoints != 0) {
			if (tempUserPoints > userPointsCallback) {
				//用户几积分数不足，给出提示
				document.getElementById("pointsMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">积分不足，您一共有" + userPointsCallback + "分!</font>";
				return false;
			} else {
				document.getElementById("pointsMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">奖赏分数输入正确!</font>";
				return true;
			}
		} else {
			//是数字	
			document.getElementById("pointsMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">奖赏分数输入正确!</font>";
			return true;
		}
	} else {
		//不是数字
		document.getElementById("pointsMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">奖赏分数只能为数字!</font>";
		return false;
	}
}

function getUserPoints(userid) { //根据用户id获取用户的分数
	createXMLHttp(); //创建XMLHttpRequest对象
	if (pointsflag == "false") {
		xmlHttp.open("POST", path + "/frontUserAction_checkPoints.action?user.userid=" + userid); //向指定路径发送数据
		xmlHttp.onreadystatechange = getUserPointsCallback; //调用回调函数
		xmlHttp.send(null);
	}
}
function getUserPointsCallback() {
	if (xmlHttp.readyState == 4) { //数据发送完毕
		if (xmlHttp.status == 200) { //Http操作正确
			if (xmlHttp.responseText == null) {
				userPointsCallback = parseInt("0");
			} else {
				userPointsCallback = parseInt(xmlHttp.responseText); //获取用户几分熟
			}
			pointsflag = "true"; //改变标志
		}
	}
}
function validateForm() {
	return validateTitle(document.getElementById("question.title").value) &&
		validateContent(document.getElementById("question.content").value) &&
		validatePoints(document.getElementById("question.points").value, document.getElementById("question.user.userid").value) &&
		flag;
}