//管理员的登录验证
function validateAdminid(adminid){//验证id
	if(adminid!=""){
		document.getElementById("adminidMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确！</font>";
		return true;
	}else{
		document.getElementById("adminidMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">用户名不能为空!</font>";
		return false;
	}
}
function validatePassword(password){//验证密码
	if(password!=""){
		document.getElementById("passwordMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确!</font>";
		return true;
	}else{
		document.getElementById("passwordMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">密码不能为空!</font>";
		return false;
	}
}
var xmlHttp;//声明XMLHttpRequest对象
var flag=false;//验证码标记
var callBackResult="false";
//创建XMLHttpRequest对象
function createXMLHttp(){
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();//火狐浏览器
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function validateCode(code){
	//创建对象
	createXMLHttp();
	xmlHttp.open("POST","backAdminAction_validateCode.action?code="+code);
	xmlHttp.onreadystatechange=validateCodeCallback;//回调函数
	xmlHttp.send(null);
}
function validateCodeCallback(){
	if(xmlHttp.readyState==4){//数据返会完成
		if(xmlHttp.status==200){//http操作正常
			var callBackResult=xmlHttp.responseText;//接收数据
			if(callBackResult=="true"){
				//验证码正确
				document.getElementById("codeMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">验证码输入正确!</font>";
				flag=true;
			}else{
				//验证码输入错误
				document.getElementById("codeMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">验证码输入错误!</font>";
				flag=false;
			}
		}
	}
}
function validateForm(){
	return validateAdminid(document.getElementById("admin.adminid").value)&&validatePassword(document.getElementById("admin.password").value)&&flag;
}