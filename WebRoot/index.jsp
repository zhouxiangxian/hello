<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>智囊团2.0-首页</title>
<script  src="js/PNG_IMG.js" type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td>
      <!--logo and navigation start-->
      <jsp:include page="head_logo.jsp"/>
      <!--logo and navigation end-->
      </td>
  </tr>
  <tr>
    <td align="center" valign="middle" class="top_search">
	    <!--top search start-->
	    <jsp:include page="head_form.jsp"/> 
	    <!--top search end-->
    </td>
  </tr>
  <tr>
    <td class="container">
    <!--content start-->
      <table width="1000" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="160" valign="top"><!--left tab start-->
            <table width="160" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td class="index_left_tab_top" valign="middle">&nbsp;&nbsp;问题分类</td>
              </tr>
              <tr>
                <td align="center"><div  class="index_left_tab_content">
                    <!--loop dl tag start-->
                    <dl class="index_left_question_list">
                      <dt>Java开发</dt>
                      <s:if test="#request.allTypes!=null">
                      <s:iterator value="#request.allTypes">
                      <dd><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${tid}" class="a_14_666">${title }</a></dd>
                      </s:iterator>
                      </s:if>
                    </dl>
                    <!--loop dl tag end-->
                  </div></td>
              </tr>
              <tr>
                <td><img src="images/index_question_list_tab_bottom.jpg" width="160" height="10" border="0" /></td>
              </tr>
            </table>
            <!--left tab end--></td>
          <td width="10"></td>
          <td width="520" valign="top"><!--center tab start-->
            <img src="images/index_content_img.jpg" width="520" height="240" border="0" class="index_center_content_img" />
            <!--推荐问题 start-->
            <table width="520" border="0" cellspacing="0" cellpadding="0" class="index_center_question_tab">
              <tr class="index_center_question_title">
                <td width="30" align="left" valign="middle"><img src="images/index_center_ico01.gif" width="25" height="25" border="0" /></td>
                <td width="420" align="left" class="text_14b_black">推荐问题</td>
                <td width="70" align="right" class="text_12_blue"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action" class="a_12_blue" title="进入问题列表">更多&gt;&gt;</a></td>
              </tr>
              <tr>
                <td colspan="3" ><!--loop ul tag start-->
                  <ul class="index_center_question_text">
                    <li class="question_title"></li>
                    <li class="question_info">0 回答</li>
                    <div class="clear"></div>
                  </ul>
                  <!--loop ul tag end--></td>
              </tr>
            </table>
            <!--推荐问题 end-->
            <!--待解决问题 start-->
            <table width="520" border="0" cellspacing="0" cellpadding="0" class="index_center_question_tab">
              <tr class="index_center_question_title">
                <td width="30" align="left" valign="middle"><img src="images/index_center_ico02.gif" width="23" height="25" border="0" /></td>
                <td width="420" align="left" class="text_14b_black">待解决问题</td>
                <td width="70" align="right" class="text_12_blue"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action" class="a_12_blue" title="进入问题列表">更多&gt;&gt;</a></td>
              </tr>
              <tr>
                <td colspan="3" ><!--loop ul tag start-->
                    <s:if test="#request.questionsStatus1!=null">
                        <s:iterator value="#request.questionsStatus1">
                        <ul class="index_center_question_text">
		                    <li class="question_title"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}" class="a_14_666">${title }</a></li>
		                    <li class="question_info">${count } 回答</li>
                        <div class="clear"></div>
                        </ul>
	                    </s:iterator>
                    </s:if>
                  <!--loop ul tag end-->
                </td>
              </tr>
            </table>
            <!--待解决问题 end-->
            <!--最新解决问题 start-->
            <table width="520" border="0" cellspacing="0" cellpadding="0" class="index_center_question_tab">
              <tr class="index_center_question_title">
                <td width="30" align="left" valign="middle"><img src="images/index_center_ico03.gif" width="20" height="25" border="0" /></td>
                <td width="420" align="left" class="text_14b_black">最新解决问题</td>
                <td width="70" align="right" class="text_12_blue"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action" class="a_12_blue" title="进入问题列表">更多&gt;&gt;</a></td>
              </tr>
              <tr>
                <td colspan="3" >
                <!--loop ul tag start-->
                  <s:if test="#request.questionsStatus0">
                    <s:iterator value="#request.questionsStatus0">
	                  <ul class="index_center_question_text">
	                    <li class="question_title"><a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_show?question.qid=${qid}" class="a_14_666">${title }</a></li>
	                    <li class="question_info">${count } 回答</li>
	                    <div class="clear"></div>
	                  </ul>
                    </s:iterator>
                  </s:if>
                  <!--loop ul tag end-->
                  </td>
              </tr>
            </table>
            <!--最新解决问题 end-->
            <!--center tab end--></td>
          <td width="10"></td>
          <td width="300" valign="top"><!--right tab start-->
            <!--公告 start-->
            <table width="300" border="0" cellspacing="0" cellpadding="0" class="right_notice">
              <tr>
                <td class="right_notice_title">&nbsp;&nbsp;公告
                &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/jsp/front/frontNoticeAction_list.action" class="a_12_blue" title="进入公告列表">更多&gt;&gt;</a>
                </td>
                
              </tr>
              <s:if test="#request.allNotices!=null">
              <s:iterator value="#request.allNotices">
              <tr>
                <td>
                	<div class="right_notice_content"> &middot; <a href="${pageContext.request.contextPath }/jsp/front/frontNoticeAction_show.action?notice.nid=${nid}" class="a_12_blue">${title }</a><span>[${ pubtime}]</span><br />
                  	</div>
                </td>
              </tr>
              </s:iterator>
              </s:if>
              <tr>
                <td><img src="${pageContext.request.contextPath }/images/index_right_notice_tab_bottom.jpg" width="300" height="10" border="0" /></td>
              </tr>
            </table>
            <!--公告 end-->
            <!--智囊团专家 and 用户排行榜 Start-->
            <table width="300" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="${pageContext.request.contextPath }/images/index_right_tab_top.gif" width="300" height="10" border="0" /></td>
              </tr>
              <tr>
                <td><div class="index_right_tab_content">
                <!--智囊团专家 start-->
                    <table width="288" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="right_experts_title" colspan="2">智囊团专家</td>
                      </tr>
                      <tr>
                      <td height="5" colspan="2"></td>
                      </tr>
                      <tr>
                        <td width="140" align="left" valign="top"><img src="${pageContext.request.contextPath }/images/cat.jpg" width="130" height="100" border="0" /></td>
                        <td  width="148" align="left" valign="top" class="right_experts_content"><span class="text_14b_black">小白菜</span><br />
                          小白科技教学总监<br />
                          小白软通系统架构师<br />
                          小白网技术总监<br />
                          …… </td>
                      </tr>
                      <tr>
                        <td colspan="2" class="right_experts_text">    丰富的JAVA/JAVAEE设计和开发经验以及多年培训经验....</td>
                      </tr>
                    </table>
                    <!--智囊团专家 end-->
                    <!--用户排行 start-->
                    <jsp:include page="/head_user.jsp"/>
                    <!--用户排行 end-->
                  </div></td>
              </tr>
              <tr>
                <td><img src="${pageContext.request.contextPath }/images/index_right_tab_bottom.gif" width="300" height="10" border="0" /></td>
              </tr>
            </table>
            <!--智囊团专家 and 用户排行榜 end-->
            <!--right tab end--></td>
        </tr>
      </table>
      <!--contnet end-->
      </td>
  </tr>
  <tr>
		<td class="copyright">
			Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN all rights reserved
			版权所有&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue"
				title="长沙学院">长沙学院</a>
		</td>
 </tr>
</table>
</body>
</html>
