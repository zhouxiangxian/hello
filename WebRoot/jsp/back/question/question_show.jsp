<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智囊团2.0-问题列表</title>

<script language="javascript"
	src="${pageContext.request.contextPath }/js/PNG_IMG.js"
	type="text/javascript"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/tag.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<table width="1000" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr>
			<td class="container">
				<!--content start-->
				<table width="1000" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="690" valign="top">
							<div class="page_content_body_link">
								<a href="index.htm" class="a_14_666" title="智囊团首页">首页</a>-&gt; <a
									href="#" class="a_14_666" title="问题列表页">${question.type.title }</a>
							</div> <!--问题容器开始-->
							<div class="question_tab01">
								<div class="table">
									<table width="670" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="text_14b_333">问题标题：<span class="text_14_333">${question.title }</span><span
												class="text_14_orange"></span></td>
										</tr>
										<tr>
											<td class="question_content_tab_container">
											${question.content}
											</td>
										</tr>
										<tr>
										</tr>

									</table>
								</div>
								<div class="bottom_img">
									<img
										src="${pageContext.request.contextPath }/images/question_content_tab01_bottom.gif"
										width="690" height="5" border="0" />
								</div>
							</div> <!--问题容器结束-->
							<div class="clear"></div> 
							<!--最佳答案开始-->
							<s:if test="#request.question.answer!=null">
							<div class="question_tab02">
								<div class="table">
									<table width="670" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="text_14b_orange">最佳答案</td>
										</tr>
										<tr>
											<td class="question_content_tab_container">
											   <ul class="other_answer">
														<li class="other_answer_content">
														    ${question.answer.content }
														</li>
														<li class="other_answer_info" align="right">${question.answer.user.userid }&nbsp;&nbsp;&nbsp;&nbsp;${question.answer.retdate }
														</li>
													</ul>
											</td>
										</tr>


									</table>
								</div>
								<div class="bottom_img">
									<img
										src="${pageContext.request.contextPath }/images/question_content_tab02_bottom.gif"
										width="690" height="5" border="0" />
								</div>
							</div>
							</s:if>
							<!--最佳答案结束-->
							<div class="clear"></div> 
							<!--其他回答开始-->
							<s:if test="#request.question.answers!=null">
							<div class="question_tab04">
								<div class="table">
									<form>
										<table width="670" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="text_14b_333">其他回答</td>
											</tr>
											<tr>
												<td class="question_content_tab_container" align="left">
													<!--循环ul标记开始-->
													<s:iterator value="#request.question.answers" var="tempans">
													<ul class="other_answer">
													    <li class="other_answer_content">
														   ${tempans.content }
														</li>
														<li class="other_answer_info">${tempans.user.userid }&nbsp;&nbsp;&nbsp;&nbsp;${tempans.retdate }
														<s:if test="#request.question.answer==null">
														<s:if test="#request.question.user.userid==#session.userid">
														  【<a class="a_12_blue" href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_setNice.action?question.qid=${question.qid}&question.answer.aid=${tempans.aid}&question.answer.user.userid=${tempans.user.userid}&question.user.userid=${question.user.userid}&question.points=${question.points}">设置为最佳答案</a>】
														</s:if>
														</s:if>
														</li>
													</ul>
													</s:iterator>
													<!--循环ul标记结束-->
												</td>
											</tr>
										</table>
									</form>
								</div>
								<div class="bottom_img">
									<img
										src="${pageContext.request.contextPath }/images/question_content_tab01_bottom.gif"
										width="690" height="5" border="0" />
								</div>
							</div>
                            </s:if>
						</td>
						<td width="10"></td>
						<td width="300" valign="top">

							<table width="300" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><img
										src="${pageContext.request.contextPath }/images/index_right_tab_top.gif"
										width="300" height="10" border="0" /></td>
								</tr>
								<tr>
									<td><img
										src="${pageContext.request.contextPath }/images/index_right_tab_bottom.gif"
										width="300" height="10" border="0" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table> <!--contnet end-->
			</td>
		</tr>
	</table>
</body>
</html>
