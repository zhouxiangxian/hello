<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>������2.0-��Ա����-�ҵĻش�</title>
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/PNG_IMG.js"
			type="text/javascript"></script>
		<script language="javascript"
			src="${pageContext.request.contextPath}/js/tag.js"
			type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/userStyle.css"
			rel="stylesheet" type="text/css" />
	</head>
	<body>
		<table width="1000" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td>
					<!--logo and navigation start-->
					<jsp:include page="/head_logo.jsp" />
					<!--�� ����������-->
				</td>
			</tr>
			<tr>
				<td align="center" valign="middle" class="top_search">
					<!--����������ʼ-->
					<jsp:include page="/head_form.jsp"/>
					<!---������������-->
					<!--logo and navigation end-->
				</td>
			</tr>
			<tr>
				<td class="container">
					<!--content start-->
					<table width="1000" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="230" align="left" valign="top">
								<jsp:include page="user_menu.jsp"/>
							</td>
							<td width="10"></td>
							<td width="760" align="left" valign="top">
								<!--������� start-->
								<div class="uc_body_title">
									<ul>
										<li>
											<a href="${pageContext.request.contextPath }/frontIndexAction_index.action" class="a_14_666" title="������ҳ">��ҳ</a>&nbsp;-&gt;&nbsp;��Ա����&nbsp;-&gt;&nbsp;
											<a href="#" class="a_14_666" title="�ҵĻش�">�ҵĻش�</a>
										</li>
										<li>
											<img
												src="${pageContext.request.contextPath}/images/uc_body_title_line.jpg"
												width="760" height="4" border="0" />
										</li>
									</ul>
								</div>
								<!--������� end-->

								<!--ȫ�������� start-->
								<table width="760" border="0" cellspacing="0" cellpadding="0"
									class="question_list_content_tab">
									<!--ѭ��tr��� start-->
									<tr>
										<td align="left" class="text_14_666" width="700">
											<a href="${pageContext.request.contextPath }/jsp/front/frontQuestionAction_listAll.action?tid=${currentType.tid}" class="a_14_blue" title="�鿴��������">[${currentType.title }]</a>&nbsp;������������
											<span>[�ѽ��]</span>
										</td>
										<td align="right" class="text_14_999" width="60">
											10 �ش�
										</td>
									</tr>
									<!--ѭ��tr��� end-->
									<tr>
										<td colspan="2" style="border: none;" class="split_page_td">
											<!--��ҳ Start-->
											<input type="button" value="��ҳ" onclick=
	gosp(1);
disabled
												class="pageButton" />
											<input type="button" value="��һҳ" onclick=
	gosp(0);
disabled
												class="pageButton" />
											<input type="button" value="��һҳ" onclick=
	gosp(2);
disabled
												class="pageButton" />
											<input type="button" value="βҳ" onclick=
	gosp(1);
disabled
												class="pageButton" />

											��ת����
											<select name="selcp" onchange="gosp(this.value)">

												<option value="1" SELECTED>
													1
												</option>

											</select>
											ҳ ÿҳ��ʾ
											<select name="ls" onchange="gosp(1)">

												<option value="1">
													1
												</option>

												<option value="3">
													3
												</option>

												<option value="5" SELECTED>
													5
												</option>

												<option value="10">
													10
												</option>

												<option value="15">
													15
												</option>

												<option value="20">
													20
												</option>

												<option value="30">
													30
												</option>

												<option value="50">
													50
												</option>

												<option value="100">
													100
												</option>

												<option value="150">
													150
												</option>

												<option value="200">
													200
												</option>

											</select>
											����¼


											<input type="hidden" name="cp" value="">
												<input type="hidden" name="deptno" value="null">
													<input type="hidden" name="status" value="">
														<!--��ҳ end-->
										</td>
									</tr>
								</table>
								<!--ȫ�������� end-->
							</td>
						</tr>
					</table>
					<!--contnet end-->
				</td>
			</tr>
			<tr>
				<td class="copyright">
					Copyright 2010 ������ WWW.ZHINANGTUAN.NET.CN all rights reserved
					��Ȩ����&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.mldnjava.cn" class="a_12_blue"
						title="ħ�ֿƼ����ѧԺ-Java��ѵ">ħ�ֿƼ����ѧԺ</a>
				</td>
			</tr>
		</table>
	</body>
</html>
