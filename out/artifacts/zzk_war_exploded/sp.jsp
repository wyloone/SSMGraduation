<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%


ResultSet RS_result;
if (request.getSession().getAttribute("cx").equals("超级管理员")){
	String sql="";
sql="select count(id) as gwegwg  from zhiyuanhuodong where issh='待审核'";

 RS_result=connDbBean.executeQuery(sql);
String aa="";

if(RS_result.next())
{
aa=RS_result.getString("gwegwg");


}
sql="select count(id) as gwegwg  from baoming where issh='待审核'";

RS_result=connDbBean.executeQuery(sql);
String bb="";

if(RS_result.next())
{
bb=RS_result.getString("gwegwg");


}

sql="select count(id) as gwegwg  from zhiyuanzhe where issh='否'";

RS_result=connDbBean.executeQuery(sql);
String cc="";

if(RS_result.next())
{
cc=RS_result.getString("gwegwg");


}

sql="select count(id) as gwegwg  from zhiyuantuandui where issh='否'";

RS_result=connDbBean.executeQuery(sql);
String dd="";

if(RS_result.next())
{
dd=RS_result.getString("gwegwg");


}




%>














<style>
#winpop { width:200px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #666; margin:0; padding:1px; overflow:hidden; display:none;} 
#winpop .title { width:100%; height:22px; line-height:20px; background:#FFCC00; font-weight:bold; text-align:center; font-size:12px;} 
#winpop .con { width:100%; height:90px; line-height:20px; font-weight:bold; font-size:12px; color:#FF0000; text-align:center} 
#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;} 
.close { position:absolute; right:4px; top:-1px; color:#FFF; cursor:pointer} 
</style> 
<script type="text/javascript"> 
function tips_pop(){ 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height);//将对象的高度转化为数字 
if (popH==0){ 
MsgPop.style.display="block";//显示隐藏的窗口 
show=setInterval("changeH('up')",2); 
} 
else { 
hide=setInterval("changeH('down')",2); 
} 
} 
function changeH(str) { 
var MsgPop=document.getElementById("winpop"); 
var popH=parseInt(MsgPop.style.height); 
if(str=="up"){ 
if (popH <=100){ 
MsgPop.style.height=(popH+4).toString()+"px"; 
} 
else{ 
clearInterval(show); 
} 
} 
if(str=="down"){ 
if (popH>=4){ 
MsgPop.style.height=(popH-4).toString()+"px"; 
} 
else{ 
clearInterval(hide);  
MsgPop.style.display="none"; //隐藏DIV 
} 
} 
} 
window.onload=function(){ //加载 
document.getElementById('winpop').style.height='0px'; 
setTimeout("tips_pop()",500); //3秒后调用tips_pop()这个函数 
} 
</script> <div id="silu"> 
<body>
</div> 
<div id="winpop"> 
<div class="title">系统提醒！ <span class="close" onClick="tips_pop()">X </span> </div> 

<div class="con">当前有<%=aa%>条活动信息待审核，<%=bb%>条报名待审核，<%=cc%>条志愿者未审核，<%=dd%>条支援团队未审核谢谢！</div>




<%
}
%>

















</BODY>
</html>

