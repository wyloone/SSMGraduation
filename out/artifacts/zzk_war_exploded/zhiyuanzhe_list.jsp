<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>志愿者查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<link rel="stylesheet" href="images/bootstrap.min.css" type="text/css">
	</head>
	<body style="background: url(upload/back02.jpg)">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td style="font-size:25px; height: 50px" colspan="17" background="images/table_header.gif">志愿者列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="zhiyuanzheList.do" name="myform" method="post">
									查询   志愿者账号：<input name="zhiyuanzhezhanghao" type="text" id="zhiyuanzhezhanghao" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" /> <input type="button" value="导出excel" onClick="javascript:location.href='zhiyuanzhe_listxls.jsp';" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
							   <td align="center" bgcolor="#ebf0f7" width="2%" height="50">序号</td>
							   <td align='center' bgcolor='#ebf0f7' width="5%">志愿者账号</td>
							   <td align='center' bgcolor='#ebf0f7' width="5%">密码</td>
							   <td align='center' bgcolor='#ebf0f7' width="8%">志愿者姓名</td>
							   <td width="3%" align='center' bgcolor='#ebf0f7'>性别</td>
							   <td align='center' bgcolor='#ebf0f7' width="4%">年龄</td>
							   <td align='center' bgcolor='#ebf0f7' width="10%">身份证</td>
							   <td align='center' bgcolor='#ebf0f7' width="10%">邮箱</td>
							   <td align='center' bgcolor='#ebf0f7' width="10%">电话</td>
							   <td align='center' bgcolor='#ebf0f7' width="13%">地址</td>
							   <td align='center' bgcolor='#ebf0f7' width="10%">是否审核</td>
							   <td width="10%" height="50" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
							   <td width="10%" height="50" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center">
                              <td height="50" align="center"><%=i%></td>
                             <td>${u.zhiyuanzhezhanghao}</td>
							<td>${u.mima}</td>
							<td>${u.zhiyuanzhexingming}</td>
							<td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
							<td>${u.nianling}</td>
							<td>${u.shenfenzheng}</td>
							<td>${u.youxiang}</td>
							<td>${u.dianhua}</td>
							<td>${u.dizhi}</td>
							<td align='center'>${u.issh}
								<input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=zhiyuanzhe'"/>
							</td>
                              <td height="50" align="center" > ${u.addtime } </td>
                              <td height="50" align="center">
								  <%--<a class="btn btn-info btn-small" href="doUpdateZhiyuanzhe.do?id=${u.id }">编辑</a> --%>
								  <a class="btn btn-info btn-small" href="deleteZhiyuanzhe.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a>
								  <%--<a class="btn btn-info btn-small" href="zyzDetail.do?id=${u.id}" target="_blank">详细</a>--%></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="zhiyuanzheList.do?page=1" >首页</a>
             <a href="zhiyuanzheList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zhiyuanzheList.do?page=${page.page+1 }">下一页</a>
			<a href="zhiyuanzheList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>


	<%


		ResultSet RS_result;
		if (request.getSession().getAttribute("cx").equals("超级管理员")){
			String sql="";

			sql="select count(id) as gwegwg  from zhiyuanzhe where issh='否'";

			RS_result=connDbBean.executeQuery(sql);
			String dd="";

			if(RS_result.next())
			{
				dd=RS_result.getString("gwegwg");


			}

	%>


	<style>
		#winpop { width:200px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #666; margin:0; padding:1px; overflow:hidden; display:none;}
		#winpop .title { width:100%; height:22px; line-height:20px; background:#FFCC00; font-weight:bold; text-align:center; font-size:12px;}
		#winpop .con { width:100%; height:90px; line-height:20px; font-weight:bold; font-size:12px; color:#FF0000; text-align:center}
		#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;}
		.close { position:absolute; right:4px; top:-1px; color:#FFF; cursor:pointer}
	</style>
	<script type="text/javascript">
		function tips_pop(){
			var MsgPop=document.getElementById("winpop");
			var popH=parseInt(MsgPop.style.height);//将对象的高度转化为数字
			if (popH==0){
				MsgPop.style.display="block";//显示隐藏的窗口
				show=setInterval("changeH('up')",2);
			}
			else {
				hide=setInterval("changeH('down')",2);
			}
		}
		function changeH(str) {
			var MsgPop=document.getElementById("winpop");
			var popH=parseInt(MsgPop.style.height);
			if(str=="up"){
				if (popH <=100){
					MsgPop.style.height=(popH+4).toString()+"px";
				}
				else{
					clearInterval(show);
				}
			}
			if(str=="down"){
				if (popH>=4){
					MsgPop.style.height=(popH-4).toString()+"px";
				}
				else{
					clearInterval(hide);
					MsgPop.style.display="none"; //隐藏DIV
				}
			}
		}
		window.onload=function(){ //加载
			document.getElementById('winpop').style.height='0px';
			setTimeout("tips_pop()",500); //3秒后调用tips_pop()这个函数
		}
	</script>
	<%--<div id="silu">
		<body>
	</div>--%>
	<div id="winpop">
		<div class="title">系统提醒！ <span class="close" onClick="tips_pop()">X </span> </div>

		<div class="con">当前有<%=dd%>条志愿者申请未审核！</div>

			<%
}
%>
	</body>
</html>
