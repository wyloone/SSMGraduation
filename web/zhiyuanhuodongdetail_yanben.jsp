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
		<title>־Ը�</title>

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
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'��������',550,250) ;
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
				<h4>־Ը�</h4><h5> </h5><div class="clearfix"> </div>
				<div class="content-form">
					
                   
                     
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%'>����ƣ�</td><td width='39%'>${zhiyuanhuodong.huodongmingcheng}</td>     <td width='11%'>���ʼʱ�䣺</td><td width='39%'>${zhiyuanhuodong.huodongkaishishijian}</td></tr><tr>     <td width='11%'>�����ʱ�䣺</td><td width='39%'>${zhiyuanhuodong.huodongjieshushijian}</td>     <td width='11%'>����ݣ�</td><td width='39%'>${zhiyuanhuodong.huodongneirong}</td></tr><tr>     <td width='11%'>���ַ��</td><td width='39%'>${zhiyuanhuodong.huodongdizhi}</td>     <td width='11%'>�Ŷ��˺ţ�</td><td width='39%'>${zhiyuanhuodong.tuanduizhanghao}</td></tr><tr>     <td width='11%'>�Ŷ����ƣ�</td><td width='39%'>${zhiyuanhuodong.tuanduimingcheng}</td>     <td width='11%'>�����ˣ�</td><td width='39%'>${zhiyuanhuodong.chuangjianren}</td></tr><tr>     <td width='11%'>��ϵ�绰��</td><td width='39%'>${zhiyuanhuodong.lianxidianhua}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=���� class='hsgqiehuanshitu' onClick="javascript:history.back()" /><input type=button name=Submit52 value=��ӡ class='hsgqiehuanshitu' onClick="javascript:window.print()"  /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
                     
				
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>

