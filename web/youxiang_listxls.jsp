<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=youxiang.xls");
%>
<html>
  <head>
    <title>����</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">���</td>
    <td align='center'>�ռ���</td>    <td align='center'>������</td>    <td align='center'>����</td>    <td align='center'>����</td>    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from youxiang  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("shoujianren")%></td>    <td><%=RS_result.getString("fajianren")%></td>    <td><%=RS_result.getString("biaoti")%></td>    <td><%=RS_result.getString("zhengwen")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

