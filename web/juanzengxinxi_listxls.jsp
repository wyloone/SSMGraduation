<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=juanzengxinxi.xls");
%>
<html>
  <head>
    <title>������Ϣ</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">���</td>
    <td align='center'>�������</td>    <td align='center'>����ʱ��</td>    <td align='center'>��������</td>    <td align='center'>����ͼƬ</td>    <td align='center'>������</td>    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from juanzengxinxi  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("juanzengbianhao")%></td>    <td><%=RS_result.getString("juanzengshijian")%></td>    <td><%=RS_result.getString("juanzengneirong")%></td>    <td><%=RS_result.getString("wuzitupian")%></td>    <td><%=RS_result.getString("juanzengren")%></td>    <td><%=RS_result.getString("issh")%></td>    <td><%=RS_result.getString("shhf")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

