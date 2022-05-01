<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE HTML>
<html>
	<head>
		<title>志愿者团队</title>

		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
		<script src="qtimages/js/bootstrap.min.js"></script>
		<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="./qtimages/sl_common_form.css">
		<style type="text/css">
			body,td,th {
				font-size: 15px;
			}
		</style>
	</head>
<%

  String id="";

   %>


	
	<script language="javascript">
function checkform()
{
	var tuanduizhanghaoobj = document.getElementById("tuanduizhanghao"); if(tuanduizhanghaoobj.value==""){document.getElementById("clabeltuanduizhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入团队帐号</font>";return false;}else{document.getElementById("clabeltuanduizhanghao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	
}
function gow()
{
	document.location.href="zhiyuanzhetuanduiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>志愿者团队</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
				<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
				<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
				<script src="images/hsgcommon/common.js"></script>
				<script src="images/hsgcommon/bootbox.js"></script>
<% 

%>
				<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
				<form action="addZhiyuanzhetuandui.do" name="form1" method="post">
				<tr ><td width="200">团队帐号：</td><td><input name='tuanduizhanghao' type='text' id='tuanduizhanghao' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeltuanduizhanghao' style='margin-top:16px;' /></td></tr>
				<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>
				<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
				<tr ><td width="200">团队logo：</td><td><input name='tuanduilogo' type='text' id='tuanduilogo' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tuanduilogo')"/></div></td></tr>
				<tr ><td width="200">创建人姓名：</td><td><input name='chuangjianrenxingming' type='text' id='chuangjianrenxingming' value='' onblur='' class="form-control" /></td></tr>
				<tr ><td width="200">创建时间：</td><td><input name='chuangjianshijian' type='text' id='chuangjianshijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
				<tr ><td width="200">团队简介：</td><td><textarea name='tuanduijianjie' cols='50' rows='5' id='tuanduijianjie' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="content-form-signup" />
						       <input type="reset" value="重置" class="content-form-signup" />&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 1050;</script>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
