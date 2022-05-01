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
		<TITLE>添加加入团队</TITLE>
	    
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
	document.location.href="jiarutuandui_add.jsp?id=<%=id%>";
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
			<form action="addJiarutuandui.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加加入团队</td>
						</tr>
						<tr ><td width="200">团队账号：</td><td><input name='tuanduizhanghao' type='text' id='tuanduizhanghao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.tuanduizhanghao.value='<%=connDbBean.readzd("zhiyuantuandui","tuanduizhanghao","id",request.getParameter("id"))%>';document.form1.tuanduizhanghao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.tuanduimingcheng.value='<%=connDbBean.readzd("zhiyuantuandui","tuanduimingcheng","id",request.getParameter("id"))%>';document.form1.tuanduimingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">创建人：</td><td><input name='chuangjianren' type='text' id='chuangjianren' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.chuangjianren.value='<%=connDbBean.readzd("zhiyuantuandui","chuangjianren","id",request.getParameter("id"))%>';document.form1.chuangjianren.setAttribute("readOnly",'true');</script>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("zhiyuantuandui","lianxidianhua","id",request.getParameter("id"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>		<tr ><td width="200">加入人：</td><td><input name='jiaruren' type='text' id='jiaruren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">志愿者姓名：</td><td><input name='zhiyuanzhexingming' type='text' id='zhiyuanzhexingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.zhiyuanzhexingming.value='<%=connDbBean.readzd("zhiyuanzhe","zhiyuanzhexingming","jiaruren",(String)request.getSession().getAttribute("username"))%>';document.form1.zhiyuanzhexingming.setAttribute("readOnly",'true');</script>		
		
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






<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>