<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>智囊团2.0-会员中心-我的回答</title>
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
					<jsp:include page="/head_logo.jsp" />
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
											<a href="#" class="a_14_666" title="我的回答">我的回答</a>
										</li>
										<li>
											<img
												src="${pageContext.request.contextPath}/images/uc_body_title_line.jpg"
												width="760" height="4" border="0" />
										</li>
									</ul>
								</div>
								<!--主体标题 end-->

								<!--全部问题表格 start-->
								<table width="760" border="0" cellspacing="0" cellpadding="0"
									class="question_list_content_tab">
									<!--循环tr标记 start-->
									<tr>
										<td align="left" class="text_14_666" width="700">
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${currentType.tid}" class="a_14_blue" title="查看该类问题">[${currentType.title }]</a>&nbsp;问题标问题标题
											<span>[已解决]</span>
										</td>
										<td align="right" class="text_14_999" width="60">
											10 回答
										</td>
									</tr>
									<!--循环tr标记 end-->
									<tr>
										<td colspan="2" style="border: none;" class="split_page_td">
											<!--翻页 Start-->
											<input type="button" value="首页" onclick=
	gosp(1);
disabled
												class="pageButton" />
											<input type="button" value="上一页" onclick=
	gosp(0);
disabled
												class="pageButton" />
											<input type="button" value="下一页" onclick=
	gosp(2);
disabled
												class="pageButton" />
											<input type="button" value="尾页" onclick=
	gosp(1);
disabled
												class="pageButton" />

											跳转到第
											<select name="selcp" onchange="gosp(this.value)">

												<option value="1" SELECTED>
													1
												</option>

											</select>
											页 每页显示
											<select name="ls" onchange="gosp(1)">

												<option value="1">
													1
												</option>

												<option value="3">
													3
												</option>

												<option value="5" SELECTED>
													5
												</option>

												<option value="10">
													10
												</option>

												<option value="15">
													15
												</option>

												<option value="20">
													20
												</option>

												<option value="30">
													30
												</option>

												<option value="50">
													50
												</option>

												<option value="100">
													100
												</option>

												<option value="150">
													150
												</option>

												<option value="200">
													200
												</option>

											</select>
											条记录


											<input type="hidden" name="cp" value="">
												<input type="hidden" name="deptno" value="null">
													<input type="hidden" name="status" value="">
														<!--翻页 end-->
										</td>
									</tr>
								</table>
								<!--全部问题表格 end-->
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
