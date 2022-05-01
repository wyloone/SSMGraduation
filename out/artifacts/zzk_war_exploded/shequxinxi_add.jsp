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
		<TITLE>添加社区信息</TITLE>
	    
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
	document.location.href="shequxinxi_add.jsp?id=<%=id%>";
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
	<body style="background: url(upload/back02.jpg)">
			<form action="addShequxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td style="font-size:25px; height: 50px" height="30" colspan="2" background="images/table_header.gif">添加社区信息</td>
						</tr>
						<tr ><td width="200">社区编号：</td><td><input name='shequbianhao' type='text' id='shequbianhao' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshequbianhao' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">社区名称：</td><td><input name='shequmingcheng' type='text' id='shequmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshequmingcheng' style='margin-top:16px;' /></td></tr>
		<tr ><td width="200">社区照片：</td><td><input name='shequzhaopian' type='text' id='shequzhaopian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('shequzhaopian')"/></div></td></tr>
		<tr ><td width="200">社区电话：</td><td><input name='shequdianhua' type='text' id='shequdianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshequdianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
		<tr ><td width="200">社区地址：</td><td><input name='shequdizhi' type='text' id='shequdizhi' value='' onblur='' class="form-control" /></td></tr>
		
		
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
 
 function checkform(){  
 
	var shequbianhaoobj = document.getElementById("shequbianhao"); if(shequbianhaoobj.value==""){document.getElementById("clabelshequbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入社区编号</font>";return false;}else{document.getElementById("clabelshequbianhao").innerHTML="  "; } 
	var shequmingchengobj = document.getElementById("shequmingcheng"); if(shequmingchengobj.value==""){document.getElementById("clabelshequmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入社区名称</font>";return false;}else{document.getElementById("clabelshequmingcheng").innerHTML="  "; } 
	var shequdianhuaobj = document.getElementById("shequdianhua"); if(shequdianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(shequdianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shequdianhuaobj.value)){document.getElementById("clabelshequdianhua").innerHTML=""; }else{document.getElementById("clabelshequdianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>