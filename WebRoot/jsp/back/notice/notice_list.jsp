<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智慧云项目</title>
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
<body>
   <center>
   <h1>公告列表</h1>
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
				<td colspan="2"><strong>操作:</strong></td>
			</tr>
			<s:iterator value="#request.allNotices">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td>${nid }</td>
					<td>${title }</td>
					<td>${pubtime}</td>
					<td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backNoticeAction_updatePre.action?notice.nid=${nid}" >修改</a></td>
				    <td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backNoticeAction_delete.action?notice.nid=${nid}" onclick="return deleteType()">删除</a></td>
				</tr>
			</s:iterator>
	   </table>
     </s:if>
   </center>
</body>
</html>
