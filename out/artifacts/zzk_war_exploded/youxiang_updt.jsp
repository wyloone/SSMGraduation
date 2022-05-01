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
		<TITLE>修改邮件内容</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="zhengwen"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="youxiang_add.jsp?id=<%=id%>";
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
			<form action="updateYouxiang.do" name="form1" method="post">
				<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
					<tr bgcolor="#E7E7E7">
						<td style="font-size:25px; height: 50px" colspan="2" background="images/table_header.gif">修改邮箱<input type="hidden" name="id" value="${youxiang.id}" /></td>
					</tr>
						<tr ><td width="200">收件人：</td><td><input name='shoujianren' type='text' id='shoujianren' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshoujianren' style='margin-top:16px;' /></td></tr>
						<tr ><td width="200">发件人：</td><td><input name='fajianren' type='text' id='fajianren' onblur='checkform()' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelfajianren' style='margin-top:16px;' /></td></tr>
						<tr ><td width="200">标题：</td><td><input name='biaoti' type='text' id='biaoti' value='' onblur='' class="form-control" /></td></tr>
						<tr ><td width="200">正文：</td><td><textarea name="zhengwen" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shoujianren.value='${youxiang.shoujianren}';</script>
						<script language="javascript">document.form1.fajianren.value='${youxiang.fajianren}';</script>
						<script language="javascript">document.form1.biaoti.value='${youxiang.biaoti}';</script>
						<script language="javascript">document.form1.zhengwen.value='${youxiang.zhengwen}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shoujianrenobj = document.getElementById("shoujianren"); if(shoujianrenobj.value==""){document.getElementById("clabelshoujianren").innerHTML="&nbsp;&nbsp;<font color=red>请输入收件人</font>";return false;}else{document.getElementById("clabelshoujianren").innerHTML="  "; } 
	var fajianrenobj = document.getElementById("fajianren"); if(fajianrenobj.value==""){document.getElementById("clabelfajianren").innerHTML="&nbsp;&nbsp;<font color=red>请输入发件人</font>";return false;}else{document.getElementById("clabelfajianren").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
