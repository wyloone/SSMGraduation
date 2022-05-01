<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!doctype html>
<html class="x-admin-sm">
    <head>
        <title>系统后台管理</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="images/css/font.css">
        <link rel="stylesheet" href="images/css/xadmin.css">
        <script src="images/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="images/js/xadmin.js"></script>
	</head>
    <body class="index">
        <div class="container">
            <div class="logo">
                <a href="">淮安市疫情防控志愿者管理系统</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">${sessionScope.username}[${sessionScope.cx}]</a>
                    <dl class="layui-nav-child">
                      <dd><a href="logout.jsp" target="_parent" >退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="index.do">前台首页</a></li>
            </ul>
        </div>
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                        <%
if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员")){%><jsp:include page="left_guanliyuan.jsp"></jsp:include><%}
if (request.getSession().getAttribute("cx").equals("志愿团队")){%><jsp:include page="left_zhiyuantuandui.jsp"></jsp:include><%}
if (request.getSession().getAttribute("cx").equals("志愿者")){%><jsp:include page="left_zhiyuanzhe.jsp"></jsp:include><%}
if (request.getSession().getAttribute("cx").equals("注册用户")){%><jsp:include page="left_zhuceyonghu.jsp"></jsp:include><%}

%>
                
                </ul>
            </div>
        </div>
       
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                       <%-- <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>--%>
                           <a href='main.jsp'/><i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='sy.jsp' id="hsgmain" name="hsgmain" frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
    </body>
</html>