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
	<TITLE>加入团队查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<link rel="stylesheet" href="images/bootstrap.min.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body style="background: url(upload/back02.jpg)">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td style="font-size:25px; height: 50px" colspan="17" background="images/table_header.gif">加入团队列表</td>
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
								<form action="jiarutuanduiList3.do" name="myform" method="post">
									查询 <%--  志愿者账号：<input name="jiaruren" type="text" id="jiaruren" class="form-control2" /> --%>  志愿者姓名：<input name="zhiyuanzhexingming" type="text" id="zhiyuanzhexingming" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
                            <td width="3%" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7' width="10%">团队账号</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">团队名称</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">创建人</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">联系电话</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">志愿者账号</td>
							<td align='center' bgcolor='#ebf0f7' width="10%">志愿者姓名</td>
							<td align='center' bgcolor='#ebf0f7' width="9%">是否审核</td><td align='center' width="10%" bgcolor='#ebf0f7'>审核回复</td>
                            <td width="10%" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="8%" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
							<td>${u.tuanduizhanghao}</td>
							<td>${u.tuanduimingcheng}</td>
							<td>${u.chuangjianren}</td>
							<td>${u.lianxidianhua}</td>
							<td>${u.jiaruren}</td>
							<td>${u.zhiyuanzhexingming}</td>
							<td align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href="sh2.jsp?id=${u.id}&tablename=jiarutuandui">${u.issh}</a></td><td>${u.shhf}</td>
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center">
								  <a class="btn btn-info btn-small" href="deleteJiarutuandui.do?id=${u.id }" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a>
								  <%--<a class="btn btn-info btn-small" href="doUpdateJiarutuandui.do?id=${u.id }">编辑</a> --%>
								  <%--<a class="btn btn-info btn-small" href="jiarutuanduiDetail.do?id=${u.id }">详细</a>--%>
							  </td>
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
              <a href="jiarutuanduiList3.do?page=1" >首页</a>
             <a href="jiarutuanduiList3.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="jiarutuanduiList3.do?page=${page.page+1 }">下一页</a>
			<a href="jiarutuanduiList3.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>


	<%

		ResultSet RS_result;



		String sql="";
		sql="select count(id) as gwegwg  from jiarutuandui where issh='待审核' and tuanduizhanghao='"+request.getSession().getAttribute("username")+"'";

		RS_result=connDbBean.executeQuery(sql);
		String bb="";

		if(RS_result.next())
		{
			bb=RS_result.getString("gwegwg");


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

		<div class="con">当前有<%=bb%>条加入团队申请待审核！</div>

	</div>
	</body>
</html>
