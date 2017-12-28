<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智囊团2.0-问题列表</title>
<script language="javascript" src="${pageContext.request.contextPath }/js/PNG_IMG.js" type="text/javascript"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/js/tag.js"
	type="text/javascript"></script>
<script type="text/javascript">
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
				<jsp:include page="/head_logo.jsp" />
				adsfasdf${actionUrl }
				<!--logo and navigation end-->
			</td>
		</tr>
		<tr>
			<td align="center" valign="middle" class="top_search">
				<!--top search start--> <jsp:include page="/head_form.jsp" /> <!--top search end-->
			</td>
		</tr>
		<tr>
			<td class="container">

				<table width="760" border="0" cellspacing="0" cellpadding="0"
					class="question_list_content_tab">
					<!--循环tr标记 start-->
					<s:if test="#request.allQuestions">
						<s:iterator value="#request.allQuestions" id="questions">
							<tr>
								<td align="left" class="text_14_666" width="610">
								  <a href="#" onclick="show('${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show.action?question.qid=${qid}')"
									class="a_14_blue" title="查看该类问题">${questions.title }</a>&nbsp;
									<span>[${questions.status==0?"已解决":"未解决" }]</span></td>
								<td align="right" class="text_14_999" width="150">
									${questions.user.userid }</td>
								<td align="right" class="text_14_999" width="150">
									${questions.count }回答 
								</td>
							</tr>
						</s:iterator>
					</s:if>
				</table> 
				<!--全部问题表格 end--> 
				<jsp:include page="/split_page.jsp">
					<jsp:param name="currentPage" value="${currentPage }" />
					<jsp:param name="lineSize" value="${lineSize }" />
					<jsp:param name="allRecorders" value="${allRecorders }" />
					<jsp:param name="actionUrl" value="${actionUrl }" />
					<jsp:param name="column" value="${column }" />
					<jsp:param name="columnName" value="${columnName }" />
					<jsp:param name="defaultColumnName" value="${defaultColumnName }" />
					<jsp:param name="keyWord" value="${keyWord }" />
					<jsp:param name="searchFlag" value="FALSE" />
				</jsp:include>
			</td>
		</tr>

	</table>
</body>
</html>

