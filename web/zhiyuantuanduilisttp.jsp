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
		<title>志愿团队</title>

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

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
			<h4>志愿团队</h4><h5> </h5><div class="clearfix"> </div>
			<div class="content-form">
				<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
					<form action="zytdListtp.do" name="myform" method="post" style="width:100%">
						查询   团队帐号：<input name="tuanduizhanghao" type="text" id="tuanduizhanghao" class="form-control2" />  团队名称：<input name="tuanduimingcheng" type="text" id="tuanduimingcheng" class="form-control2" />  创建人：<input name="chuangjianren" type="text" id="chuangjianren" class="form-control2" />  创建时间：<input name="chuangjianshijian1" type="text" id="chuangjianshijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />-<input name="chuangjianshijian2" type="text" id="chuangjianshijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />
						<input type="submit" value="查询" class='hsgqiehuanshitu' /> <input type="button" name="Submit2" value="切换视图" class='hsgqiehuanshitu'  onClick="javascript:location.href='zytdList.do';" />
					</form>
				<br />
				<table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                          <%
					int i=0;
				%>
				<c:forEach items="${list}" var="u">
				<%
					i++;
				%>
                           <td height="316" align="center"><table height="285" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td height="250" align="center"><a href="zytdDetail.do?id=${u.id}"><img src="${u.tuanduilogo}" width="210" height="250" border="0" style="border-radius: 18px;" /></a></td>
                                </tr>
                                <tr>
                                  <td height="26" align="center">${u.tuanduimingcheng}</td>
                                </tr>
                            </table></td>
							  <%
								if (i==4)
								{
									i=0;
									out.print("</tr><tr>");
								}
				  	
					
				  %>
							</c:forEach>
							
                          
                          </tr>
                        </table><br>

<p align="center"> <c:if test="${sessionScope.p==1}">
		 <c:if test="${page.page>1}">
              <a href="zytdListtp.do?page=1" >首页</a>
             <a href="zytdListtp.do?page=${page.page-1}"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zytdListtp.do?page=${page.page+1}">下一页</a>
			<a href="zytdListtp.do?page=${page.totalPage}">末页</a>		    </c:if>		
	</c:if>
	</p>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
