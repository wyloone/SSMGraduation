<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhiyuanzhetuandui.xls");
%>
<html>
  <head>
    <title>志愿者团队</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">序号</td>
    <td align='center'>团队帐号</td>    <td align='center'>密码</td>    <td align='center'>团队名称</td>    <td align='center'>团队logo</td>    <td align='center'>创建人姓名</td>    <td align='center'>创建时间</td>    <td align='center'>团队简介</td>    
	
    <td width="120" align="center" >添加时间</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from zhiyuanzhetuandui  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("tuanduizhanghao")%></td>    <td><%=RS_result.getString("mima")%></td>    <td><%=RS_result.getString("tuanduimingcheng")%></td>    <td><%=RS_result.getString("tuanduilogo")%></td>    <td><%=RS_result.getString("chuangjianrenxingming")%></td>    <td><%=RS_result.getString("chuangjianshijian")%></td>    <td><%=RS_result.getString("tuanduijianjie")%></td>    <td><%=RS_result.getString("issh")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

