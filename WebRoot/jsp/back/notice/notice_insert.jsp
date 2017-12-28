<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智慧云项目</title>
<script type="text/javascript">
     var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/notice_insert.js" charset="utf-8"></script>
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

<style type="text/css" rel="stylesheet">
    .source {
    width: 700px;
    font-size: 12px;
    font-family:Courier New;
    border: 1px solid #AAAAAA;
    background-color: #F0F0EE;
    padding: 5px;
    }
    .source pre {
    margin: 0;
    }
    form {
    margin: 0;
    }
    .editor {
    margin-top: 5px;
    margin-bottom: 5px;
    }
  </style>

	<script type="text/javascript" charset="utf-8" src="edit/lang/zh_CN.js"></script>
	<script type="text/javascript" charset="utf-8" src="edit/kindeditor-core.js"></script>
	<script type="text/javascript" charset="utf-8" src="edit/plugin-all.js"></script>
	<script type="text/javascript">
		KE.show({
			id : 'notice.content',
			cssPath : 'edit/index.css'
		});
	</script>
</head>
<body>
   <center>
     <form action="${pageContext.request.contextPath }/jsp/back/backNoticeAction_insert.action" method="post" onsubmit="return validateForm()">
       <table border="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><div align="center" class="STYLE1">增加新公告</div></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="15%"><strong>公告名称:</strong></td>
				<td width="29%"><input type="text" name="notice.title" id="notice.title" onblur="validateTitle(this.value)"></td>
				<td width="56%"><span id="titleMsg">*</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><strong>公告内容:</strong></td>
            </tr>
			<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">
					<div class="editor">
					<textarea id="notice.content" name="notice.content" style="width:650px;height:200px;visibility:hidden;" onblur="validateContent(this.value)"></textarea>
				    </div>
					<span id="contentMsg">*</span>
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">
				   <div align="center">
					   <input type="submit" value="提交">
					   <input type="reset" value="重置">
				   </div>
				</td>
			</tr>
		</table>
	</form>
   </center>
</body>
</html>
