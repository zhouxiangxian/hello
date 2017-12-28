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
	在日后调用的时候，按照以上的方式传送参数就可以进行分页控制端的导入了。
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
	// 设置编码
	request.setCharacterEncoding("GBK");
%>
<%
	String actionUrl = null; // 当前提交的路径
	int currentPage = 1; // 表示当前所在的页，默认是第一页
	int lineSize = 5; // 每页显示的行数
	int allRecorders = 0; // 全部数据量
	int pageSize = 0; // 总页数
	int[] lineSizeData = new int[]{1, 3, 5, 10, 15, 20, 30, 50, 100,
			150, 200};
	String columnName = null;
	String defaultColumnName = null;
	String column = null;
	String keyWord = null;
	String searchFlag = "FALSE"; // 检索标记
%>
<%
	try {
		currentPage = Integer.parseInt(request
				.getParameter("currentPage")); // 接收参数
	} catch (Exception e) {
	} // 这个异常没有必要再输出
	try {
		lineSize = Integer.parseInt(request.getParameter("lineSize")); // 接收参数
	} catch (Exception e) {
	} // 这个异常没有必要再输出
	try {
		allRecorders = Integer.parseInt(request
				.getParameter("allRecorders")); // 接收参数
	} catch (Exception e) {
	} // 这个异常没有必要再输出
	column = request.getParameter("column"); // 接收表单传送的数据
	keyWord = request.getParameter("keyWord");
	searchFlag = request.getParameter("searchFlag");
	actionUrl = request.getParameter("actionUrl");
	columnName = request.getParameter("columnName");
	defaultColumnName = request.getParameter("defaultColumnName");
	if (column == null || "".equals(column)) {
		column = defaultColumnName; // 给一个默认情况下的检索字段
	}
	if (columnName == null) {
		columnName = "";
	}
	if (keyWord == null) {
		keyWord = ""; // 查询全部
	}
%>
<%
	// 计算总页数
	pageSize = (allRecorders + lineSize - 1) / lineSize;
	if (pageSize == 0) {
		pageSize = 1; // 保证只有一页
	}
%>
<script language="javascript">
	function gosplit(cp){
		// 改变表单中cp参数的内容
		document.getElementById("currentPage").value = cp ;
		document.getElementById("spform").submit() ;	// 提交表单
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
									String result[] = columnName.split("\\|"); // 拆分
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
		<input type="button" value="首页" onclick="gosplit(1)"
			<%=currentPage == 1 ? "disabled" : ""%> class="pageButton">
		<input type="button" value="上一页" onclick="gosplit(<%=currentPage - 1%>)"
			<%=currentPage == 1 ? "disabled" : ""%> class="pageButton">
		<input type="button" value="下一页" onclick="gosplit(<%=currentPage + 1%>)"
			<%=currentPage == pageSize ? "disabled" : ""%> class="pageButton">
		<input type="button" value="尾页" onclick="gosplit(<%=pageSize%>)"
			<%=currentPage == pageSize ? "disabled" : ""%> class="pageButton">
		跳转到第
		<select name="selcp" onchange="gosplit(this.value)">
			<%
				for (int x = 1; x <= pageSize; x++) {
			%>
			<option value="<%=x%>" <%=currentPage == x ? "SELECTED" : ""%>><%=x%></option>
			<%
				}
			%>
		</select>
		页 每页显示
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
		条记录
		<input type="hidden" name="currentPage" id="currentPage" value="">
		<input type="hidden" name="status" id="status" value="${status}">
		<input type="hidden" name="user.userid" id="user.userid" value="${userid }">
	</form>
</div>