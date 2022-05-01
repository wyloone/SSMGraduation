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
		<TITLE>修改志愿团队</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body style="background: url(upload/back02.jpg)">
			<form action="updateZhiyuantuandui2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td style="font-size:25px; height: 50px" height="20" colspan="2" background="images/table_header.gif">修改志愿团队<input type="hidden" name="id" value="${zhiyuantuandui.id}" /></td>
						</tr>
						<tr ><td width="200">团队帐号：</td><td><input name='tuanduizhanghao' type='text' readonly id='tuanduizhanghao' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeltuanduizhanghao' style='margin-top:16px;' /></td></tr>
						<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>
						<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>
						<tr ><td width="200">团队logo：</td><td><input name='tuanduilogo' type='text' id='tuanduilogo' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tuanduilogo')"/></div></td></tr>
						<tr ><td width="200">创建人：</td><td><input name='chuangjianren' type='text' id='chuangjianren' value='' onblur='' class="form-control" /></td></tr>
						<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabellianxidianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>
						<tr ><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelyouxiang' style='margin-top:16px;' />必需邮箱格式</td></tr>
						<tr ><td width="200">创建时间：</td><td><input name='chuangjianshijian' type='text' id='chuangjianshijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>
						<tr ><td width="200">团队简介：</td><td><textarea name='tuanduijianjie' cols='50' rows='5' id='tuanduijianjie' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.tuanduizhanghao.value='${zhiyuantuandui.tuanduizhanghao}';</script>
						<script language="javascript">document.form1.mima.value='${zhiyuantuandui.mima}';</script>
						<script language="javascript">document.form1.tuanduimingcheng.value='${zhiyuantuandui.tuanduimingcheng}';</script>
						<script language="javascript">document.form1.tuanduilogo.value='${zhiyuantuandui.tuanduilogo}';</script>
						<script language="javascript">document.form1.chuangjianren.value='${zhiyuantuandui.chuangjianren}';</script>
						<script language="javascript">document.form1.lianxidianhua.value='${zhiyuantuandui.lianxidianhua}';</script>
						<script language="javascript">document.form1.youxiang.value='${zhiyuantuandui.youxiang}';</script>
						<script language="javascript">document.form1.chuangjianshijian.value='${zhiyuantuandui.chuangjianshijian}';</script>
						<script language="javascript">document.form1.tuanduijianjie.value='${zhiyuantuandui.tuanduijianjie}';</script>
	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var tuanduizhanghaoobj = document.getElementById("tuanduizhanghao"); if(tuanduizhanghaoobj.value==""){document.getElementById("clabeltuanduizhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入团队帐号</font>";return false;}else{document.getElementById("clabeltuanduizhanghao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}  
    var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  
