<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>邮件详情</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
    <style type="text/css">
      body,td {
        font-size: 18px;
      }
    </style>

  </head>

  <body style="background: url(upload/back02.jpg)" >

  <h3>邮件详情:</h3>
<%--  <br><br>--%>
  
   <%--<table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="black" style="border-collapse:collapse">--%>
  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
   <tr>
     <%--<td width='11%'>收件人：</td><td width='39%'>${youxiang.shoujianren}</td>
     <td width='11%'>发件人：</td><td width='39%'>${youxiang.fajianren}</td></tr><tr>
     <td width='11%'>标题：</td><td width='39%'>${youxiang.biaoti}</td>
     <td width='11%'>正文：</td><td width='39%'>${youxiang.zhengwen}</td>--%>
     <td width='11%'>收件人：</td><td width='39%'>${youxiang.shoujianren}</td></tr>
       <td width='11%'>发件人：</td><td width='39%'>${youxiang.fajianren}</td></tr>
     <td width='11%'>标题：</td><td width='39%'>${youxiang.biaoti}</td></tr>
     <td width='11%'>正文：</td><td width='39%'>${youxiang.zhengwen}</td></tr>
     <td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;
       <input type=button name=Submit5 value=打印 onClick="javascript:window.print()" />
     </td></tr>
    
  </table>

  </body>
</html>

