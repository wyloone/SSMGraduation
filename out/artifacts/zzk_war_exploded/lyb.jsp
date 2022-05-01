<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML>
<html>
	<head>
		<title>在线留言</title>
		<link href="qtimages/css/styley.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="qtimages/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/responsiveslides.css">
		<script src="qtimages/js/jquery.min.js"></script>
		<script src="qtimages/js/responsiveslides.min.js"></script>
        <script src="qtimages/js/bootstrap.min.js"></script>
        <link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="./qtimages/sl_common_form.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <style type="text/css">
            body,td,th {
                font-size: 13px;
            }
        </style>
    </head>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>在线留言</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                        <form action="addLiuyanban.do" name="form1" method="post">
						<table width="100%" height="757" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" class="newsline" style="border-collapse:collapse">
						 
                            <tr>
                              <td width="12%">昵称：</td>
                              <td width="88%" align="left"><input name='cheng' type='text' id='cheng' value='' onblur='checkform()'  class="user" /> <label id='clabelcheng' />
                              *</td>
                            </tr>
                            <tr>
                              <td>头像：</td>
                              <td align="left"><input name="xingbie" type="radio" value="1" checked>
                                  <img src="img/1.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="2">
                                  <img src="img/2.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="3">
                                  <img src="img/3.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="4">
                                  <img src="img/4.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="5">
                              <img src="img/5.gif" width="64" height="71"></td>
                            </tr>
                            <tr>
                              <td>QQ：</td>
                              <td align="left"><input name='QQ' type='text' id='QQ' value='' class="user" /></td>
                            </tr>
                            <tr>
                              <td>邮箱：</td>
                              <td align="left"><input name='youxiang' type='text' id='youxiang' value='' class="user" onblur='checkform()' /> <label id='clabelyouxiang' />必需邮箱格式</td>
                            </tr>
                            <tr>
                              <td>手机：</td>
                              <td align="left"><input name='shouji' type='text' id='shouji' value='' class="user" onblur='checkform()' /> <label id='clabelshouji' /> 必需手机格式</td>
                            </tr>
                            <tr>
                              <td>内容：</td>
                              <td align="left"><textarea name="neirong" style="width:800px; height:120px;" id="neirong" class="user" onblur='checkform()'></textarea>
                              * <label id='clabelneirong' /> </td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td align="left"> <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="content-form-signup"/>
                              <input type="reset" name="Submit22" value="重置" class="content-form-signup"  /></td>
                            </tr>
                         
                   </table>
		        </form>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
	</body>
</html>
<script language=javascript >  
 function checkform(){  
	var chengobj = document.getElementById("cheng"); if(chengobj.value==""){document.getElementById("clabelcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入昵称</font>";return false;}else{document.getElementById("clabelcheng").innerHTML="  "; } 
	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}  
    var neirongobj = document.getElementById("neirong"); if(neirongobj.value==""){document.getElementById("clabelneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入内容</font>";return false;}else{document.getElementById("clabelneirong").innerHTML="  "; } 
return true;   
}   
popheight=450;
</script>