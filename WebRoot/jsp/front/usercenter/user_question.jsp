<%@ page pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>������2.0-��Ա����-�ҵ�����</title>
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
						<td width="230" align="left" valign="top"><jsp:include
								page="user_menu.jsp" /></td>
						<td width="10"></td>
						<td width="760" align="left" valign="top">
							<!--������� start-->
							<div class="uc_body_title">
								<ul>
									<li><a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="������ҳ">��ҳ</a>&nbsp;-&gt;&nbsp;��Ա����&nbsp;-&gt;&nbsp;
										<a href="#" class="a_14_666" title="�ҵ�����">�ҵ�����</a></li>
									<li><img src="${pageContext.request.contextPath }/images/uc_body_title_line.jpg" width="760"
										height="4" border="0" /></li>
								</ul>
							</div> 
							<!--������� end--> 
							<!--ȫ�������� start-->
							<table width="760" border="0" cellspacing="0" cellpadding="0"
								class="question_list_content_tab">
								<!--ѭ��tr��� start-->
								<s:if test="#request.allQuestions">
									<s:iterator value="#request.allQuestions" id="questions">
										<tr>
											<td align="left" class="text_14_666" width="610">
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}"
												class="a_14_blue" title="�鿴��������">${questions.title }</a>&nbsp;
												<span>[${questions.status==0?"�ѽ��":"δ���" }]</span></td>
											<td align="right" class="text_14_999" width="150">${questions.count }
												�ش�[<a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_deleteQuestion.action?question.qid=${questions.qid}" class="text_14_999">ɾ��</a>]
											</td> 
										</tr>
									</s:iterator>
								</s:if>
								<!--ѭ��tr��� end-->
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
							</table> <!--ȫ�������� end-->
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

