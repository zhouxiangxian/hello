<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�ǻ�����Ŀ</title>
<script type="text/javascript">
     var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/type_insert.js" charset="utf-8"></script>
<script type="text/javascript">
	function changeColor(obj, color) {
		obj.bgColor = color;
	}
</script>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</head>
<body>
   <center>
     <s:if test="#request.type!=null">
     <form action="${pageContext.request.contextPath }/jsp/back/backTypeAction_update.action" method="post" onsubmit="return validateForm()">
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><div align="center" class="STYLE1">�޸���������</div></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="15%"><strong>��������:</strong></td>
				<td width="29%"><input type="text" name="type.title" id="type.title" onblur="validateTitle(this.value)" value="${type.title }"></td>
				<td width="56%"><span id="titleMsg">*</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td><strong>��������:</strong></td>
				<td><input type="text" name="type.description" id="type.description" onblur="validateDescription(this.value)" value="${type.description }"></td>
				<td><span id="descriptionMsg">*</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">
				   <div align="center">
				       <input type="hidden" value="${type.tid }" name="type.tid" id="type.tid">
					   <input type="submit" value="�޸�">
					   <input type="reset" value="ȡ��">
				   </div>
				</td>
			</tr>
		</table>
	</form>
	</s:if>
   </center>
</body>
</html>
