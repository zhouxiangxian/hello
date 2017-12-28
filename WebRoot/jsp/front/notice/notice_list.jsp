<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>智囊团2.0-首页</title>
<script  src="${pageContext.request.contextPath }/js/PNG_IMG.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function changeColor(obj, color) {
		obj.bgColor = color;
	}
	function deleteType(){
	   return window.confirm("确认删除吗?");
	}
</script>

<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
}
.type_center {
	text-align: center;
}
.oper_center {
	text-align: center;
	font-size: 14px;
}
.content_center {
	text-align: left;
}
-->
</style>
</head>
<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td>
      <!--logo and navigation start-->
      <jsp:include page="/head_logo.jsp"/>
      <!--logo and navigation end-->
      </td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="top_search">
	    <!--top search start-->
	    <jsp:include page="/head_form.jsp"/> 
	    <!--top search end-->
    </td>
  </tr>
  <tr>
    <td class="container">
    <s:if test="#request.allNotices!=null">
	    <jsp:include page="/split_page.jsp" >
		   <jsp:param name="currentPage" value="${currentPage }" />
		   <jsp:param name="lineSize" value="${lineSize }" />
		   <jsp:param name="allRecorders" value="${allRecorders }" />
		   <jsp:param name="actionUrl" value="${actionUrl }" />
		   <jsp:param name="column" value="${column }" />
		   <jsp:param name="columnName" value="${columnName }" />
		   <jsp:param name="defaultColumnName" value="${defaultColumnName }" />
		   <jsp:param name="keyWord" value="${keyWord }" />
		   <jsp:param name="searchFlag" value="FALSE"/>
		</jsp:include>
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr class="type_center" onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="12%"><strong>公告编号:</strong></td>
				<td width="15%"><strong>公告名称:</strong></td>
				<td width="53%"><strong>发布日期:</strong></td>
			</tr>
			<s:iterator value="#request.allNotices">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td>${nid }</td>
					<td>${title }</td>
					<td>${pubtime}</td>
				</tr>
			</s:iterator>
	   </table>
     </s:if>
     </td>
     </tr>
     </table>
</body>
</html>
