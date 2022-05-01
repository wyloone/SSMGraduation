<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>志愿团队详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  志愿团队详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>团队帐号：</td><td width='39%'>${zhiyuantuandui.tuanduizhanghao}</td><td  rowspan=7 align=center><a href=${zhiyuantuandui.tuanduilogo} target=_blank><img src=${zhiyuantuandui.tuanduilogo} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${zhiyuantuandui.mima}</td></tr><tr><td width='11%' height=44>团队名称：</td><td width='39%'>${zhiyuantuandui.tuanduimingcheng}</td></tr><tr><td width='11%' height=44>创建人：</td><td width='39%'>${zhiyuantuandui.chuangjianren}</td></tr><tr><td width='11%' height=44>联系电话：</td><td width='39%'>${zhiyuantuandui.lianxidianhua}</td></tr><tr><td width='11%' height=44>邮箱：</td><td width='39%'>${zhiyuantuandui.youxiang}</td></tr><tr><td width='11%' height=44>创建时间：</td><td width='39%'>${zhiyuantuandui.chuangjianshijian}</td></tr><tr><td width='11%' height=100  >团队简介：</td><td width='39%' colspan=2 height=100 >${zhiyuantuandui.tuanduijianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

