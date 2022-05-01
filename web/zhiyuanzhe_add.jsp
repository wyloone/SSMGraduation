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
		<TITLE>添加志愿者</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
  id=request.getParameter("id");
   %>

<script language="javascript">

function gows()
{
	document.location.href="zhiyuanzhe_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addZhiyuanzhe.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加志愿者</td>
						</tr>
						<tr ><td width="200">志愿者账号：</td><td><input name='zhiyuanzhezhanghao' type='text' id='zhiyuanzhezhanghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelzhiyuanzhezhanghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">志愿者姓名：</td><td><input name='zhiyuanzhexingming' type='text' id='zhiyuanzhexingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelzhiyuanzhexingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200"><tr><td>性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshenfenzheng' style='margin-top:16px;' />必需身份证格式</td></tr>		<tr ><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelyouxiang' style='margin-top:16px;' />必需邮箱格式</td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeldianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var zhiyuanzhezhanghao = $("#zhiyuanzhezhanghao").val();
		if(zhiyuanzhezhanghao==""||(zhiyuanzhezhanghao.length<3||zhiyuanzhezhanghao.length>12)){
			 $("#clabelzhiyuanzhezhanghao").html("<font color=red>志愿者账号不能为空且长度在3～12位之间！</font>");
			 $("input[id=zhiyuanzhezhanghao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelzhiyuanzhezhanghao").html("");
			$.ajax({
				url : "quchongZhiyuanzhe.do",
				type : "post",
				data : "zhiyuanzhezhanghao=" + zhiyuanzhezhanghao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelzhiyuanzhezhanghao").html("<font color=red>志愿者账号已存在，请更换！</font>");
					$("input[id=zhiyuanzhezhanghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelzhiyuanzhezhanghao").html("系统异常，请检查错误！");
					$("input[id=zhiyuanzhezhanghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var zhiyuanzhezhanghaoobj = document.getElementById("zhiyuanzhezhanghao"); if(zhiyuanzhezhanghaoobj.value==""){document.getElementById("clabelzhiyuanzhezhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入志愿者账号</font>";return false;}else{document.getElementById("clabelzhiyuanzhezhanghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var zhiyuanzhexingmingobj = document.getElementById("zhiyuanzhexingming"); if(zhiyuanzhexingmingobj.value==""){document.getElementById("clabelzhiyuanzhexingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入志愿者姓名</font>";return false;}else{document.getElementById("clabelzhiyuanzhexingming").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}      var dianhuaobj = document.getElementById("dianhua"); if(dianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(dianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(dianhuaobj.value)){document.getElementById("clabeldianhua").innerHTML=""; }else{document.getElementById("clabeldianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>