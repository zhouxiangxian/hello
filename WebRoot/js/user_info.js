function validateEmail(email){
	if(/\w+@\w+.\w+/.test(email)){
		document.getElementById("emailMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">email输入正确!</font>";
		return true;
	}else{
		document.getElementById("emailMsg").innerHMTL="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">email输入错误!</font>";
		return false;
	}
}
function validateForm(){
	return validateEmail(document.getElementById("user.email").value);
}