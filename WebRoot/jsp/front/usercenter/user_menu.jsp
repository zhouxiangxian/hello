<%@ page pageEncoding="GBK"%>
<table width="230" border="0" cellspacing="0" cellpadding="0"
	class="uc_left_nav">
	<tr>
		<td class="uc_left_nav_title" valign="middle">
			&nbsp;&nbsp;��Ա����
		</td>
	</tr>
	<tr>
		<td class="uc_left_nav_content" valign="top">
			<table width="160" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="15" align="left" style="border: none;">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td class="text_14b_666" style="border: none;">
						<a
							href="#"
							class="text_14b_666">�ҵ�����</a>
					</td>
				</tr>
				<tr class="uc_left_nav_link01">
					<td width="15" align="left" valign="top">
						&nbsp;
					</td>
					<td valign="top">
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_listUserQuestionStatus.action?status=0"
							class="a_12_666">�ѽ������</a>
						<br />
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_listUserQuestionStatus.action?status=1"
							class="a_12_666">δ�������</a>
						<br />
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_listZeroAnswerQuestion.action?status=1"
							class="a_12_666">��ش�����</a>
					</td>
				</tr>
				<tr>
					<td width="15" align="left" style="border: none;">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td style="border: none;">
						<a
							href="#"
							class="text_14b_666">�ҵĻش�</a>
					</td>
				</tr>
				<tr class="uc_left_nav_link01">
					<td width="15" align="left" valign="top">
						&nbsp;
					</td>
					<td valign="top">
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_listAcceptAnswer.action?status=0"
							class="a_12_666">���ɵ�����</a>
						<br />
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_listUserAnswer.action?status=0"
							class="a_12_666">δ��������</a>
					</td>
				</tr>
				<tr>
					<td width="15" align="left">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td>
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_points.action"
							class="a_14b_666">�ҵĻ���</a>
					</td>
				</tr>
				<tr>
					<td width="15" align="left">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td>
						<a
							href="${pageContext.request.contextPath}/jsp/front/frontUserCenterAction_updatePre.action"
							class="a_14b_666">��������</a>
					</td>
				</tr>
				<tr>
					<td width="15" align="left">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td>
						<a
							href="${pageContext.request.contextPath}/jsp/front/usercenter/user_changepassword.jsp"
							class="a_14b_666">�޸�����</a>
					</td>
				</tr>
				<tr>
					<td width="15" align="left">
						<img
							src="${pageContext.request.contextPath}/images/user_center_left_nav_text_ico.gif"
							width="9" height="9" border="0" />
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/frontUserAction_logout.action"
							class="a_14b_666">�˳���¼</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>