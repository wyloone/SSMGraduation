<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML>
<html>
	<head>
		<title>淮安市疫情防控志愿者管理系统</title>
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
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
					<div class="grids">
				<h4>社区信息</h4><h5> </h5><div class="clearfix"> </div>
				
				<%
		 int spi=0;
		 %>
		 <c:forEach items="${syshequxinxi}" var="a">
		 <%
		 	spi++;
			if(spi<=8)
			{
		 %>
					<div class="col-md-3 we-do" style="height:280px">
						<div class="active-grid">
							<h3><a href="sqxxDetail.do?id=${a.id}"><img src="${a.shequzhaopian}"  style="height:210px; width:320px;"></a><font color="#42a5f5">${a.shequmingcheng}</font></h3>
						</div>
					</div>
				<%
			}
			%>
		
		</c:forEach>
				
                <div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
	</body>
</html>