<%@ page language="java" pageEncoding="GBK"%>
<%--
<jsp:include page="/jsp/split_page.jsp">
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="actionUrl" value="<%=actionUrl%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="columnName" value="<%=columnName%>"/>
	<jsp:param name="defaultColumnName" value="<%=defaultColumnName%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
	<jsp:param name="searchFlag" value="TRUE"/>
</jsp:include>
	���պ���õ�ʱ�򣬰������ϵķ�ʽ���Ͳ����Ϳ��Խ��з�ҳ���ƶ˵ĵ����ˡ�
--%>
<style>
.pageStyle {
	font-size: 12px;
	color: #009ccf;
	fosnt-weight: normal;
}

.searchText {
	width: 400px;
	height: 30px;
	border: 1px #ccc solid;
	background: #f5f5f5;
	font-size: 14px;
	color: #ccc;
}

.pageButton {
	width: 60px;
	height: 25px;
	border: none;
	background: none;
	font-size: 12px;
	color: #009CCF;
	font-weight: normal;
	text-decoration: underline;
	cursor: pointer;
}
</style>
<%
	// ���ñ���
	request.setCharacterEncoding("GBK");
%>
<%
	String actionUrl = null; // ��ǰ�ύ��·��
	int currentPage = 1; // ��ʾ��ǰ���ڵ�ҳ��Ĭ���ǵ�һҳ
	int lineSize = 5; // ÿҳ��ʾ������
	int allRecorders = 0; // ȫ��������
	int pageSize = 0; // ��ҳ��
	int[] lineSizeData = new int[]{1, 3, 5, 10, 15, 20, 30, 50, 100,
			150, 200};
	String columnName = null;
	String defaultColumnName = null;
	String column = null;
	String keyWord = null;
	String searchFlag = "FALSE"; // �������
%>
<%
	try {
		currentPage = Integer.parseInt(request
				.getParameter("currentPage")); // ���ղ���
	} catch (Exception e) {
	} // ����쳣û�б�Ҫ�����
	try {
		lineSize = Integer.parseInt(request.getParameter("lineSize")); // ���ղ���
	} catch (Exception e) {
	} // ����쳣û�б�Ҫ�����
	try {
		allRecorders = Integer.parseInt(request
				.getParameter("allRecorders")); // ���ղ���
	} catch (Exception e) {
	} // ����쳣û�б�Ҫ�����
	column = request.getParameter("column"); // ���ձ����͵�����
	keyWord = request.getParameter("keyWord");
	searchFlag = request.getParameter("searchFlag");
	actionUrl = request.getParameter("actionUrl");
	columnName = request.getParameter("columnName");
	defaultColumnName = request.getParameter("defaultColumnName");
	if (column == null || "".equals(column)) {
		column = defaultColumnName; // ��һ��Ĭ������µļ����ֶ�
	}
	if (columnName == null) {
		columnName = "";
	}
	if (keyWord == null) {
		keyWord = ""; // ��ѯȫ��
	}
%>
<%
	// ������ҳ��
	pageSize = (allRecorders + lineSize - 1) / lineSize;
	if (pageSize == 0) {
		pageSize = 1; // ��ֻ֤��һҳ
	}
%>
<script language="javascript">
	function gosplit(cp){
		// �ı����cp����������
		document.getElementById("currentPage").value = cp ;
		document.getElementById("spform").submit() ;	// �ύ��
	}
</script>
<div class="pageStyle">
	<form name="spform" id="spform" method="post" action="<%=actionUrl%>">
		<%
			if ("TRUE".equals(searchFlag)) {
		%>
		<table width="470" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td>
					<select name="column">
						<%
							if (columnName.contains(":")) {
									String result[] = columnName.split("\\|"); // ���
									for (int x = 0; x < result.length; x++) {
										String temp[] = result[x].split(":");
						%>
						<option value="<%=temp[1]%>"
							<%=column.equals(temp[1]) ? "SELECTED" : ""%>><%=temp[0]%></option>
						<%
							}
								}
						%>
					</select>
				</td>
				<td width="400">
					<input type="text" name="keyWord" class="searchText"
						value="<%=keyWord%>" />
				</td>
				<td width="70" align="right">
					<input type="image"
						src="${pageContext.request.contextPath}/images/searchButton.gif"
						width="60" height="30" border="0" />
				</td>
			</tr>
		</table>
		<%
			}
		%>
		<input type="button" value="��ҳ" onclick="gosplit(1)"
			<%=currentPage == 1 ? "disabled" : ""%> class="pageButton">
		<input type="button" value="��һҳ" onclick="gosplit(<%=currentPage - 1%>)"
			<%=currentPage == 1 ? "disabled" : ""%> class="pageButton">
		<input type="button" value="��һҳ" onclick="gosplit(<%=currentPage + 1%>)"
			<%=currentPage == pageSize ? "disabled" : ""%> class="pageButton">
		<input type="button" value="βҳ" onclick="gosplit(<%=pageSize%>)"
			<%=currentPage == pageSize ? "disabled" : ""%> class="pageButton">
		��ת����
		<select name="selcp" onchange="gosplit(this.value)">
			<%
				for (int x = 1; x <= pageSize; x++) {
			%>
			<option value="<%=x%>" <%=currentPage == x ? "SELECTED" : ""%>><%=x%></option>
			<%
				}
			%>
		</select>
		ҳ ÿҳ��ʾ
		<select name="lineSize" onchange="gosplit(1)">
			<%
				for (int x = 0; x < lineSizeData.length; x++) {
			%>
			<option value="<%=lineSizeData[x]%>"
				<%=lineSize == lineSizeData[x] ? "SELECTED" : ""%>><%=lineSizeData[x]%></option>
			<%
				}
			%>
		</select>
		����¼
		<input type="hidden" name="currentPage" id="currentPage" value="">
		<input type="hidden" name="status" id="status" value="${status}">
		<input type="hidden" name="user.userid" id="user.userid" value="${userid }">
	</form>
</div>