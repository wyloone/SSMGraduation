<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shequxinxi.xls");
%>
<html>
  <head>
    <title>������Ϣ</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">���</td>
    <td align='center'>�������</td>    <td align='center'>��������</td>    <td align='center'>������Ƭ</td>    <td align='center'>�����绰</td>    <td align='center'>������ַ</td>    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from shequxinxi  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("shequbianhao")%></td>    <td><%=RS_result.getString("shequmingcheng")%></td>    <td><%=RS_result.getString("shequzhaopian")%></td>    <td><%=RS_result.getString("shequdianhua")%></td>    <td><%=RS_result.getString("shequdizhi")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

