<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�ǻ�����Ŀ</title>
<script type="text/javascript">
	function changeColor(obj, color) {
		obj.bgColor = color;
	}
	function deleteType(){
	   return window.confirm("ȷ��ɾ����?");
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
   <h1>���������б�</h1>
    <s:if test="#request.all!=null">
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr class="type_center" onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="12%"><strong>���ͱ��:</strong></td>
				<td width="15%"><strong>����:</strong></td>
				<td width="53%"><strong>����:</strong></td>
				<td colspan="2"><strong>����:</strong></td>
			</tr>
			<s:iterator value="#request.all">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td>${tid }</td>
					<td>${title }</td>
					<td>${description}</td>
					<td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backTypeAction_updatePre.action?type.tid=${tid}" >�޸�</a></td>
				    <td width="10%" class="oper_center"><a href="${pageContext.request.contextPath }/jsp/back/backTypeAction_delete.action?type.tid=${tid}" onclick="return deleteType()">ɾ��</a></td>
				</tr>
			</s:iterator>
	   </table>
     </s:if>
   </center>
</body>
</html>
