<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jiarutuandui.xls");
%>
<html>
  <head>
    <title>加入团队</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">序号</td>
    <td align='center'>团队账号</td>    <td align='center'>团队名称</td>    <td align='center'>创建人</td>    <td align='center'>联系电话</td>    <td align='center'>加入人</td>    <td align='center'>志愿者姓名</td>    
	
    <td width="120" align="center" >添加时间</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from jiarutuandui  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("tuanduizhanghao")%></td>    <td><%=RS_result.getString("tuanduimingcheng")%></td>    <td><%=RS_result.getString("chuangjianren")%></td>    <td><%=RS_result.getString("lianxidianhua")%></td>    <td><%=RS_result.getString("jiaruren")%></td>    <td><%=RS_result.getString("zhiyuanzhexingming")%></td>    <td><%=RS_result.getString("issh")%></td>    <td><%=RS_result.getString("shhf")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

