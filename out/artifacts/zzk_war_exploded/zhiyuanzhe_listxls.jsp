<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhiyuanzhe.xls");
%>
<html>
  <head>
    <title>志愿者</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">序号</td>
    <td align='center'>志愿者账号</td>    <td align='center'>密码</td>    <td align='center'>志愿者姓名</td>    <td align='center'>性别</td>    <td align='center'>年龄</td>    <td align='center'>身份证</td>    <td align='center'>邮箱</td>    <td align='center'>电话</td>    <td align='center'>地址</td>    
	
    <td width="120" align="center" >添加时间</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from zhiyuanzhe  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("zhiyuanzhezhanghao")%></td>    <td><%=RS_result.getString("mima")%></td>    <td><%=RS_result.getString("zhiyuanzhexingming")%></td>    <td><%=RS_result.getString("xingbie")%></td>    <td><%=RS_result.getString("nianling")%></td>    <td><%=RS_result.getString("shenfenzheng")%></td>    <td><%=RS_result.getString("youxiang")%></td>    <td><%=RS_result.getString("dianhua")%></td>    <td><%=RS_result.getString("dizhi")%></td>    <td><%=RS_result.getString("issh")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

