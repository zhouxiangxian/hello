<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>������2.0-��Ա����-��ҳ</title>
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
							<td width="760" align="left" valign="top"
								class="uc_index_content">
								<!--������� start-->
								<div class="uc_body_title">
									<ul>
										<li>
											<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="������ҳ">��ҳ</a>&nbsp;-&gt;&nbsp;��Ա����&nbsp;-&gt;&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" class="a_14_666" title="��Ա������ҳ">��Ա������ҳ</a>
										</li>
										<li>
											<img src="${pageContext.request.contextPath }/images/uc_body_title_line.jpg" width="760"
												height="4" border="0" />
										</li>
									</ul>

								</div>
								<!--������� end-->


								<!--Content Start-->
								<div class="uc_index_content_box">
									�������⣺${allQuestionCount }
									<br />
									������⣺${questionCountStatus0 }
									<br />
									��&nbsp;&nbsp;&nbsp;&nbsp;�֣�${userPoints }
								</div>

								<!--Content End-->
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
					<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue"
						title="��ɳѧԺ">��ɳѧԺ</a>
				</td>
			</tr>
		</table>
	</body>
</html>
