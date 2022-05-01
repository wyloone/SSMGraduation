<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE HTML>
<html>
	<head>
		<title>社区信息</title>

		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
<script src="qtimages/js/bootstrap.min.js"></script>
<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./qtimages/sl_common_form.css">
	</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>社区信息</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                     <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="sqxxList.do" name="myform" method="post" style="width:100%">
									查询   社区编号：<input name="shequbianhao" type="text" id="shequbianhao" class="form-control2" />  社区名称：<input name="shequmingcheng" type="text" id="shequmingcheng" class="form-control2" />
									<input type="submit" value="查询" class='hsgqiehuanshitu' /> <input type="button" name="Submit2" value="切换视图" class='hsgqiehuanshitu' onClick="javascript:location.href='sqxxListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px"><div align="center">序号</div></td>
                            <td bgcolor='#ebf0f7'><div align="center">社区编号</div></td>
    <td bgcolor='#ebf0f7'><div align="center">社区名称</div></td>
    <td bgcolor='#ebf0f7' width='90' align='center'><div align="center">社区照片</div></td>
    <td bgcolor='#ebf0f7'><div align="center">社区电话</div></td>
    <td bgcolor='#ebf0f7'><div align="center">社区地址</div></td>
    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> <div align="center">添加时间 </div></td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> <div align="center">操作 </div></td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><div align="center"><%=i%></div></td>
                             <td><div align="center">${u.shequbianhao}</div></td>
    <td><div align="center">${u.shequmingcheng}</div></td>
    <td width='90'><div align="center"><a href='${u.shequzhaopian}' target='_blank'><img src='${u.shequzhaopian}' width=88 height=99 border=0 /></a></div></td>
    <td><div align="center">${u.shequdianhua}</div></td>
    <td><div align="center">${u.shequdizhi}</div></td>
    
                              <td align="center"> <div align="center">${u.addtime} </div></td>
                              <td align="center"><div align="center"><a class="btn btn-info btn-small" href="sqxxDetail.do?id=${u.id}">详细</a></div></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="sqxxList.do?page=1" >首页</a>
             <a href="sqxxList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="sqxxList.do?page=${page.page+1 }">下一页</a>
			<a href="sqxxList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
