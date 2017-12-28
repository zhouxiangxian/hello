<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_search.action" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="480" align="right">
     <input class="top_search_input" type="text" name="keyWord" id="keyWord" value="" />
     <input class="top_search_input" type="hidden" name="column" id="column" value="title" />
    </td>
    <td width="120" align="right"><input type="image" src="${pageContext.request.contextPath }/images/top_search_button01.png" width="110" height="35" border="0" /></td>
    <td width="80" align="right"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_insertPre.action"><img src="${pageContext.request.contextPath }/images/top_search_button02.png" width="70" height="35" border="0" /></a></td>
    <td width="80" align="right"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action"><img src="${pageContext.request.contextPath }/images/top_search_button03.png" width="70" height="35" border="0" /></a></td>
    <td width="240" valign="middle" align="center" class="top_search_info">已解决：${questionCountStatus0 }个问题<br />
              待解决：${questionCountStatus1}个问题</td>
  </tr>
</table>
</form>