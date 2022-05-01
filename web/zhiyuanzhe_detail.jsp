<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>志愿者详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  志愿者详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>志愿者账号：</td><td width='39%'>${zhiyuanzhe.zhiyuanzhezhanghao}</td>     <td width='11%'>密码：</td><td width='39%'>${zhiyuanzhe.mima}</td></tr><tr>     <td width='11%'>志愿者姓名：</td><td width='39%'>${zhiyuanzhe.zhiyuanzhexingming}</td>     <td width='11%'>性别：</td><td width='39%'>${zhiyuanzhe.xingbie}</td></tr><tr>     <td width='11%'>年龄：</td><td width='39%'>${zhiyuanzhe.nianling}</td>     <td width='11%'>身份证：</td><td width='39%'>${zhiyuanzhe.shenfenzheng}</td></tr><tr>     <td width='11%'>邮箱：</td><td width='39%'>${zhiyuanzhe.youxiang}</td>     <td width='11%'>电话：</td><td width='39%'>${zhiyuanzhe.dianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${zhiyuanzhe.dizhi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

