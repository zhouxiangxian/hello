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
   <h1>问题类型列表</h1>
    <s:if test="#request.all!=null">
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr class="type_center" onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="12%"><strong>类型编号:</strong></td>
				<td width="15%"><strong>名称:</strong></td>
				<td width="53%"><strong>描述:</strong></td>
				<td colspan="2"><strong>操作:</strong></td>
			</tr>
			<s:iterator value="#request.all">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td>${tid }</td>
					<td>${title }</td>
					<td>${description}</td>
					<td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backTypeAction_updatePre.action?type.tid=${tid}" >修改</a></td>
				    <td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backTypeAction_delete.action?type.tid=${tid}" onclick="return deleteType()">删除</a></td>
				</tr>
			</s:iterator>
	   </table>
     </s:if>
   </center>
</body>
</html>
