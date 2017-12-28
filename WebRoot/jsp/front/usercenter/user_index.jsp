<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>智囊团2.0-会员中心-首页</title>
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
							<td width="760" align="left" valign="top"
								class="uc_index_content">
								<!--主体标题 start-->
								<div class="uc_body_title">
									<ul>
										<li>
											<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="返回首页">首页</a>&nbsp;-&gt;&nbsp;会员中心&nbsp;-&gt;&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" class="a_14_666" title="会员中心首页">会员中心首页</a>
										</li>
										<li>
											<img src="${pageContext.request.contextPath }/images/uc_body_title_line.jpg" width="760"
												height="4" border="0" />
										</li>
									</ul>

								</div>
								<!--主体标题 end-->


								<!--Content Start-->
								<div class="uc_index_content_box">
									提问问题：${allQuestionCount }
									<br />
									解决问题：${questionCountStatus0 }
									<br />
									积&nbsp;&nbsp;&nbsp;&nbsp;分：${userPoints }
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
					Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN all rights reserved
					版权所有&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue"
						title="长沙学院">长沙学院</a>
				</td>
			</tr>
		</table>
	</body>
</html>
