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
<% String bk=request.getParameter("bk"); %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>在线论坛</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
                   
                 <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="104" valign="top"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
                                <tr>
                                  <td width="30" bgcolor="#EBE2FE">序号</td>
                                  <td width="352" bgcolor='#EBE2FE'>标题</td>
                                  <td width="48" bgcolor='#EBE2FE'>类型</td>
                                  <td width="60" bgcolor='#EBE2FE'>发帖人</td>
                                  <td width="130" align="center" bgcolor="#EBE2FE">发布时间</td>
                                  <td width="65" align="center" bgcolor="#EBE2FE">已有回帖</td>
                                </tr>
                                 <% 

  	
    String sqlbbs =  "select * from tiezi where bankuai='"+bk+"' and fid='0' order by issh desc, id desc";
	int bbsi=0;
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;

     %>
                                <tr>
                                  <td width="30"><%=bbsi%></td>
                                  <td><a href="tiezidetail.jsp?id=<%=RS_resultbbs.getString("id") %>"><%
								  if(RS_resultbbs.getString("issh").equals("是"))
								  {
								  %>
								  <img src="bbs/zhiding.png" width="15" height="15" style="padding-top:5px;">
								  <%
								  }
								  %><%=RS_resultbbs.getString("biaoti") %> </a></td>
                                  <td><img src="bbs/<%=RS_resultbbs.getString("leixing") %>.gif" width="18" height="18"></td>
                                  <td><%=RS_resultbbs.getString("faburen") %></td>
                                  <td width="130" align="center"><%=RS_resultbbs.getString("addtime") %></td>
                                  <td width="65" align="center"><%=connDbBean.gettzs((String)RS_resultbbs.getString("id")) %></td>
                                </tr>
	<%
  }
   %>
                            </table></td>
                          </tr>
                          <tr>
                            <td align="right"><a href="tieziadd.jsp?bk=<%=bk%>">我要发帖</a> <a href="bbs.jsp" onClick="javascript:history.back();">返回</a></td>
                          </tr>
                        </table>	
                     
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
</body></html>
