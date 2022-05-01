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
		<title>志愿团队</title>

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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
	<div class="content">
		<div class="container">
		<div class="grids">
				<h4>志愿团队</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                     
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>团队帐号：</td><td width='39%'>${zhiyuantuandui.tuanduizhanghao}</td><td  rowspan=6 align=center><a href=${zhiyuantuandui.tuanduilogo} target=_blank><img src=${zhiyuantuandui.tuanduilogo}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>密码：</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>团队名称：</td><td width='39%'>${zhiyuantuandui.tuanduimingcheng}</td></tr><tr>                  <td width='11%' height=44>创建人：</td><td width='39%'>${zhiyuantuandui.chuangjianren}</td></tr><tr>         <td width='11%' height=44>联系电话：</td><td width='39%'>${zhiyuantuandui.lianxidianhua}</td></tr><tr>         <td width='11%' height=44>创建时间：</td><td width='39%'>${zhiyuantuandui.chuangjianshijian}</td></tr><tr>                  <td width='11%' height=100  >团队简介：</td><td width='39%' colspan=2 height=100 >${zhiyuantuandui.tuanduijianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回  class='hsgqiehuanshitu' onClick="javascript:history.back()" /><input type=button name=Submit52 value=打印 class='hsgqiehuanshitu' onClick="javascript:window.print()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>

