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
	<TITLE>捐赠信息查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<link rel="stylesheet" href="images/bootstrap.min.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body style="background: url(upload/back02.jpg)">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td style="font-size:25px; height: 50px" colspan="17" background="images/table_header.gif">捐赠信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="juanzengxinxiList3.do" name="myform" method="post">
									查询   捐赠编号：<input name="juanzengbianhao" type="text" id="juanzengbianhao" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
                            <td width="5%" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7' width="20%">捐赠编号</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">捐赠时间</td>

							<td align='center' bgcolor='#ebf0f7' width="35%">物资图片</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">捐赠人</td>
   
                            <td width="10%" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="10%" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
                             <td>${u.juanzengbianhao}</td>
    <td>${u.juanzengshijian}</td>
    
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.wuzitupian}' target='_blank'><img src='${u.wuzitupian}' width=88 height=99 border=0 /></a></td>
    <td>${u.juanzengren}</td>
    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"> <a class="btn btn-info btn-small" href="deleteJuanzengxinxi.do?id=${u.id }" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="doUpdateJuanzengxinxi.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="jzxxDetail.do?id=${u.id }" target="_blank">详细</a></td>
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
              <a href="juanzengxinxiList3.do?page=1" >首页</a>
             <a href="juanzengxinxiList3.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="juanzengxinxiList3.do?page=${page.page+1 }">下一页</a>
			<a href="juanzengxinxiList3.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
