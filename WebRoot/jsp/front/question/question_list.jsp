<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智囊团2.0-问题列表</title>
<script type="text/javascript">
	var path = "${pageContext.request.contextPath}";
	var type = "${currentType.title }";
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/question_list.js"
	charset="UTF-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/PNG_IMG.js"
	type="text/javascript"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/tag.js"
	type="text/javascript"></script>
<script type="text/javascript">
      var path=${pageContext.request.contextPath };
      function show(thisurl){
          window.open(thisurl,"显示问题","width=500,height=500,scrollbars=yes,resizable=no");
      }
</script>
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
								<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_blue" title="智囊团首页">首页</a>-&gt; <a
									href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${tid}" class="a_14_blue" title="问题列表页">${currentType.title }</a>
							</div> 
							<!--顶部问题分类 start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="question_list_left_top_tab_title" height="31"
										valign="middle">&nbsp;&nbsp;${currentType.title}</td>
								</tr>
								<tr>
									<td>
										<div class="qusetion_list_left_top_tab_content">
											<ul>
												<!--loop li tag start-->
												<s:iterator value="#request.allType">
													<li >&middot;<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${tid}" class="a_14_blue">${title }</a></li>
												</s:iterator>
												<!--loop li tag end-->
												<div class="clear"></div>
											</ul>
										</div>
									</td>
								</tr>
								<tr>
									<td><img
										src="${pageContext.request.contextPath }/images/question_list_left_tab_bottom.jpg"
										width="690" height="10" border="0" /></td>
								</tr>
							</table> 
							<!--顶问题分类 end--> 
							<!--问题标签start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0"
								class="question_list_tag">
								<tr>
									<td class="e101" valign="middle" id="el01"
										onMouseOver="esecBoard(1);">待解决问题</td>
									<td width="2"></td>
									<td class="e102" id="el02" valign="middle"
										onMouseOver="esecBoard(2);">已解决</td>
									<td width="2"></td>
									<td class="e102" id="el03" valign="middle"
										onMouseOver="esecBoard(3);">零回答</td>
									<td width="2"></td>
									<td class="e102" id="el04" valign="middle"
										onMouseOver="esecBoard(4);">高悬赏</td>
									<td width="204"></td>
								</tr>
							</table> 
							<!--问题标签 end--> 
							<!--待解决问题表格 start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0"
								id="ebx01" class="question_list_content_tab">
								<!--循环tr标记 start-->
								<s:iterator value="#request.allQuestionStatus1">
									<tr>
										<td align="left" class="text_14_666">
										  <a href="" class="a_14_blue" title="查看该类问题">[${currentType.title }]</a>
										  &nbsp;<a  href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}" class="a_14_blue">${title }</a><span>[${status==1?"未解决":"已解决" }]</span>
										</td>
										<td align="right" class="text_14_999">${count==null?0:count }
											回答</td>
									</tr>
								</s:iterator>
								<!--循环tr标记 end-->
								<tr>
									<td colspan="2" style="border:none;">
										<!--翻页 Start--> 
										<jsp:include page="question_split.jsp">
											<jsp:param value="1" name="currentPage" />
											<jsp:param value="${currentType.tid }" name="tid" />
											<jsp:param value="5" name="lineSize" />
											<jsp:param value="${allQuestionCountStatus1 }"
												name="allRecorders" />
											<jsp:param value="ebx01" name="tableName" />
										</jsp:include> <!--翻页 end-->
									</td>
								</tr>
							</table> <!--待解决问题表格 end--> <!--已解决问题表格 start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0"
								id="ebx02" style="display:none;"
								class="question_list_content_tab">
								<!--循环tr标记 start-->
								<s:iterator value="#request.allQuestionStatus0">
									<tr>
										<td align="left" class="text_14_666"><a
											href="QuestionList.htm" class="a_14_blue" title="查看该类问题">[${currentType.title }]</a>&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}" class="a_14_666">${title }</a><span>[${status==1?"未解决":"已解决" }]</span></td>
										<td align="right" class="text_14_999">${count==null?0:count }
											回答</td>
									</tr>
								</s:iterator>
								<!--循环tr标记 end-->
								<tr>
									<td colspan="2" style="border:none;">
										<!--翻页 Start--> <jsp:include page="question_split.jsp">
											<jsp:param value="1" name="currentPage" />
											<jsp:param value="5" name="lineSize" />
											<jsp:param value="${allQuestionCountStatus0 }"
												name="allRecorders" />
											<jsp:param value="ebx02" name="tableName" />
										</jsp:include> <!--翻页 end-->
									</td>
								</tr>
							</table> <!--已解决问题表格 end--> <!--零回答表格 start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0"
								id="ebx03" style="display:none;"
								class="question_list_content_tab">
								<!--循环tr标记 start-->
								<s:iterator value="#request.allQuestionCountZero">
									<tr>
										<td align="left" class="text_14_666"><a
											href="QuestionList.htm" class="a_14_blue" title="查看该类问题">[${currentType.title }]</a>&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}" class="a_14_666">${title }</a><span>[${status==1?"未解决":"已解决" }]</span></td>
										<td align="right" class="text_14_999">${count==null?0:count }
											回答</td>
									</tr>
								</s:iterator>
								<!--循环tr标记 end-->
								<tr>
									<td colspan="2" style="border:none;">
										<!--翻页 Start--> 
										<jsp:include page="question_split.jsp">
											<jsp:param value="1" name="currentPage" />
											<jsp:param value="5" name="lineSize" />
											<jsp:param value="${allQuestionCountCountZero }"
												name="allRecorders" />
											<jsp:param value="ebx03" name="tableName" />
										</jsp:include> <!--翻页 end-->
									</td>
								</tr>
							</table> <!--零回答表格 end--> <!--高悬赏表格 start-->
							<table width="690" border="0" cellspacing="0" cellpadding="0"
								id="ebx04" style="display:none;"
								class="question_list_content_tab">
								<!--循环tr标记 start-->
								<s:iterator value="#request.allQuestionPoints">
									<tr>
										<td align="left" class="text_14_666"><a
											href="QuestionList.htm" class="a_14_blue" title="查看该类问题">[${currentType.title }]</a>&nbsp;
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show.action?question.qid=${qid}" class="a_14_666">${title }</a><span>[${status==1?"未解决":"已解决" }]</span></td>
										<td align="right" class="text_14_999">${count==null?0:count }
											回答</td>
									</tr>
								</s:iterator>
								<!--循环tr标记 end-->
								<tr>
									<td colspan="2" style="border:none;">
										<!--翻页 Start--> <jsp:include page="question_split.jsp">
											<jsp:param value="1" name="currentPage" />
											<jsp:param value="5" name="lineSize" />
											<jsp:param value="${allQuestionCountPoints }"
												name="allRecorders" />
											<jsp:param value="ebx04" name="tableName" />
										</jsp:include> 
										<!--翻页 end-->
									</td>
								</tr>
							</table> <!--高悬赏表格 end-->


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
											<!--智囊团专家 start-->
                    <table width="288" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="right_experts_title" colspan="2">智囊团专家</td>
                      </tr>
                      <tr>
                      <td height="5" colspan="2"></td>
                      </tr>
                      <tr>
                        <td width="140" align="left" valign="top"><img src="${pageContext.request.contextPath }/images/cat.jpg" width="130" height="100" border="0" /></td>
                        <td  width="148" align="left" valign="top" class="right_experts_content"><span class="text_14b_black">小白菜</span><br />
                          小白科技教学总监<br />
                          小白软通系统架构师<br />
                          小白网技术总监<br />
                          …… </td>
                      </tr>
                      <tr>
                        <td colspan="2" class="right_experts_text">    丰富的JAVA/JAVAEE设计和开发经验以及多年培训经验....</td>
                      </tr>
                    </table>
                    <!--智囊团专家 end-->
                    <!--用户排行 start-->
                    <table width="288" border="0" cellspacing="0" cellpadding="0" class="index_right_user_list">
						  <tr>
						    <td colspan="3" class="index_right_user_title">用户排行</td>
						  </tr>
						  <!--loop tr tag start-->
						  <s:if test="#application.allUsers!=null">
						  <s:iterator value="#application.allUsers">
						  <tr>
						    <td align="left" width="188" class="text_14_black">${userid }</td>
						    <td align="right" width="80" class="text_12_666">${points }分</td>
						  </tr>
						  </s:iterator>
						  </s:if>
						  <!--loop tr tag end-->
					</table>

                    <!--用户排行 end-->
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
				Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN all rights reserved
				版权所有&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue"
					title="长沙学院">长沙学院</a>
			</td>
        </tr>
	</table>
</body>
</html>

