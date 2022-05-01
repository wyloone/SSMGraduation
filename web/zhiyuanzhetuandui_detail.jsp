<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>志愿者团队详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  志愿者团队详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>团队帐号：</td><td width='39%'>${zhiyuanzhetuandui.tuanduizhanghao}</td><td  rowspan=5 align=center><a href=${zhiyuanzhetuandui.tuanduilogo} target=_blank><img src=${zhiyuanzhetuandui.tuanduilogo} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${zhiyuanzhetuandui.mima}</td></tr><tr><td width='11%' height=44>团队名称：</td><td width='39%'>${zhiyuanzhetuandui.tuanduimingcheng}</td></tr><tr><td width='11%' height=44>创建人姓名：</td><td width='39%'>${zhiyuanzhetuandui.chuangjianrenxingming}</td></tr><tr><td width='11%' height=44>创建时间：</td><td width='39%'>${zhiyuanzhetuandui.chuangjianshijian}</td></tr><tr><td width='11%' height=100  >团队简介：</td><td width='39%' colspan=2 height=100 >${zhiyuanzhetuandui.tuanduijianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

