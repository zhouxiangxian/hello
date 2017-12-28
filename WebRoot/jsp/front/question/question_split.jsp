<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<%
	//定义变量
	int currentPage = 1;//当前页
	int lineSize = 10;//每页显示
	int allRecorders = 0;//总页数
	int pageSize = 1;//总页数
	int tid=1;//问题类型
	String tableName = null;//分页表标签
%>
<%
	//接收数据
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));//传递过来的当前页
	} catch (Exception e) {
	}
	try{
	    lineSize=Integer.parseInt(request.getParameter("lineSize"));//每页显示
	}catch(Exception e){}
	try{
		tid=Integer.parseInt(request.getParameter("tid"));
	}catch(Exception e){}
	try{
	    allRecorders=Integer.parseInt(request.getParameter("allRecorders"));//总记录数
	}catch(Exception e){}
	tableName=request.getParameter("tableName");//接收表标记
	//计算总页数
	pageSize=(allRecorders+lineSize-1)/lineSize;
	if(pageSize==0){//总页数为0，改变为1页
	    pageSize=1;
	}
%>
<!--翻页 Start-->
 <script type="text/javascript">
    var  pageSize<%=tableName%>=<%=pageSize%>;//总的页数
    var  currentPage<%=tableName%>=<%=currentPage%>;//当前页
    var max<%=tableName%>=5;//显示个数
 	function controlSplit<%=tableName%>(cp){//控制分页的显示
         var   divObj<%=tableName%>=document.getElementById("div-<%=tableName%>");
         var content="";  
         if(cp==1){//当前页为第一页
             content += "<span class=\"disabled\">&lt;  上一页</span>" ;
             content+="<span class=\"current\">1</span>";
         }else{
         	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');goPrevious<%=tableName%>()\">&lt;上一页</a>";
         	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>(1)\">1</a>";
         }
         var tail=0;
         if(cp>max<%=tableName%>){
         	content+="...";
            for(var i=cp-3;i<pageSize<%=tableName%>;i++){
         		 if(tail++>max<%=tableName%>){
	         		content+="...";
	         		break;//跳出循环
	         	 }
	         	 if(cp==i){//当前就选中
	                 content+="<span class=\"current\">"+cp+"</span>";
	         	 }else{
	            	 content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+i+")\">"+i+"</a>";
	         	 }
            }     
         }else{
         	for(var i=2;i<pageSize<%=tableName%>;i++){
         		 if(tail++>max<%=tableName%>){
	         		content+="...";
	         		break;//跳出循环
	         	 }
	         	 if(cp==i){//当前就选中
	                 content+="<span class=\"current\">"+cp+"</span>";
	         	 }else{
	            	 content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+i+")\">"+i+"</a>";
	         	 }
            }
         }
         
         if(cp==pageSize<%=tableName%>){//当前页是最后一页
         	if(pageSize<%=tableName%>!=1){
         		content+="<span class=\"current\">"+pageSize<%=tableName%>+"</span>";
         	}
         	content+="<span class=\"disabled\">下一页 &gt;</span>";
         }else{
           	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+pageSize<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+pageSize<%=tableName%>+")\">"+pageSize<%=tableName%>+"</a>";
            content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+pageSize<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');goNext<%=tableName%>()\">下一页 &gt;</a>";
         }
         divObj<%=tableName%>.innerHTML=content;//改变内容
         currentPage<%=tableName%>=cp;//保存当前页
 	}
 	function goPrevious<%=tableName%>(){//上一页的显示
         controlSplit<%=tableName%>(currentPage<%=tableName%>-1);
 	}
 	function goNext<%=tableName%>(){
 		controlSplit<%=tableName%>(currentPage<%=tableName%>+1);
 	}
 </script>
<div class="manu" id="div-<%=tableName%>">
	
</div>
<!--翻页 end-->
<script type="text/javascript">
       controlSplit<%=tableName%>(<%=currentPage%>);
</script>