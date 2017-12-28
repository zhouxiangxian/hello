var xmlHttp;
var tabName;//保存操作
function createXMLHttp(){//创建xmlHttp对象
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function loadQuestion(tid,currentPage,lineSize,tableName){
	//创建xmlHtt对象
	createXMLHttp();
	tabName=tableName;
	xmlHttp.open("POST",path+"/jsp/front/frontQuestionAction_listSplit.action?tid="+tid+"&currentPage="+currentPage+"&lineSize="+lineSize+"&tableName="+tableName);//发送请求
	xmlHttp.onreadystatechange=loadQuestionCallback;
	xmlHttp.send(null);
}
function loadQuestionCallback(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			//alert(xmlHttp.responseText);
			clearTable();//清空表格
			//接收数据
			var  doc=xmlHttp.responseXML;
			allQid =doc.getElementsByTagName("qid");//问题编号
			allTitle=doc.getElementsByTagName("title");//问题名称
			allCount=doc.getElementsByTagName("count");//统计量
			allStatus=doc.getElementsByTagName("status");//问题状态
			//获取要增加数据的表格对象
			var tab=document.getElementById(tabName);
			if(allQid!=null){
				for(var i=0;i<allQid.length;i++){
					var qid=allQid[i].firstChild.nodeValue;//获取值
					var title=allTitle[i].firstChild.nodeValue;
					var count=allCount[i].firstChild.nodeValue;
					var status=allStatus[i].firstChild.nodeValue;
					var tr=tab.insertRow(i);//增加新的一行
					var titleTD=tr.insertCell(0);//增加列
					var countTD=tr.insertCell(1);
					titleTD.setAttribute("align","left");
					titleTD.setAttribute("class","text_14_666");
					countTD.setAttribute("align","right");
					countTD.setAttribute("class","text_14_999");
					titleTD.innerHTML="<a href=\"#\" class=\"a_14_blue\" title=\"查看该类问题\">["+type+"]</a>&nbsp;<a  href=\""+path+"/jsp/front/frontQuestionAction_show.action?question.qid="+qid+"\" class=\"a_14_blue\">"+title+"</a><span>["+(status==0?"已解决":"未解决")+"]</span>";
					countTD.innerHTML=count+" 回答";
				}
			}
		}
	}
}
function clearTable(){
	var tab=document.getElementById(tabName);
	var count=tab.rows.length;
	for(var i=0;i<count-1;i++){
		tab.deleteRow(0);
	}
}