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
	<TITLE>修改密码</TITLE>

	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">

</head>


<body style="background: url(upload/back02.jpg)">
<form action="updateZhiyuanzhe2.do" name="form1" method="post">
	<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
		<tr bgcolor="#E7E7E7">
			<td style="font-size:25px; height: 50px" colspan="2" background="images/table_header.gif">修改密码<input type="hidden" name="id" value="${zhiyuanzhe.id}" /></td>
		</tr>
		<tr ><td width="200">志愿者账号：</td><td><input name='zhiyuanzhezhanghao' type='text' id='zhiyuanzhezhanghao' readonly value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelzhiyuanzhezhanghao' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>


		<tr align='center'   height="22">
			<td width="25%"  align="right">&nbsp;

			</td>
			<td width="75%"  align="left">
				<input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
				<input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
			</td>
		</tr>
		<script language="javascript">document.form1.zhiyuanzhezhanghao.value='${zhiyuanzhe.zhiyuanzhezhanghao}';</script>
		<script language="javascript">document.form1.mima.value='${zhiyuanzhe.mima}';</script>
		<script language="javascript">document.form1.zhiyuanzhexingming.value='${zhiyuanzhe.zhiyuanzhexingming}';</script>
		<script language="javascript">document.form1.xingbie.value='${zhiyuanzhe.xingbie}';</script>
		<script language="javascript">document.form1.nianling.value='${zhiyuanzhe.nianling}';</script>
		<script language="javascript">document.form1.shenfenzheng.value='${zhiyuanzhe.shenfenzheng}';</script>
		<script language="javascript">document.form1.youxiang.value='${zhiyuanzhe.youxiang}';</script>
		<script language="javascript">document.form1.dianhua.value='${zhiyuanzhe.dianhua}';</script>
		<script language="javascript">document.form1.dizhi.value='${zhiyuanzhe.dizhi}';</script>

	</table>
</form>
</body>
</html>



<!--hssgchesck-->


<script language=javascript >

	function checkform(){

		var zhiyuanzhezhanghaoobj = document.getElementById("zhiyuanzhezhanghao"); if(zhiyuanzhezhanghaoobj.value==""){document.getElementById("clabelzhiyuanzhezhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入志愿者账号</font>";return false;}else{document.getElementById("clabelzhiyuanzhezhanghao").innerHTML="  "; }
		var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; }
		var zhiyuanzhexingmingobj = document.getElementById("zhiyuanzhexingming"); if(zhiyuanzhexingmingobj.value==""){document.getElementById("clabelzhiyuanzhexingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入志愿者姓名</font>";return false;}else{document.getElementById("clabelzhiyuanzhexingming").innerHTML="  "; }
		var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}
		var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}
		var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}



		return true;
	}
	popheight=450;
</script>  
