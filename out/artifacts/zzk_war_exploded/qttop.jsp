<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="header">
		<div class="container">
			<div class="logo">
					<a href="index.do">淮安市疫情防控志愿者管理系统</a>
			</div>
															
			<div class="top-search-social-nav2">
				<ul>
					<%if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){%>
					  <l1>
						  <a href="userlog.jsp"  style="font-size:14px;color:black" >登 录</a>
					  </l1>
					<%}else{ %>
					<li>
				  		<font color="#000000">当前用户： <%=request.getSession().getAttribute("username")%>,[<%=request.getSession().getAttribute("cx")%>]&nbsp;</font>
						<a href="logout.jsp" onclick="return confirm('确定要退出？')" style="color:#000000" >退出</a><font color="#000000">|</font><a href="main.jsp" style="color:#000000" >个人中心</a>
					</li>
					<%} %>
				</ul>
			</div>
														
			</div>
</div>
<div class="top-nav">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="nav_bg clearfix ">
  				<div class="container ">
            	<ul id="nav">
					<li><a href="index.do" style="font-size: 18px">网站首页</a></li>
					<li><a href="xwtzList.do?lb=疫情防控消息" style="font-size: 18px">疫情防控消息</a></li>
					<li><a href="zhiyuanzheadd.jsp" style="font-size: 18px">志愿者注册</a></li>
					<li><a href="zhiyuantuanduiadd.jsp" style="font-size: 18px">志愿团队注册</a></li>
                    <li><a href="sqxxListtp.do" style="font-size: 18px">社区信息</a></li>
                    <li><a href="zytdListtp.do" style="font-size: 18px">志愿团队</a></li>
                    <li><a href="zyhdList.do" style="font-size: 18px">志愿活动</a></li>
                    <li><a href="jzxxList.do" style="font-size: 18px">捐赠信息</a></li>
					<li><a class="hsubs" style="cursor:pointer;font-size: 18px" >在线留言</a>
                    <ul class="subs">
						<li><a href="lyb.jsp" style="font-size: 18px">在线留言</a></li> <li><a href="lybList.do" style="font-size: 18px">查看留言</a></li>
                    </ul>
                </li><!--yoxulixuyaxn-->
                <li><a href="login.jsp" style="font-size: 18px">后台管理</a></li>
                <div id="lavalamp"></div>
            </ul>
				</div>
			</div>
	    </div>
</div>