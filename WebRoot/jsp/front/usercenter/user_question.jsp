<%@ page pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>智囊团2.0-会员中心-我的提问</title>
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
						<td width="230" align="left" valign="top"><jsp:include
								page="user_menu.jsp" /></td>
						<td width="10"></td>
						<td width="760" align="left" valign="top">
							<!--主体标题 start-->
							<div class="uc_body_title">
								<ul>
									<li><a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="返回首页">首页</a>&nbsp;-&gt;&nbsp;会员中心&nbsp;-&gt;&nbsp;
										<a href="#" class="a_14_666" title="我的提问">我的提问</a></li>
									<li><img src="${pageContext.request.contextPath }/images/uc_body_title_line.jpg" width="760"
										height="4" border="0" /></li>
								</ul>
							</div> 
							<!--主体标题 end--> 
							<!--全部问题表格 start-->
							<table width="760" border="0" cellspacing="0" cellpadding="0"
								class="question_list_content_tab">
								<!--循环tr标记 start-->
								<s:if test="#request.allQuestions">
									<s:iterator value="#request.allQuestions" id="questions">
										<tr>
											<td align="left" class="text_14_666" width="610">
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}"
												class="a_14_blue" title="查看该类问题">${questions.title }</a>&nbsp;
												<span>[${questions.status==0?"已解决":"未解决" }]</span></td>
											<td align="right" class="text_14_999" width="150">${questions.count }
												回答[<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_deleteQuestion.action?question.qid=${questions.qid}" class="text_14_999">删除</a>]
											</td> 
										</tr>
									</s:iterator>
								</s:if>
								<!--循环tr标记 end-->
								<tr>
									<jsp:include page="/split_page.jsp" >
									   <jsp:param name="currentPage" value="${currentPage }" />
									   <jsp:param name="lineSize" value="${lineSize }" />
									   <jsp:param name="allRecorders" value="${allRecorders }" />
									   <jsp:param name="actionUrl" value="${actionUrl }" />
									   <jsp:param name="column" value="${column }" />
									   <jsp:param name="columnName" value="${columnName }" />
									   <jsp:param name="defaultColumnName" value="${defaultColumnName }" />
									   <jsp:param name="keyWord" value="${keyWord }" />
									   <jsp:param name="searchFlag" value="FALSE"/>
									</jsp:include>
								</tr>
							</table> <!--全部问题表格 end-->
						</td>
					</tr>
				</table> <!--contnet end-->
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

