<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhiyuanzhetuandui.xls");
%>
<html>
  <head>
    <title>־Ը���Ŷ�</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">���</td>
    <td align='center'>�Ŷ��ʺ�</td>    <td align='center'>����</td>    <td align='center'>�Ŷ�����</td>    <td align='center'>�Ŷ�logo</td>    <td align='center'>����������</td>    <td align='center'>����ʱ��</td>    <td align='center'>�ŶӼ��</td>    
	
    <td width="120" align="center" >���ʱ��</td>
    
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

