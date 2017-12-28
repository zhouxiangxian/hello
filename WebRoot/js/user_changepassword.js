function validatePassword(password) {
	if (password != "") {
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">密码输入正确!</font>";
		return true;
	} else {
		document.getElementById("passwordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">密码输入错误!</font>";
		return false;
	}
}
function validateConfPassword(confpassword) {
	if (confpassword != "") {
		//判断两次密码是否一致
		if (confpassword == document.getElementById("user.password").value) {
			document.getElementById("confpasswordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">确认密码输入正确!</font>";
			return true;
		} else {
			document.getElementById("confpasswordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">两次密码输入不一致!</font>";
			return false;
		}
	} else {
		document.getElementById("confpasswordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">确认密码不能为空!</font>";
		return false;
	}
}
function validateOldPassword(oldPassword) {
	if (oldPassword != "") {
		document.getElementById("oldPasswordMsg").innerHTML = "<img src=\"" + path + "/images/right.gif\"><font color=\"green\">原始密码输入正确!</font>";
		return true;
	} else {
		document.getElementById("oldPasswordMsg").innerHTML = "<img src=\"" + path + "/images/wrong.gif\"><font color=\"red\">原始密码不能为空!</font>";
		return false;
	}
}

function validateForm() {
	return validateOldPassword(document.getElementById("oldPassword").value) && validatePassword(document.getElementById("user.password").value) && validateConfPassword(document.getElementById("confpassword").value);
}