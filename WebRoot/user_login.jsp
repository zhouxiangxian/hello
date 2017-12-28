<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>智囊团2.0-用户登录</title>
<script type="text/javascript">
    var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_login.js" charset="UTF-8" ></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/PNG_IMG.js"
	type="text/javascript"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/tag.js"
	type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table width="1000" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr>
			<td>
				<!--logo and navigation start--> <jsp:include page="head_logo.jsp" />
				<!--logo and navigation end-->
			</td>
		</tr>
		<tr>
			<td align="center" valign="middle" class="top_search">
				<!--top search start--> <jsp:include page="head_form.jsp" /> <!--top search end-->
			</td>
		</tr>
		<tr>
			<td class="container">
				<!--content start-->

				<table width="468" border="0" cellspacing="0" cellpadding="0"
					class="login_tab">
					<tr>
						<td height="40" align="left" valign="middle" class="login_title">&nbsp;&nbsp;用户登录</td>
					</tr>
					<tr>
						<td><table width="408" border="0" cellspacing="0"
								cellpadding="0" class="login_content_tab">
								<form action="frontUserAction_login" method="post" onsubmit="return validateForm()">
									<tr>
										<td width="78" align="right" class="text_14_666">用户名：</td>
										<td width="130"><input type="text" class="login_input" name="user.userid" id="user.userid" onblur="validateUserid(this.value)"/></td>
										<td width="200" ><span id="useridMsg">*</span></td>
									</tr>
									<tr>
										<td align="right" class="text_14_666">密 &nbsp;码：</td>
										<td><input type="password" class="login_input" name="user.password" id="user.password" onblur="validatePassword(this.value)"/></td>
									    <td width="200" ><span id="passwordMsg">*</span></td>
									</tr>
									<tr>
										<td align="right" class="text_14_666">验证码：</td>
										<td><input type="text" class="login_code" name="code" id="code" maxlength="4" size="4" onblur="validateCode(this.value)" />&nbsp;<img alt="验证码" src="${pageContext.request.contextPath }/image.jsp"></td>
										<td><span id="codeMsg">*</span></td>
									</tr>
									<tr>
										<td align="right"></td>
										<td align="left">
											<input type="image" src="${pageContext.request.contextPath }/images/user_login_button.gif"
												width="80" height="40" border="0" />
										</td>
									</tr>
								</form>
							</table></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table> <!--contnet end-->
			</td>
		</tr>
		<tr>
			<td class="copyright">Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN
				all rights reserved 版权所有&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="http://www.mldnjava.cn" class="a_12_blue"
				title="魔乐科技软件学院-Java培训">魔乐科技软件学院</a>
			</td>
		</tr>
	</table>
</body>
</html>

