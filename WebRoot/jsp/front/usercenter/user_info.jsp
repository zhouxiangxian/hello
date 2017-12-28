<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>智囊团2.0-会员中心-个人资料</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_info.js" charset="UTF-8">
        </script>
        <script type="text/javascript" >
            var path="${pageContext.request.contextPath}";
        </script>
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/PNG_IMG.js"
			type="text/javascript"></script>
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/tag.js"
			type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/userStyle.css"
			rel="stylesheet" type="text/css" />
	</head>
	<body>
		<table width="1000" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td>
					<!--logo and navigation start-->
					<jsp:include page="/head_logo.jsp"/>
					<!--顶 部导航结束-->
				</td>
			</tr>
			<tr>
				<td align="center" valign="middle" class="top_search">
					<!--顶部搜索开始-->
					<jsp:include page="/head_form.jsp"/>
					<!---顶部搜索结束-->
					<!--logo and navigation end-->
				</td>
			</tr>

			<tr>
				<td class="container">
					<!--content start-->

					<table width="1000" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="230" align="left" valign="top">
								<jsp:include page="user_menu.jsp"/>
							</td>
							<td width="10"></td>
							<td width="760" align="left" valign="top">
								<!--主体标题 start-->
								<div class="uc_body_title">
									<ul>
										<li>
											<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="返回首页">首页</a>&nbsp;-&gt;&nbsp;会员中心&nbsp;-&gt;&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" class="a_14_666" title="个人资料">个人资料</a>
										</li>
										<li>
											<img src="${pageContext.request.contextPath }/images/uc_body_title_line.jpg" width="760"
												height="4" border="0" />
										</li>
									</ul>
								</div>
								<!--主体标题 end-->
								<!--Content Start-->
								<table width="400" border="0" cellspacing="0" cellpadding="0"
									class="uc_info_tab">
									<tr>
										<td class="uc_info_tab_title" valign="middle">
											&nbsp;&nbsp;个人资料
										</td>
									</tr>
									<tr>
										<td class="uc_info_tab_content">
											<form action="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_update.action" method="post"
											enctype="multipart/form-data">
												<table width="360" border="0" cellspacing="0"
													cellpadding="0" align="center">
													<tr>
														<td width="70">
															用&nbsp;户&nbsp;名：
														</td>
														<td width="290" class="text_14_999">
															${user.userid }
														</td>
													</tr>
													<tr>
														<td>
															性&nbsp;&nbsp;&nbsp;&nbsp;别：
														</td>
														<td class="text_14_999">
															<input type="radio" name="user.sex" id="user.sex" value="man"
																${user.sex=="man"?"CHECKED":"" } />
															男&nbsp;
															<input type="radio" name="user.sex" id="user.sex" value="woman" ${user.sex=="woman"?"CHECKED":"" } />
															女
														</td>
													</tr>
													<tr>
													    <td class="text_14_666">电子邮箱：</td>
													    <td align="left"><input type="text" class="user_reg_input" name="user.email" id="user.email" value="${user.email }" onblur="validateEmail(this.value)"/></td>
													    <td width="340" align="left"><span id="emailMsg">*</span></td>
													  </tr>
													<tr>
													<tr>
													    <td class="text_14_666">用户照片：</td>
													    <td align="left" colspan="2">
														    <input type="file" class="user_reg_input" name="photo" id="photo" />
														    <input type="hidden" name="oldpic" id="oldpic" value="${user.image }"/>
													    </td>
													  </tr>
													<tr>
														<td>
															&nbsp;
														</td>
														<td>
															<button class="uc_info_button" type="submit"
																name="button01">
																<img
																	src="${pageContext.request.contextPath}/images/save_button.jpg"
																	width="80" height="40" border="0" />
															</button>
															&nbsp;&nbsp;
															<button class="uc_info_button" type="reset"
																name="button02">
																<img
																	src="${pageContext.request.contextPath}/images/cancel_button.jpg"
																	width="80" height="40" border="0" />
															</button>
														</td>
													</tr>
												</table>
											</form>


										</td>
									</tr>
									<tr>
										<td>
											<img
												src="${pageContext.request.contextPath}/images/uc_userinfo_tab_bottom.jpg"
												width="400" height="10" border="0" />
										</td>
									</tr>
								</table>

								<!--Content end-->

							</td>
						</tr>
					</table>





					<!--contnet end-->
				</td>
			</tr>
			<tr>
				<td class="copyright">
					Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN all rights reserved
					版权所有&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.mldnjava.cn" class="a_12_blue"
						title="魔乐科技软件学院-Java培训">魔乐科技软件学院</a>
				</td>
			</tr>
		</table>
	</body>
</html>
