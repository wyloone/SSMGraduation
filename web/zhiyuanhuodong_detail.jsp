<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>志愿活动详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  志愿活动详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>活动名称：</td><td width='39%'>${zhiyuanhuodong.huodongmingcheng}</td>     <td width='11%'>活动开始时间：</td><td width='39%'>${zhiyuanhuodong.huodongkaishishijian}</td></tr><tr>     <td width='11%'>活动结束时间：</td><td width='39%'>${zhiyuanhuodong.huodongjieshushijian}</td>     <td width='11%'>活动内容：</td><td width='39%'>${zhiyuanhuodong.huodongneirong}</td></tr><tr>     <td width='11%'>活动地址：</td><td width='39%'>${zhiyuanhuodong.huodongdizhi}</td>     <td width='11%'>团队账号：</td><td width='39%'>${zhiyuanhuodong.tuanduizhanghao}</td></tr><tr>     <td width='11%'>团队名称：</td><td width='39%'>${zhiyuanhuodong.tuanduimingcheng}</td>     <td width='11%'>创建人：</td><td width='39%'>${zhiyuanhuodong.chuangjianren}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${zhiyuanhuodong.lianxidianhua}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

