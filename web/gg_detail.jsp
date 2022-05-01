<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML>
<html>
	<head>
		<title>内容详细</title>
		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
<script src="qtimages/js/bootstrap.min.js"></script>
<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./qtimages/sl_common_form.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<style type="text/css">
			body,td,th {
				font-size: 15px;
			}
		</style>
	</head>
		 <%
  String id=request.getParameter("id");
  connDbBean.hsgexecute("update xinwentongzhi set dianjilv=dianjilv+1 where id="+id);
%>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>内容详细</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                      <table width="97%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#67B41A" style="border-collapse:collapse" class="newsline">
                        <tr>
                          <td height="74" align="center"><font style="color:#e0b508; font-size:18px;font-weight:bold" >${xinwentongzhi.biaoti} (被访问${xinwentongzhi.dianjilv }次)</font></td>
                        </tr>
                        <tr>
                          <td height="104">${xinwentongzhi.neirong }</td>
                        </tr>
                        <tr>
                          <td align="right" height="60"><input type="button" onClick="javaScript:history.back();" value="返回" class="content-form-signup" /></td>
                        </tr>
                      </table>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
	</body>
</html>