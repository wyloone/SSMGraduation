<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhiyuanhuodong.xls");
%>
<html>
  <head>
    <title>־Ը�</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">���</td>
    <td align='center'>�����</td>    <td align='center'>���ʼʱ��</td>    <td align='center'>�����ʱ��</td>    <td align='center'>�����</td>    <td align='center'>���ַ</td>    <td align='center'>�Ŷ��˺�</td>    <td align='center'>�Ŷ�����</td>    <td align='center'>������</td>    <td align='center'>��ϵ�绰</td>    
	
    <td width="120" align="center" >���ʱ��</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from zhiyuanhuodong  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("huodongmingcheng")%></td>    <td><%=RS_result.getString("huodongkaishishijian")%></td>    <td><%=RS_result.getString("huodongjieshushijian")%></td>    <td><%=RS_result.getString("huodongneirong")%></td>    <td><%=RS_result.getString("huodongdizhi")%></td>    <td><%=RS_result.getString("tuanduizhanghao")%></td>    <td><%=RS_result.getString("tuanduimingcheng")%></td>    <td><%=RS_result.getString("chuangjianren")%></td>    <td><%=RS_result.getString("lianxidianhua")%></td>    <td><%=RS_result.getString("issh")%></td>    <td><%=RS_result.getString("shhf")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

