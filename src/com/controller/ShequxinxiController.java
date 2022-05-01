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

import com.entity.Shequxinxi;
import com.server.ShequxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShequxinxiController {
	@Resource
	private ShequxinxiServer shequxinxiService;


   
	@RequestMapping("addShequxinxi.do")
	public String addShequxinxi(HttpServletRequest request,Shequxinxi shequxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shequxinxi.setAddtime(time.toString().substring(0, 19));
		shequxinxiService.add(shequxinxi);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shequxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shequxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShequxinxi.do")
	public String doUpdateShequxinxi(int id,ModelMap map,Shequxinxi shequxinxi){
		shequxinxi=shequxinxiService.getById(id);
		map.put("shequxinxi", shequxinxi);
		return "shequxinxi_updt";
	}
	

	
//	后台详细
	@RequestMapping("shequxinxiDetail.do")
	public String shequxinxiDetail(int id,ModelMap map,Shequxinxi shequxinxi){
		shequxinxi=shequxinxiService.getById(id);
		map.put("shequxinxi", shequxinxi);
		return "shequxinxi_detail";
	}
//	前台详细
	@RequestMapping("sqxxDetail.do")
	public String sqxxDetail(int id,ModelMap map,Shequxinxi shequxinxi){
		shequxinxi=shequxinxiService.getById(id);
		map.put("shequxinxi", shequxinxi);
		return "shequxinxidetail";
	}
//	

//	分页查询
	@RequestMapping("shequxinxiList.do")
	public String shequxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_list";
	}

	@RequestMapping("updateShequxinxi.do")
	public String updateShequxinxi(int id,ModelMap map,Shequxinxi shequxinxi,HttpServletRequest request,HttpSession session){
		shequxinxiService.update(shequxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		//return "redirect:shequxinxiList.do";
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shequxinxiList.do";
	}


	@RequestMapping("shequxinxi_yanben1.do")
	public String shequxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_yanben1";
	}


	@RequestMapping("shequxinxi_yanben2.do")
	public String shequxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_yanben2";
	}
	@RequestMapping("shequxinxi_yanben3.do")
	public String shequxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_yanben3";
	}

	@RequestMapping("shequxinxi_yanben4.do")
	public String shequxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_yanben4";
	}
	@RequestMapping("shequxinxi_yanben5.do")
	public String shequxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxi_yanben5";
	}
	
	
	
	@RequestMapping("sqxxList.do")
	public String sqxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxilist";
	}
	@RequestMapping("sqxxListtp.do")
	public String sqxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shequxinxi shequxinxi, String shequbianhao, String shequmingcheng, String shequzhaopian, String shequdianhua, String shequdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(shequbianhao==null||shequbianhao.equals("")){pmap.put("shequbianhao", null);}else{pmap.put("shequbianhao", shequbianhao);}
		if(shequmingcheng==null||shequmingcheng.equals("")){pmap.put("shequmingcheng", null);}else{pmap.put("shequmingcheng", shequmingcheng);}
		if(shequzhaopian==null||shequzhaopian.equals("")){pmap.put("shequzhaopian", null);}else{pmap.put("shequzhaopian", shequzhaopian);}
		if(shequdianhua==null||shequdianhua.equals("")){pmap.put("shequdianhua", null);}else{pmap.put("shequdianhua", shequdianhua);}
		if(shequdizhi==null||shequdizhi.equals("")){pmap.put("shequdizhi", null);}else{pmap.put("shequdizhi", shequdizhi);}
		
		int total=shequxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shequxinxi> list=shequxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shequxinxilisttp";
	}
	
	@RequestMapping("deleteShequxinxi.do")
	public String deleteShequxinxi(int id,HttpServletRequest request){
		shequxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shequxinxiList.do";
	}
	
	
}
