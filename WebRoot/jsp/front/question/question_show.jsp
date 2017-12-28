<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>������2.0-�����б�</title>
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
			<td>
				<!--logo and navigation start-->
				<jsp:include page="/head_logo.jsp"/>
				<!--logo and navigation end-->
			</td>
		</tr>
		<tr>
			<td align="center" valign="middle" class="top_search">
				<!--top search start-->
				<jsp:include page="/head_form.jsp"/>
				<!--top search end-->
			</td>
		</tr>
		<tr>
			<td class="container">
				<!--content start-->
				<table width="1000" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="690" valign="top">
							<div class="page_content_body_link">
								<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_blue" title="��������ҳ">��ҳ</a>-&gt; <a
									href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${tid}" class="a_14_blue" title="�����б�ҳ">${question.type.title }</a>
							</div> <!--����������ʼ-->
							<div class="question_tab01">
								<div class="table">
									<table width="670" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="text_14b_333">������⣺<span class="text_14_333">${question.title }</span><span
												class="text_14_orange"></span></td>
										</tr>
										<tr>
											<td class="question_content_tab_container">
											${question.content}
											</td>
										</tr>
										<tr>
											<td align="right"><a href="#"><img
													src="${pageContext.request.contextPath }/images/question_content_button01.gif"
													width="110" height="40" border="0" /></a></td>
										</tr>

									</table>
								</div>
								<div class="bottom_img">
									<img
										src="${pageContext.request.contextPath }/images/question_content_tab01_bottom.gif"
										width="690" height="5" border="0" />
								</div>
							</div> <!--������������-->
							<div class="clear"></div> 
							<!--��Ѵ𰸿�ʼ-->
							<s:if test="#request.question.answer!=null">
							<div class="question_tab02">
								<div class="table">
									<table width="670" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="text_14b_orange">��Ѵ�</td>
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
							<!--��Ѵ𰸽���-->
							<div class="clear"></div> 
							<!--�ش����⿪ʼ-->
							<s:if test="#request.question.answer==null">
							<div class="question_tab03">
								<div class="table">
									<form action="frontAnswerAction_insert.action" method="post">
										<table width="670" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="text_14b_333">�ش�����</td>
											</tr>
											<tr>
												<td class="question_content_tab_container" align="center">
													<textarea id="answer.content" name="answer.content"></textarea>
												</td>
											</tr>
											<tr>
												<td align="right">
												  <input type="hidden" name="answer.user.userid" value="${userid }">
												  <input type="hidden" name="answer.question.qid" value="${question.qid }">
												  <input type="image" src="${pageContext.request.contextPath }/images/question_content_button02.gif"
													width="110" height="40" border="0" />
												</td>
											</tr>

										</table>
									</form>
								</div>
								<div class="bottom_img">
									<img
										src="${pageContext.request.contextPath }/images/question_content_tab03_bottom.gif"
										width="690" height="5" border="0" />
								</div>
							</div>
							</s:if> 
							<!--�ش��������-->
							<div class="clear"></div> 
							<!--�����ش�ʼ-->
							<s:if test="#request.question.answers!=null">
							<div class="question_tab04">
								<div class="table">
									<form>
										<table width="670" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="text_14b_333">�����ش�</td>
											</tr>
											<tr>
												<td class="question_content_tab_container" align="left">
													<!--ѭ��ul��ǿ�ʼ-->
													<s:iterator value="#request.question.answers" var="tempans">
													<ul class="other_answer">
													    <li class="other_answer_content">
														   ${tempans.content }
														</li>
														<li class="other_answer_info">${tempans.user.userid }&nbsp;&nbsp;&nbsp;&nbsp;${tempans.retdate }
														<s:if test="#request.question.answer==null">
														<s:if test="#request.question.user.userid==#session.userid">
														  ��<a class="a_12_blue" href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_setNice.action?question.qid=${question.qid}&question.answer.aid=${tempans.aid}&question.answer.user.userid=${tempans.user.userid}&question.user.userid=${question.user.userid}&question.points=${question.points}">����Ϊ��Ѵ�</a>��
														</s:if>
														</s:if>
														</li>
													</ul>
													</s:iterator>
													<!--ѭ��ul��ǽ���-->
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
									<td><div class="index_right_tab_content">
											<!--������ר�� start-->
						                    <table width="288" border="0" cellspacing="0" cellpadding="0">
							                      <tr>
							                        <td class="right_experts_title" colspan="2">������ר��</td>
							                      </tr>
							                      <tr>
							                      <td height="5" colspan="2"></td>
							                      </tr>
							                      <tr>
								                        <td width="140" align="left" valign="top"><img src="${pageContext.request.contextPath }/images/cat.jpg" width="130" height="100" border="0" /></td>
								                        <td  width="148" align="left" valign="top" class="right_experts_content"><span class="text_14b_black">С�ײ�</span><br />
													                          С�׿Ƽ���ѧ�ܼ�<br />
													                          С����ͨϵͳ�ܹ�ʦ<br />
													                          С���������ܼ�<br />
													         ���� 
													    </td>
							                      </tr>
							                      <tr>
							                        <td colspan="2" class="right_experts_text">    �ḻ��JAVA/JAVAEE��ƺͿ��������Լ�������ѵ����....</td>
							                      </tr>
						                    </table>
                   							 <!--������ר�� end-->
											<!--�û����� start-->
											<jsp:include page="/head_user.jsp"/>
											<!--�û����� end-->
										</div></td>
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
