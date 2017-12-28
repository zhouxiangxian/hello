<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
