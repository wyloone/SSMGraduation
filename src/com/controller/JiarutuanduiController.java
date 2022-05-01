package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Jiarutuandui;
import com.server.JiarutuanduiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiarutuanduiController {
	@Resource
	private JiarutuanduiServer jiarutuanduiService;


   
	@RequestMapping("addJiarutuandui.do")
	public String addJiarutuandui(HttpServletRequest request,Jiarutuandui jiarutuandui,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiarutuandui.setAddtime(time.toString().substring(0, 19));
		jiarutuanduiService.add(jiarutuandui);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiarutuanduiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiarutuanduiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiarutuandui.do")
	public String doUpdateJiarutuandui(int id,ModelMap map,Jiarutuandui jiarutuandui){
		jiarutuandui=jiarutuanduiService.getById(id);
		map.put("jiarutuandui", jiarutuandui);
		return "jiarutuandui_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiarutuanduiDetail.do")
	public String jiarutuanduiDetail(int id,ModelMap map,Jiarutuandui jiarutuandui){
		jiarutuandui=jiarutuanduiService.getById(id);
		map.put("jiarutuandui", jiarutuandui);
		return "jiarutuandui_detail";
	}
//	前台详细
	@RequestMapping("jrtdDetail.do")
	public String jrtdDetail(int id,ModelMap map,Jiarutuandui jiarutuandui){
		jiarutuandui=jiarutuanduiService.getById(id);
		map.put("jiarutuandui", jiarutuandui);
		return "jiarutuanduidetail";
	}
//	
	@RequestMapping("updateJiarutuandui.do")
	public String updateJiarutuandui(int id,ModelMap map,Jiarutuandui jiarutuandui,HttpServletRequest request,HttpSession session){
		jiarutuanduiService.update(jiarutuandui);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiarutuanduiList.do";
	}

//	分页查询
	@RequestMapping("jiarutuanduiList.do")
	public String jiarutuanduiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_list";
	}
	
	@RequestMapping("jiarutuandui_yanben1.do")
	public String jiarutuandui_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_yanben1";
	}
	@RequestMapping("jiarutuandui_yanben2.do")
	public String jiarutuandui_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_yanben2";
	}
	@RequestMapping("jiarutuandui_yanben3.do")
	public String jiarutuandui_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_yanben3";
	}
	@RequestMapping("jiarutuandui_yanben4.do")
	public String jiarutuandui_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_yanben4";
	}
	@RequestMapping("jiarutuandui_yanben5.do")
	public String jiarutuandui_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_yanben5";
	}
	
	@RequestMapping("jiarutuanduiList3.do")
	public String jiarutuanduiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("tuanduizhanghao", (String)request.getSession().getAttribute("username"));
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_list3";
	}	@RequestMapping("jiarutuanduiList2.do")
	public String jiarutuanduiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("jiaruren", (String)request.getSession().getAttribute("username"));
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuandui_list2";
	}	
	
	@RequestMapping("jrtdList.do")
	public String jrtdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuanduilist";
	}
	@RequestMapping("jrtdListtp.do")
	public String jrtdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarutuandui jiarutuandui, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String jiaruren, String zhiyuanzhexingming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiaruren==null||jiaruren.equals("")){pmap.put("jiaruren", null);}else{pmap.put("jiaruren", jiaruren);}		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}		
		int total=jiarutuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarutuandui> list=jiarutuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarutuanduilisttp";
	}
	
	@RequestMapping("deleteJiarutuandui.do")
	public String deleteJiarutuandui(int id,HttpServletRequest request){
		jiarutuanduiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiarutuanduiList.do";
	}
	
	
}
