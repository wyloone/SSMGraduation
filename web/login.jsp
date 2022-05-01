<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<title>后台登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="images/css/font.css">
    <link rel="stylesheet" href="images/css/login.css">
	  <link rel="stylesheet" href="images/css/xadmin.css">
    <script type="text/javascript" src="images/js/jquery.min.js"></script>
    <script src="images/lib/layui/layui.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
	function hsgchecklogin() {
	if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script> 
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">管理登录</div>
        <div id="darkbannerwrap"></div>
        
		 <form name="f11" method="post" action="hsgloginyanzheng.jsp" class="layui-form" >
            <input name="username" id="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="pwd" id="pwd" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
			 <select name="cx" id="cx" >
			
			  <option value='志愿者'>志愿者</option>
             <option value='志愿团队'>志愿团队</option>
            <option value="管理员">管理员</option>


            </select>
            <hr class="hr15">
			<table><tr>
			
			<td><input name="pagerandom" id="pagerandom" placeholder="验证码"  type="text" lay-verify="required" class="layui-input" style="width:150px;" ></td><td>&nbsp;&nbsp;
			<%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
								   <%=yzm %></td>
			
			</tr></table>
			 
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit" onClick="return hsgchecklogin();">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {
            layui.use('form', function(){
              var form = layui.form;
              // layer.msg('玩命卖萌中', function(){
              //   //关闭后的操作
              //   });
              //监听提交
              form.on('submit(login)', function(data){
                // alert(888)
                document.form1.submit();
                return false;
              });
            });
        })
    </script>
    <!-- 底部结束 -->
    
</body>
</html>