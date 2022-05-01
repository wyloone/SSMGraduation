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
		<title>报名</title>

		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
<script src="qtimages/js/bootstrap.min.js"></script>
<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./qtimages/sl_common_form.css">
	</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	
}
function gow()
{
	document.location.href="baomingadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>报名</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                     <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addBaoming.do" name="form1" method="post">
						<tr ><td width="200">活动名称：</td><td><input name='huodongmingcheng' type='text' id='huodongmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.huodongmingcheng.value='<%=connDbBean.readzd("zhiyuanhuodong","huodongmingcheng","id",request.getParameter("id"))%>';document.form1.huodongmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">活动开始时间：</td><td><input name='huodongkaishishijian' type='text' id='huodongkaishishijian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.huodongkaishishijian.value='<%=connDbBean.readzd("zhiyuanhuodong","huodongkaishishijian","id",request.getParameter("id"))%>';document.form1.huodongkaishishijian.setAttribute("readOnly",'true');</script>		<tr ><td width="200">活动结束时间：</td><td><input name='huodongjieshushijian' type='text' id='huodongjieshushijian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.huodongjieshushijian.value='<%=connDbBean.readzd("zhiyuanhuodong","huodongjieshushijian","id",request.getParameter("id"))%>';document.form1.huodongjieshushijian.setAttribute("readOnly",'true');</script>		<tr ><td width="200">活动地址：</td><td><input name='huodongdizhi' type='text' id='huodongdizhi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.huodongdizhi.value='<%=connDbBean.readzd("zhiyuanhuodong","huodongdizhi","id",request.getParameter("id"))%>';document.form1.huodongdizhi.setAttribute("readOnly",'true');</script>		<tr ><td width="200">团队账号：</td><td><input name='tuanduizhanghao' type='text' id='tuanduizhanghao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.tuanduizhanghao.value='<%=connDbBean.readzd("zhiyuanhuodong","tuanduizhanghao","id",request.getParameter("id"))%>';document.form1.tuanduizhanghao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">团队名称：</td><td><input name='tuanduimingcheng' type='text' id='tuanduimingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.tuanduimingcheng.value='<%=connDbBean.readzd("zhiyuanhuodong","tuanduimingcheng","id",request.getParameter("id"))%>';document.form1.tuanduimingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("zhiyuanhuodong","lianxidianhua","id",request.getParameter("id"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>		<tr ><td width="200">报名人：</td><td><input name='baomingren' type='text' id='baomingren' value='<%=(String)request.getSession().getAttribute("username")%>' onblur='' class="form-control" readonly='readonly' /></td></tr>		
		
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
