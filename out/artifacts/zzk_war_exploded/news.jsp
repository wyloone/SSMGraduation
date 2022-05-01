<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
 <%
  String lb=request.getParameter("lb");
  //String lb=new String(request.getParameter("lb").getBytes("8859_1"));
%>
<!DOCTYPE HTML>
<html>
	<head>
		<title><%=lb%></title>
		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
<script src="qtimages/js/bootstrap.min.js"></script>
<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./qtimages/sl_common_form.css">

		<style type="text/css">
			body,td,th {
				font-size: 15px;
			}
		</style>
	</head>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4><%=lb%></h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#FA9090" class="newsline" style="border-collapse:collapse">
						<%int i=0;%>
						<c:forEach items="${list }" var="u">
                            <%i++;%>
                          <tr>
                            <td width="29" align="center"><%=i %></td>
                            <td width="428"><a href="xwtzDetail.do?id=${u.id}">${u.biaoti}</a></td>
                            <td width="74">被点${u.dianjilv}次</td>
                            <td width="146" align="center">${u.addtime}</td>
                          </tr>
                         </c:forEach>
                        </table>
                          <div align="center"><br>
                           <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xwtzList.do?page=1&lb=<%=lb%>" >首页</a>
             <a href="xwtzList.do?page=${page.page-1}&lb=<%=lb%>"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xwtzList.do?page=${page.page+1}&lb=<%=lb%>">下一页</a>
			<a href="xwtzList.do?page=${page.totalPage}&lb=<%=lb%>">末页</a>		    </c:if>		
	</c:if>
	</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
	</body>
</html>