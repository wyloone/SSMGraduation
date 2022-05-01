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
		<TITLE>修改报名</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="baoming_add.jsp?id=<%=id%>";
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
			<form action="baomingList2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改报名<input type="hidden" name="id" value="${baoming.id}" /></td>
						</tr>
						<tr ><td width="200">活动名称：</td><td><input name='huodongmingcheng' type='text' id='huodongmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">活动开始时间：</td><td><input name='huodongkaishishijian' type='text' id='huodongkaishishijian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">活动结束时间：</td><td><input name='huodongjieshushijian' type='text' id='huodongjieshushijian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">活动地址：</td><td><input name='huodongdizhi' type='text' id='huodongdizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">团队账号：</td><td><input name='tuanduizhanghao' type='text' id='tuanduizhanghao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">报名人：</td><td><input name='baomingren' type='text' id='baomingren' value='' onblur='' class="form-control" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.huodongmingcheng.value='${baoming.huodongmingcheng}';</script>
	<script language="javascript">document.form1.huodongkaishishijian.value='${baoming.huodongkaishishijian}';</script>
	<script language="javascript">document.form1.huodongjieshushijian.value='${baoming.huodongjieshushijian}';</script>
	<script language="javascript">document.form1.huodongdizhi.value='${baoming.huodongdizhi}';</script>
	<script language="javascript">document.form1.tuanduizhanghao.value='${baoming.tuanduizhanghao}';</script>
	<script language="javascript">document.form1.tuanduimingcheng.value='${baoming.tuanduimingcheng}';</script>
	<script language="javascript">document.form1.lianxidianhua.value='${baoming.lianxidianhua}';</script>
	<script language="javascript">document.form1.baomingren.value='${baoming.baomingren}';</script>
	
					 </table>
			</form>
   </body>
</html>






