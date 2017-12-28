<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table width="1000" border="0" cellspacing="0" cellpadding="0" class="top_nav_logo">
        <tr>
          <td  width="220" rowspan="2" align="center" valign="middle"><img src="${pageContext.request.contextPath }/images/logo.gif" width="193" height="70" border="0" /></td>
          <td class="top_user_info"><a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" class="a_12_666" title="进入个人中心">个人中心</a> | <a href="${pageContext.request.contextPath }/frontUserAction_logout.action" class="a_12_666" title="退出登录">退出登录</a></td>
        </tr>
        <tr>
          <td><!--navigation start-->
            <table width="608" border="0" cellpadding="0" cellspacing="0" >
              <tr>
                <td width="120" align="center"><a href="${pageContext.request.contextPath }/frontIndexAction_index.action" title="智囊团首页"><img src="${pageContext.request.contextPath }/images/nav_button01.gif" width="80" height="16" border="0" /></a></td>
                <td width="2" align="center"><img src="${pageContext.request.contextPath }/images/nav_line.gif" width="2" height="17" border="0" /></td>
                <td width="136" align="center"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action" title="最新解决问题"><img src="${pageContext.request.contextPath }/images/nav_button02.gif" width="96" height="16" border="0" /></a></td>
                <td width="2" align="center"><img src="${pageContext.request.contextPath }/images/nav_line.gif" width="2" height="17" border="0" /></td>
                <td width="104" align="center"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action" title="最新提问"><img src="${pageContext.request.contextPath }/images/nav_button03.gif" width="64" height="16" border="0" /></a></td>
                <td width="2" align="center"><img src="${pageContext.request.contextPath }/images/nav_line.gif" width="2" height="17" border="0" /></td>
                <td width="120" align="center"><a href="${pageContext.request.contextPath }/jsp/front/frontUserCenterAction_index.action" title="进入用户中心"><img src="${pageContext.request.contextPath }/images/nav_button04.gif" width="80" height="16" border="0" /></a></td>
                <td width="2" align="center"><img src="${pageContext.request.contextPath }/images/nav_line.gif" width="2" height="17" border="0" /></td>
                <td width="120" align="center"><a href="${pageContext.request.contextPath }/jsp/front/user/user_register.jsp" title="用户注册"><img src="${pageContext.request.contextPath }/images/nav_button05.gif" width="80" height="16" border="0" /></a></td>
              </tr>
            </table>
            <!--navigation end--></td>
        </tr>
      </table>