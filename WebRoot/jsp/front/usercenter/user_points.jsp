<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>������2.0-��Ա����-�ҵĻ���</title>
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
					<!--�� ����������-->
				</td>
			</tr>
			<tr>
				<td align="center" valign="middle" class="top_search">
					<!--����������ʼ-->
					<jsp:include page="/head_form.jsp"/>
					<!---������������-->
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
								<!--������� start-->
								<div class="uc_body_title">
									<ul>
										<li>
											<a href="${pageContext.request.contextPath}/frontIndexAction_index.action" class="a_14_666" title="������ҳ">��ҳ</a>&nbsp;-&gt;&nbsp;��Ա����&nbsp;-&gt;&nbsp;
											<a href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_points.action" class="a_14_666" title="�ҵĻ���">�ҵĻ���</a>
										</li>
										<li>
											<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" title="���ظ���������ҳ"><img
													src="${pageContext.request.contextPath}/images/uc_body_title_line.jpg"
													width="760" height="4" border="0" /> </a>
										</li>
									</ul>
								</div>
								<!--������� end-->
								<!--Content Start-->
								<table width="400" border="0" cellspacing="0" cellpadding="0"
									class="uc_info_tab">
									<tr>
										<td class="uc_info_tab_title" valign="middle">
											&nbsp;&nbsp;�ҵĻ���
										</td>
									</tr>
									<tr>
										<td class="uc_score_tab_content" valign="middle">


											<table width="200" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="30" align="left" valign="middle">
														<img
															src="${pageContext.request.contextPath}/images/score_ico.jpg"
															width="22" height="31" border="0" />
													</td>
													<td align="left" valign="middle" class="text_14b_666">
														�����ڵĻ��֣�${points }
													</td>
												</tr>
												<tr>
													<td></td>
													<td>
														<img
															src="${pageContext.request.contextPath}/images/back_button.jpg"
															width="80" height="40" border="0" />
													</td>
												</tr>
											</table>

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
					Copyright 2010 ������ WWW.ZHINANGTUAN.NET.CN all rights reserved
					��Ȩ����&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.mldnjava.cn" class="a_12_blue"
						title="ħ�ֿƼ����ѧԺ-Java��ѵ">ħ�ֿƼ����ѧԺ</a>
				</td>
			</tr>
		</table>
	</body>
</html>
