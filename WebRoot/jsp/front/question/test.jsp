<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>智慧云项目</title>
<script type="text/javascript">
       var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/question_list.js"></script>
</head>
<body>
	<center>
		<h1>已解决问题:</h1>
		<jsp:include page="question_split.jsp">
			<jsp:param value="4" name="currentPage" />
			<jsp:param value="10" name="lineSize" />
			<jsp:param value="132" name="allRecorders" />
			<jsp:param value="a" name="tableName" />
		</jsp:include>
		<h1>未解决问题:</h1>
		<jsp:include page="question_split.jsp">
		    <jsp:param value="1"  name="tid"/>
			<jsp:param value="6" name="currentPage" />
			<jsp:param value="100" name="lineSize" />
			<jsp:param value="1900" name="allRecorders" />
			<jsp:param value="b" name="tableName" />
		</jsp:include>
		<h1>零回答问题:</h1>
		<jsp:include page="question_split.jsp">
		    <jsp:param value="1"  name="tid"/>
			<jsp:param value="7" name="currentPage" />
			<jsp:param value="10" name="lineSize" />
			<jsp:param value="132" name="allRecorders" />
			<jsp:param value="c" name="tableName" />
		</jsp:include>
		<h1>高悬赏问题:</h1>
		<jsp:include page="question_split.jsp">
			<jsp:param value="19" name="currentPage" />
			<jsp:param value="110" name="lineSize" />
			<jsp:param value="1"  name="tid"/>
			<jsp:param value="180023" name="allRecorders" />
			<jsp:param value="d" name="tableName" />
		</jsp:include>
	</center>
</body>
</html>
