<%@ page pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<script type="text/javascript">
     function show(thisurl){
         window.open(thisurl,"��ʾ����","width=600,height=600,scrollbars=yes,resizable=no");
     }
     function deleteConfirm(){
	   return window.confirm("ȷ��ɾ����?");
	}
</script>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/userStyle.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
	    <h1>�ش��б�</h1>
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
		<table width="760" border="0" cellspacing="0" cellpadding="0"
			class="question_list_content_tab">
			<!--ѭ��tr��� start-->
			<s:if test="#request.allAnswers">
				<s:iterator value="#request.allAnswers" id="answer">
					<tr>
					    <td align="left" class="text_14_666" width="610">
					         ${answer.content }
					    </td>
					    <td align="left" class="text_14_666" width="610">
					         ${answer.user.userid }
					    </td>
						<td align="left" class="text_14_666" width="610">
						  <a href="#" onclick="show('${pageContext.request.contextPath }/jsp/back/backQuestionAction_show.action?question.qid=${answer.question.qid}')"
							class="a_14_blue" title="�鿴��������">�鿴��������</a>&nbsp;</td>
						<td align="right" class="text_14_999" width="150">
							<a href="${pageContext.request.contextPath }/jsp/back/backAnswerAction_delete.action?answer.aid=${answer.aid}"
								onclick="deleteConfirm()" class="text_14_999">ɾ��</a>
						</td>
					</tr>
				</s:iterator>
			</s:if>
		</table>
		<!--ȫ�������� end-->
	</center>
</body>
</html>

