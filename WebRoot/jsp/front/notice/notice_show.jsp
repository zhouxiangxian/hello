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
   <s:if test="#request.notice!=null">
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><div align="center" class="STYLE1">查看公告</div></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="15%"><strong>公告名称:</strong></td>
				<td width="29%">${notice.title }</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><strong>公告内容:</strong></td>
            </tr>
			<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">
					<div class="editor">
					${notice.content }
				    </div>
				</td>
			</tr>
		</table>
	</s:if>
	</td>
	</tr>
	</table>
</body>
</html>
