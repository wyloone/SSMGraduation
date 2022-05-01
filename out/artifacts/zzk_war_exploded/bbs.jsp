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
		<title>在线论坛</title>
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
				<h4>在线论坛</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
                   
                 <table border="0" cellpadding="0" bgcolor="#35A2AE" cellspacing="1" style="border-collapse: collapse" bordercolor="#FFFFFF" width="98%" align="center" class="newsline">
                          <% 
    int bbsi=0;
    String sqlbbs =  "select * from bankuai  order by id desc";
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;
     %>
                          <tr bgcolor="#E1F3F4" height="60" valign="middle">
                            <td width="13%" align="center" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>"><img src="bbs/1.gif" border="0"></a> </td>
                            <td width="37%" align="left" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>">&nbsp;<%=RS_resultbbs.getString("mingcheng") %>&nbsp;</a> </td>
                            <td width="27%" align="left" bgcolor="#FFFFFF">共有<%=connDbBean.getwzs(RS_resultbbs.getString("mingcheng"))%> 篇文章 </td>
                            <td width="23%" bgcolor="#FFFFFF">版主： <%=RS_resultbbs.getString("banzhu") %> </td>
                          </tr>
                          <%
					   	}
					   %>
                        </table>	
                     
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
</body></html>
