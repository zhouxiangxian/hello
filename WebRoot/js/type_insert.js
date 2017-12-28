function validateTitle(title){
	if(title!=""){
		document.getElementById("titleMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确!</font>";
	    return true;
	}else{
		document.getElementById("titleMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
		return false;
	}
}

function validateDescription(description){
	if(description!=""){
		document.getElementById("descriptionMsg").innerHTML="<img src=\""+path+"/images/right.gif\"><font color=\"green\">输入正确!</font>";
		return true;
	}else{
		document.getElementById("descriptionMsg").innerHTML="<img src=\""+path+"/images/wrong.gif\"><font color=\"red\">不能为空!</font>";
		return false;
	}
}
function validateForm(){
	return validateTitle(document.getElementById("type.title").value)&&validateDescription(document.getElementById("type.description").value)
}