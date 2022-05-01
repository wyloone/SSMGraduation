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

import com.entity.Juanzengxinxi;
import com.server.JuanzengxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JuanzengxinxiController {
	@Resource
	private JuanzengxinxiServer juanzengxinxiService;


   
	@RequestMapping("addJuanzengxinxi.do")
	public String addJuanzengxinxi(HttpServletRequest request,Juanzengxinxi juanzengxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		juanzengxinxi.setAddtime(time.toString().substring(0, 19));
		juanzengxinxiService.add(juanzengxinxi);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "juanzengxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:juanzengxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJuanzengxinxi.do")
	public String doUpdateJuanzengxinxi(int id,ModelMap map,Juanzengxinxi juanzengxinxi){
		juanzengxinxi=juanzengxinxiService.getById(id);
		map.put("juanzengxinxi", juanzengxinxi);
		return "juanzengxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("juanzengxinxiDetail.do")
	public String juanzengxinxiDetail(int id,ModelMap map,Juanzengxinxi juanzengxinxi){
		juanzengxinxi=juanzengxinxiService.getById(id);
		map.put("juanzengxinxi", juanzengxinxi);
		return "juanzengxinxi_detail";
	}
//	前台详细
	@RequestMapping("jzxxDetail.do")
	public String jzxxDetail(int id,ModelMap map,Juanzengxinxi juanzengxinxi){
		juanzengxinxi=juanzengxinxiService.getById(id);
		map.put("juanzengxinxi", juanzengxinxi);
		return "juanzengxinxidetail";
	}
//	
	@RequestMapping("updateJuanzengxinxi.do")
	public String updateJuanzengxinxi(int id,ModelMap map,Juanzengxinxi juanzengxinxi,HttpServletRequest request,HttpSession session){
		juanzengxinxiService.update(juanzengxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:juanzengxinxiList.do";
	}

//	分页查询
	@RequestMapping("juanzengxinxiList.do")
	public String juanzengxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_list";
	}
	
	@RequestMapping("juanzengxinxi_yanben1.do")
	public String juanzengxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_yanben1";
	}
	@RequestMapping("juanzengxinxi_yanben2.do")
	public String juanzengxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_yanben2";
	}
	@RequestMapping("juanzengxinxi_yanben3.do")
	public String juanzengxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_yanben3";
	}
	@RequestMapping("juanzengxinxi_yanben4.do")
	public String juanzengxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_yanben4";
	}
	@RequestMapping("juanzengxinxi_yanben5.do")
	public String juanzengxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_yanben5";
	}
	
	@RequestMapping("juanzengxinxiList2.do")
	public String juanzengxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh,HttpServletRequest request){
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
		
		pmap.put("juanzengren", (String)request.getSession().getAttribute("username"));
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		
		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxi_list2";
	}	
	
	@RequestMapping("jzxxList.do")
	public String jzxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxilist";
	}
	@RequestMapping("jzxxListtp.do")
	public String jzxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Juanzengxinxi juanzengxinxi, String juanzengbianhao, String juanzengshijian1,String juanzengshijian2, String juanzengneirong, String wuzitupian, String juanzengren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(juanzengbianhao==null||juanzengbianhao.equals("")){pmap.put("juanzengbianhao", null);}else{pmap.put("juanzengbianhao", juanzengbianhao);}		if(juanzengshijian1==null||juanzengshijian1.equals("")){pmap.put("juanzengshijian1", null);}else{pmap.put("juanzengshijian1", juanzengshijian1);}		if(juanzengshijian2==null||juanzengshijian2.equals("")){pmap.put("juanzengshijian2", null);}else{pmap.put("juanzengshijian2", juanzengshijian2);}		if(juanzengneirong==null||juanzengneirong.equals("")){pmap.put("juanzengneirong", null);}else{pmap.put("juanzengneirong", juanzengneirong);}		if(wuzitupian==null||wuzitupian.equals("")){pmap.put("wuzitupian", null);}else{pmap.put("wuzitupian", wuzitupian);}		if(juanzengren==null||juanzengren.equals("")){pmap.put("juanzengren", null);}else{pmap.put("juanzengren", juanzengren);}		
		int total=juanzengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Juanzengxinxi> list=juanzengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "juanzengxinxilisttp";
	}
	
	@RequestMapping("deleteJuanzengxinxi.do")
	public String deleteJuanzengxinxi(int id,HttpServletRequest request){
		juanzengxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:juanzengxinxiList.do";
	}
	
	
}
