function validateTitle(title){
	if(title!=""){
		document.getElementById("titleMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确!</font>";
	    return true;
	}else{
		document.getElementById("titleMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
		return false;
	}
}

function validateContent(content){
	if(content!=""){
		document.getElementById("contentMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确!</font>";
		return true;
	}else{
		document.getElementById("contentMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
		return false;
	}
}
function validateForm(){
	return validateTitle(document.getElementById("notice.title").value)&&validateContent(document.getElementById("notice.content").value)
}