<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>������Ϣ��ѯ</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<link rel="stylesheet" href="images/bootstrap.min.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">������Ϣ�б�</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="juanzengxinxiList.do" name="myform" method="post">
									��ѯ   ������ţ�<input name="juanzengbianhao" type="text" id="juanzengbianhao" class="form-control2" />
									<input type="submit" value="��ѯ" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
                            <td width="30px" height="50" align="center" bgcolor="#ebf0f7">���</td>
                            <td align='center' bgcolor='#ebf0f7'>�������</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>����ʱ��</td>        <td  width='90' align='center' bgcolor='#ebf0f7'>����ͼƬ</td>    <td align='center' bgcolor='#ebf0f7'>������</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ����</td><td  width='120' bgcolor='#ebf0f7'>��˻ظ�</td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> ����ʱ�� </td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> ���� </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center">
                              <td height="50" align="center"><%=i%></td>
                             <td>${u.juanzengbianhao}</td>    <td>${u.juanzengshijian}</td>        <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.wuzitupian}' target='_blank'><img src='${u.wuzitupian}' width=88 height=99 border=0 /></a></td>    <td>${u.juanzengren}</td>    <td align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href="sh2.jsp?id=${u.id}&tablename=juanzengxinxi">${u.issh}</a></td><td>${u.shhf}</td>
                              <td height="50" align="center"> ${u.addtime } </td>
                              <td height="50" align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="jzxxDetail.do?id=${u.id}" target="_blank">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="juanzengxinxiList.do?page=1" >��ҳ</a>
             <a href="juanzengxinxiList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="juanzengxinxiList.do?page=${page.page+1 }">��һҳ</a>
			<a href="juanzengxinxiList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

