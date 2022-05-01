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
		<TITLE>修改志愿者团队</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body>
			<form action="updateZhiyuanzhetuandui2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改志愿者团队<input type="hidden" name="id" value="${zhiyuanzhetuandui.id}" /></td>
						</tr>
						<tr ><td width="200">团队帐号：</td><td><input name='tuanduizhanghao' type='text' id='tuanduizhanghao' value='' onblur='checkform()' class="form-control" readonly='readonly' />&nbsp;*<label id='clabeltuanduizhanghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" readonly='readonly' />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		<tr ><td width="200">团队logo：</td><td><input name='tuanduilogo' type='text' id='tuanduilogo' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tuanduilogo')"/></div></td></tr>		<tr ><td width="200">创建人姓名：</td><td><input name='chuangjianrenxingming' type='text' id='chuangjianrenxingming' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">创建时间：</td><td><input name='chuangjianshijian' type='text' id='chuangjianshijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>		<tr ><td width="200">团队简介：</td><td><textarea name='tuanduijianjie' cols='50' rows='5' id='tuanduijianjie' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.tuanduizhanghao.value='${zhiyuanzhetuandui.tuanduizhanghao}';</script>	<script language="javascript">document.form1.mima.value='${zhiyuanzhetuandui.mima}';</script>	<script language="javascript">document.form1.tuanduimingcheng.value='${zhiyuanzhetuandui.tuanduimingcheng}';</script>	<script language="javascript">document.form1.tuanduilogo.value='${zhiyuanzhetuandui.tuanduilogo}';</script>	<script language="javascript">document.form1.chuangjianrenxingming.value='${zhiyuanzhetuandui.chuangjianrenxingming}';</script>	<script language="javascript">document.form1.chuangjianshijian.value='${zhiyuanzhetuandui.chuangjianshijian}';</script>	<script language="javascript">document.form1.tuanduijianjie.value='${zhiyuanzhetuandui.tuanduijianjie}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var tuanduizhanghaoobj = document.getElementById("tuanduizhanghao"); if(tuanduizhanghaoobj.value==""){document.getElementById("clabeltuanduizhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入团队帐号</font>";return false;}else{document.getElementById("clabeltuanduizhanghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
