<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>加入团队详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  加入团队详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>团队账号：</td><td width='39%'>${jiarutuandui.tuanduizhanghao}</td>     <td width='11%'>团队名称：</td><td width='39%'>${jiarutuandui.tuanduimingcheng}</td></tr><tr>     <td width='11%'>创建人：</td><td width='39%'>${jiarutuandui.chuangjianren}</td>     <td width='11%'>联系电话：</td><td width='39%'>${jiarutuandui.lianxidianhua}</td></tr><tr>     <td width='11%'>加入人：</td><td width='39%'>${jiarutuandui.jiaruren}</td>     <td width='11%'>志愿者姓名：</td><td width='39%'>${jiarutuandui.zhiyuanzhexingming}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

