<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<%
	//�������
	int currentPage = 1;//��ǰҳ
	int lineSize = 10;//ÿҳ��ʾ
	int allRecorders = 0;//��ҳ��
	int pageSize = 1;//��ҳ��
	int tid=1;//��������
	String tableName = null;//��ҳ���ǩ
%>
<%
	//��������
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));//���ݹ����ĵ�ǰҳ
	} catch (Exception e) {
	}
	try{
	    lineSize=Integer.parseInt(request.getParameter("lineSize"));//ÿҳ��ʾ
	}catch(Exception e){}
	try{
		tid=Integer.parseInt(request.getParameter("tid"));
	}catch(Exception e){}
	try{
	    allRecorders=Integer.parseInt(request.getParameter("allRecorders"));//�ܼ�¼��
	}catch(Exception e){}
	tableName=request.getParameter("tableName");//���ձ���
	//������ҳ��
	pageSize=(allRecorders+lineSize-1)/lineSize;
	if(pageSize==0){//��ҳ��Ϊ0���ı�Ϊ1ҳ
	    pageSize=1;
	}
%>
<!--��ҳ Start-->
 <script type="text/javascript">
    var  pageSize<%=tableName%>=<%=pageSize%>;//�ܵ�ҳ��
    var  currentPage<%=tableName%>=<%=currentPage%>;//��ǰҳ
    var max<%=tableName%>=5;//��ʾ����
 	function controlSplit<%=tableName%>(cp){//���Ʒ�ҳ����ʾ
         var   divObj<%=tableName%>=document.getElementById("div-<%=tableName%>");
         var content="";  
         if(cp==1){//��ǰҳΪ��һҳ
             content += "<span class=\"disabled\">&lt;  ��һҳ</span>" ;
             content+="<span class=\"current\">1</span>";
         }else{
         	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');goPrevious<%=tableName%>()\">&lt;��һҳ</a>";
         	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>(1)\">1</a>";
         }
         var tail=0;
         if(cp>max<%=tableName%>){
         	content+="...";
            for(var i=cp-3;i<pageSize<%=tableName%>;i++){
         		 if(tail++>max<%=tableName%>){
	         		content+="...";
	         		break;//����ѭ��
	         	 }
	         	 if(cp==i){//��ǰ��ѡ��
	                 content+="<span class=\"current\">"+cp+"</span>";
	         	 }else{
	            	 content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+i+")\">"+i+"</a>";
	         	 }
            }     
         }else{
         	for(var i=2;i<pageSize<%=tableName%>;i++){
         		 if(tail++>max<%=tableName%>){
	         		content+="...";
	         		break;//����ѭ��
	         	 }
	         	 if(cp==i){//��ǰ��ѡ��
	                 content+="<span class=\"current\">"+cp+"</span>";
	         	 }else{
	            	 content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+currentPage<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+i+")\">"+i+"</a>";
	         	 }
            }
         }
         
         if(cp==pageSize<%=tableName%>){//��ǰҳ�����һҳ
         	if(pageSize<%=tableName%>!=1){
         		content+="<span class=\"current\">"+pageSize<%=tableName%>+"</span>";
         	}
         	content+="<span class=\"disabled\">��һҳ &gt;</span>";
         }else{
           	content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+pageSize<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');controlSplit<%=tableName%>("+pageSize<%=tableName%>+")\">"+pageSize<%=tableName%>+"</a>";
            content+="<a href=\"#\" onclick=\"loadQuestion(<%=tid%>,"+pageSize<%=tableName%>+",<%=lineSize%>,'<%=tableName%>');goNext<%=tableName%>()\">��һҳ &gt;</a>";
         }
         divObj<%=tableName%>.innerHTML=content;//�ı�����
         currentPage<%=tableName%>=cp;//���浱ǰҳ
 	}
 	function goPrevious<%=tableName%>(){//��һҳ����ʾ
         controlSplit<%=tableName%>(currentPage<%=tableName%>-1);
 	}
 	function goNext<%=tableName%>(){
 		controlSplit<%=tableName%>(currentPage<%=tableName%>+1);
 	}
 </script>
<div class="manu" id="div-<%=tableName%>">
	
</div>
<!--��ҳ end-->
<script type="text/javascript">
       controlSplit<%=tableName%>(<%=currentPage%>);
</script>