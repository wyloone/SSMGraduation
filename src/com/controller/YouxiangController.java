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

import com.entity.Youxiang;
import com.server.YouxiangServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YouxiangController {
	@Resource
	private YouxiangServer youxiangService;


   
	@RequestMapping("addYouxiang.do")
	public String addYouxiang(HttpServletRequest request,Youxiang youxiang,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		youxiang.setAddtime(time.toString().substring(0, 19));
		youxiangService.add(youxiang);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "youxiangList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:youxiangList.do";
	}
 
//	处理编辑
	@RequestMapping("doUpdateYouxiang.do")
	public String doUpdateYouxiang(int id,ModelMap map,Youxiang youxiang){
		youxiang=youxiangService.getById(id);
		map.put("youxiang", youxiang);
		return "youxiang_updt";
	}

	
//	后台详细
	@RequestMapping("youxiangDetail.do")
	public String youxiangDetail(int id,ModelMap map,Youxiang youxiang){
		youxiang=youxiangService.getById(id);
		map.put("youxiang", youxiang);
		return "youxiang_detail";
	}
//	前台详细
	@RequestMapping("yxDetail.do")
	public String yxDetail(int id,ModelMap map,Youxiang youxiang){
		youxiang=youxiangService.getById(id);
		map.put("youxiang", youxiang);
		return "youxiangdetail";
	}
//	
	@RequestMapping("updateYouxiang.do")
	public String updateYouxiang(int id,ModelMap map,Youxiang youxiang,HttpServletRequest request,HttpSession session){
		youxiangService.update(youxiang);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:youxiangList.do";
	}

//	分页查询
	@RequestMapping("youxiangList.do")
	public String youxiangList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		
		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_list";
	}

	//已发送邮件列表
	@RequestMapping("youxiangList2.do")
	public String youxiangList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		//分页操作
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);

		//获取当前登录用户的邮箱
		pmap.put("fajianren", (String)request.getSession().getAttribute("aaa"));
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		
		//调用查询语句
		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_list2";
	}
	
	
	@RequestMapping("youxiangList3.do")
	public String youxiangList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen,HttpServletRequest request){
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
		
		pmap.put("shoujianren", (String)request.getSession().getAttribute("aaa"));
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		
		
		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_list3";
	}
	
	
	
	
	
	@RequestMapping("yxList.do")
	public String yxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		
		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxianglist";
	}
	@RequestMapping("yxListtp.do")
	public String yxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}
		
		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxianglisttp";
	}
	
	@RequestMapping("deleteYouxiang.do")
	public String deleteYouxiang(int id,HttpServletRequest request){
		youxiangService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:youxiangList.do";
	}

/*	@RequestMapping("youxiang_yanben1.do")
	public String youxiang_yanben1(@RequestParam(value="page",required=false)String page,
								   ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);


		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}

		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_yanben1";
	}
	@RequestMapping("youxiang_yanben2.do")
	public String youxiang_yanben2(@RequestParam(value="page",required=false)String page,
								   ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);


		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}

		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_yanben2";
	}
	@RequestMapping("youxiang_yanben3.do")
	public String youxiang_yanben3(@RequestParam(value="page",required=false)String page,
								   ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);


		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}

		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_yanben3";
	}
	@RequestMapping("youxiang_yanben4.do")
	public String youxiang_yanben4(@RequestParam(value="page",required=false)String page,
								   ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);


		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}

		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_yanben4";
	}
	@RequestMapping("youxiang_yanben5.do")
	public String youxiang_yanben5(@RequestParam(value="page",required=false)String page,
								   ModelMap map,HttpSession session,Youxiang youxiang, String shoujianren, String fajianren, String biaoti, String zhengwen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);


		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(zhengwen==null||zhengwen.equals("")){pmap.put("zhengwen", null);}else{pmap.put("zhengwen", zhengwen);}

		int total=youxiangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youxiang> list=youxiangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youxiang_yanben5";
	}*/
	
}
