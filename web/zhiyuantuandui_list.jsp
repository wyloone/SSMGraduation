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
	<TITLE>志愿团队查询</TITLE>
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
							<td style="font-size:25px; height: 50px" colspan="17" background="images/table_header.gif">志愿团队列表</td>
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
								<form action="zhiyuantuanduiList.do" name="myform" method="post">
									查询   团队帐号：<input name="tuanduizhanghao" type="text" id="tuanduizhanghao" class="form-control2" />  团队名称：<input name="tuanduimingcheng" type="text" id="tuanduimingcheng" class="form-control2" />  创建人：<input name="chuangjianren" type="text" id="chuangjianren" class="form-control2" />  创建时间：<input name="chuangjianshijian1" type="text" id="chuangjianshijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />-<input name="chuangjianshijian2" type="text" id="chuangjianshijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" /> <input type="button" value="导出excel" onClick="javascript:location.href='zhiyuantuandui_listxls.jsp';" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
                           <%-- <td align="center" bgcolor="#ebf0f7" width="30px" height="50">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>团队帐号</td>
							<td align='center' bgcolor='#ebf0f7'>密码</td>
							<td align='center' bgcolor='#ebf0f7'>团队名称</td>
							<td  width='90' align='center' bgcolor='#ebf0f7'>团队logo</td>
							<td align='center' bgcolor='#ebf0f7'>创建人</td>
							<td align='center' bgcolor='#ebf0f7'>联系电话</td>
							<td align='center' bgcolor='#ebf0f7'>邮箱</td>
							<td  width='65' align='center' bgcolor='#ebf0f7'>创建时间</td>

							<td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 操作 </td>--%>
							  <td align="center" bgcolor="#ebf0f7" width="3%" height="50">序号</td>
							  <td align='center' bgcolor='#ebf0f7' width="5%">团队帐号</td>
							  <td align='center' bgcolor='#ebf0f7' width="5%">密码</td>
							  <td align='center' bgcolor='#ebf0f7' width="7%">团队名称</td>
							  <td align='center' bgcolor='#ebf0f7' width="9%">团队logo</td>
							  <td align='center' bgcolor='#ebf0f7' width="7%">创建人</td>
							  <td align='center' bgcolor='#ebf0f7' width="7%">联系电话</td>
							   <td align='center' bgcolor='#ebf0f7' width="10%">邮箱</td>
							  <td align='center' bgcolor='#ebf0f7' width="6%">创建时间</td>

							  <td align='center' bgcolor='#ebf0f7' width="7%">是否审核</td>
							  <td height="50" align="center" bgcolor="#ebf0f7" width="8%"> 添加时间 </td>
							  <td height="50" align="center" bgcolor="#ebf0f7" width="8%"> 操作 </td>
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
                             <td>${u.tuanduizhanghao}</td>
							<td>${u.mima}</td>
							<td>${u.tuanduimingcheng}</td>
							<td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tuanduilogo}' target='_blank'><img src='${u.tuanduilogo}' width=88 height=99 border=0 /></a></td>
							<td>${u.chuangjianren}</td>
							<td>${u.lianxidianhua}</td>
							<td>${u.youxiang}</td>
							<td>${u.chuangjianshijian}</td>
    
    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=zhiyuantuandui'"/></td>
                              <td height="50" align="center" > ${u.addtime } </td>
                              <td height="50" align="center">
								  <%--<a class="btn btn-info btn-small" href="doUpdateZhiyuantuandui.do?id=${u.id }">编辑</a>--%>
								  <a class="btn btn-info btn-small" href="deleteZhiyuantuandui.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a>
								  <%--<a class="btn btn-info btn-small" href="zytdDetail.do?id=${u.id}" target="_blank">详细</a>--%></td>
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
              <a href="zhiyuantuanduiList.do?page=1" >首页</a>
             <a href="zhiyuantuanduiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zhiyuantuanduiList.do?page=${page.page+1 }">下一页</a>
			<a href="zhiyuantuanduiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>


	<%


		ResultSet RS_result;
		if (request.getSession().getAttribute("cx").equals("超级管理员")){
			String sql="";

			sql="select count(id) as gwegwg  from zhiyuantuandui where issh='否'";

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

		<div class="con">当前有<%=dd%>条志愿团队申请未审核！</div>




			<%
}
%>

	</body>
</html>
