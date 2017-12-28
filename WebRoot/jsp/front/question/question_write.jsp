<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title>智囊团2.0-提问</title>
<script type="text/javascript">
    var path="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/question_write.js" charset="utf-8"></script>
<script language="javascript" src="${pageContext.request.contextPath }/js/PNG_IMG.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath }/js/tag.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td>
			<!--logo and navigation start-->
			 <jsp:include page="/head_logo.jsp" />
			<!--logo and navigation end-->
		</td>
	</tr>
	<tr>
		<td align="center" valign="middle" class="top_search">
			<!--top search start-->
			 <jsp:include page="/head_form.jsp" /> 
			<!--top search end-->
		</td>
	</tr>
	<tr>
	<td class="container">
    <!--content start-->
      <table width="1000" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="690" valign="top">
    
    
    <div class="page_content_body_link"><a href="index.htm" class="a_14_666" title="智囊团首页">首页</a>-&gt; <a href="QuestionList.htm" class="a_14_666" title="问题列表页">Java SE</a></div>
  <div class="question_write">
  <div class="table">
  <form action="frontQuestionAction_insert.action" method="post" onsubmit="return validateForm()">
 <table width="670" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" class="text_14b_333">填写问题内容</td>
  </tr>
  <tr>
    <td width="100" align="right" class="text_14_666" valign="top">问题标题：</td>
    <td width="670" align="left" valign="top"><input type="text" class="question_write_input" name="question.title" id="question.title" onblur="validateTitle(this.value)" />
      <span id="titleMsg">*</span>
    </td>
  </tr>
  <tr>
    <td width="100" align="right" class="text_14_666" valign="top">奖赏分数：</td>
    <td width="670" align="left" valign="top">
    	<input type="text" class="question_write_ponit" name="question.points" id="question.points" onblur="validatePoints(this.value,'${userid}')" />
    	<span id="pointsMsg">*</span>
    </td>
  </tr>
   <tr>
    <td width="100" align="right" class="text_14_666" valign="top">问题类型：</td>
    <td width="670" align="left" valign="top">
        <s:if test="#request.allType!=null">
           <select name="question.type.tid" id="question.type.tid">
              <s:iterator value="#request.allType">
                 <option value="${tid }">${title }</option>
              </s:iterator>
           </select>
        </s:if>
    </td>
  </tr>
  <tr>
    <td width="100" align="right" class="text_14_666" valign="top">问题内容：</td>
    <td width="670" align="left" valign="top"><textarea class="qusetion_write_content" name="question.content" id="question.content" onblur="validateContent(this.value)"></textarea><br>
       <span id="contentMsg">*</span>
    </td>
  </tr>
    <tr>
	    <td width="100" align="right" class="text_14_666" valign="top">验&nbsp;证&nbsp;码：</td>
	    <td width="670" align="left" valign="top">
	    	<input type="text" class="question_write_ponit" name="code" id="code" onblur="validateCode(this.value)"/>
	    	<img alt="验证码" src="${pageContext.request.contextPath }/image.jsp">
	    	<input type="hidden" name="question.user.userid" id="question.user.userid" value="${userid }">
	    	<span id="codeMsg" >*</span>
	    </td>
  </tr>
    <tr>
    <td width="100" align="right" class="text_14_666" valign="top">&nbsp;</td>
    <td width="670" align="left" valign="top"><input type="image" src="${pageContext.request.contextPath }/images/question_write_button.gif" width="110" height="40" border="0" /></td>
  </tr>
</table>
</form>
</div>
<div class="bottom_img"><img src="${pageContext.request.contextPath }/images/question_content_tab01_bottom.gif" width="690" height="5" border="0" /></div>
</div>


    </td>
    <td width="10"></td>
    <td width="300" valign="top">
    
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

                    <!--用户排行 end-->
                  </div></td>
              </tr>
              <tr>
                <td><img src="${pageContext.request.contextPath }/images/index_right_tab_bottom.gif" width="300" height="10" border="0" /></td>
              </tr>
            </table></td>
  </tr>
</table>

      <!--contnet end--></td>
  </tr>
  <tr>
    <td class="copyright">
		Copyright 2010 智囊团 WWW.ZHINANGTUAN.NET.CN all rights reserved版权所有&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="http://http://www.ccsu.cn/structure/index.htm" class="a_12_blue" title="长沙学院">长沙学院</a>
   </td>
  </tr>
</table>
</body>
</html>
