<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>������2.0-�û�ע��</title>
<script type="text/javascript">
   var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_register.js" charset="utf-8"></script>
<script language="javascript" src="${pageContext.request.contextPath }/js/PNG_IMG.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath }/js/tag.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
		<td>
			<!--logo and navigation start-->
			 <jsp:include page="/head_logo.jsp" />
			<!--logo and navigation end-->
		</td>
	</tr>
	<tr>
		<td align="center" valign="middle" class="top_search">
			<!--top search start-->
			 <jsp:include page="/head_form.jsp" /> 
			<!--top search end-->
		</td>
	</tr>
  <tr>
    <td class="container"><!--content start-->
      
      <div class="user_reg_content">
  <div class="user_reg_container">
<table width="420" border="0" cellspacing="0" cellpadding="0" align="center" class="user_reg_table">
  <tr>
    <td colspan="2" class="user_reg_title" valign="middle" height="32">�û�ע��</td>
  </tr>
  <form action="${pageContext.request.contextPath }/frontUserAction_register" method="post" onsubmit="return validateForm()">
  <tr>
    <td width="80" class="text_14_666">��&nbsp;��&nbsp;����</td>
    <td width="340" align="left"><input type="text" class="user_reg_input" name="user.userid" id="user.userid" onblur="validateUserid(this.value)" /></td>
    <td width="340" align="left"><span id="useridMsg">*</span></td>
  </tr>
  <tr>
    <td class="text_14_666">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
    <td align="left"><input type="radio" name="user.sex" id="user.sex" value="man" checked="checked" />��&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.sex" id="user.sex" value="woman" />Ů</td>
    <td width="340" align="left"><span id="sexMsg">*</span></td>
  </tr>
  <tr>
    <td class="text_14_666">�������룺</td>
    <td align="left"><input type="password" class="user_reg_input" name="user.password" id="user.password" onblur="validatePassword(this.value)"/></td>
    <td width="340" align="left"><span id="passwordMsg">*</span></td>
  </tr>
  <tr>
    <td class="text_14_666">ȷ�����룺</td>
    <td align="left"><input type="password" class="user_reg_input" name="confpassword" id="confpassword" onblur="validateConfpassword(this.value)"/></td>
    <td width="340" align="left"><span id="confpasswordMsg">*</span></td>
  </tr>
  <tr>
    <td class="text_14_666">�������䣺</td>
    <td align="left"><input type="text" class="user_reg_input" name="user.email" id="user.email" onblur="validateEmail(this.value)"/></td>
    <td width="340" align="left"><span id="emailMsg">*</span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="left"><input type="hidden" name="user.points" value="0"><button type="submit" class="user_reg_button"><img src="${pageContext.request.contextPath }/images/user_reg_button01.gif" width="80" height="40" border="0" /></button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="reset" class="user_reg_button"><img src="${pageContext.request.contextPath }/images/user_reg_button02.gif" width="80" height="40" border="0" /></button></td>
  </tr>
  </form>
</table>

  </div>
  <div class="user_reg_bottom_img"><img src="${pageContext.request.contextPath }/images/user_reg_tab_bottom.jpg" width="466" height="30" border="0" /></div>
  </div>
      
      
      

      <!--contnet end--></td>
  </tr>
  <tr>
     <td class="copyright">
		Copyright 2010 ������ WWW.ZHINANGTUAN.NET.CN all rights reserved��Ȩ����&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue" title="��ɳѧԺ">��ɳѧԺ</a>
    </td>
  </tr>
</table>
</body>
</html>

