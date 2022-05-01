<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<html>
	<head>
		<title>用户注册</title>
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
	
<script language=javascript >  
function hsgcheck() {
		var yonghuming = $("#yonghuming").val();
		if(yonghuming==""||(yonghuming.length<3||yonghuming.length>12)){
			 $("#clabelyonghuming").html("<font color=red>用户名不能为空且长度在3～12位之间！</font>");
			 $("input[id=yonghuming]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelyonghuming").html("");
			$.ajax({
				url : "quchongYonghuzhuce.do",
				type : "post",
				data : "yonghuming=" + yonghuming,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelyonghuming").html("<font color=red>用户名已存在，请更换！</font>");
					$("input[id=yonghuming]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelyonghuming").html("系统异常，请检查错误！");
					$("input[id=yonghuming]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
	<script language="javascript">
function checkform()
{
	var yonghumingobj = document.getElementById("yonghuming"); if(yonghumingobj.value==""){document.getElementById("clabelyonghuming").innerHTML="&nbsp;&nbsp;<font color=red>请输入用户名</font>";return false;}else{document.getElementById("clabelyonghuming").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){if(/^1[3|4|5|6|7|8|9][0-9]\d{4,8}$/.test(shoujiobj.value) ||  /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机(11位)或电话(7或8位数)格式</font>"; return false;}}  
    var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}  
    
}

</script>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>用户注册</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                     <form action="addYonghuzhuce.do" name="form1" method="post">
				      <table width="100%" height="797" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" class="newsline" style="border-collapse:collapse">
						
						<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='hsgcheck()' class="user" />&nbsp;*<label id='clabelyonghuming' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="password" />&nbsp;*<label id='clabelmima' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' class="user" />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="xingbie"><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr ><td width="200">出生年月：</td><td><input name='chushengnianyue' type='text' id='chushengnianyue' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="password" /></td></tr>
		<tr ><td width="200">QQ：</td><td><input name='QQ' type='text' id='QQ' value='' onblur='' class="user" /></td></tr>
		<tr ><td width="200">邮箱：</td><td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' class="user" />&nbsp;<label id='clabelyouxiang' />必需邮箱格式</td></tr>
		<tr ><td width="200">手机：</td><td><input name='shouji' type='text' id='shouji' value='' onblur='checkform()' class="user" />&nbsp;<label id='clabelshouji' />必需手机格式</td></tr>
		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="user" />&nbsp;<label id='clabelshenfenzheng' />必需身份证格式</td></tr>
		<tr 0><td width="200">头像：</td><td><input name='touxiang' type='text' id='touxiang' size='50' value='' onblur='' class="user" />&nbsp;<input type='button' value='上传' onClick="up('touxiang')" class="content-form-signup" /></td></tr>
		<tr 1><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' class="user" /></td></tr>
		<tr 2><td width="200">备注：</td><td><textarea name='beizhu'  id='beizhu' onblur='' class="user"  ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="content-form-signup" />
						       <input type="reset" value="重置" class="content-form-signup" />&nbsp;
						    </td>
						</tr>
		   </table>
	</form>
			<script language="javascript">popheight = 1150;</script>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
	</body>
</html>