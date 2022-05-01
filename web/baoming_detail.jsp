<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>报名详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  报名详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>活动名称：</td><td width='39%'>${baoming.huodongmingcheng}</td>     <td width='11%'>活动开始时间：</td><td width='39%'>${baoming.huodongkaishishijian}</td></tr><tr>     <td width='11%'>活动结束时间：</td><td width='39%'>${baoming.huodongjieshushijian}</td>     <td width='11%'>活动地址：</td><td width='39%'>${baoming.huodongdizhi}</td></tr><tr>     <td width='11%'>团队账号：</td><td width='39%'>${baoming.tuanduizhanghao}</td>     <td width='11%'>团队名称：</td><td width='39%'>${baoming.tuanduimingcheng}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${baoming.lianxidianhua}</td>     <td width='11%'>报名人：</td><td width='39%'>${baoming.baomingren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

