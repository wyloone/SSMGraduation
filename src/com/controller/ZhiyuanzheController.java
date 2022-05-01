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

import com.entity.Zhiyuanzhe;
import com.server.ZhiyuanzheServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhiyuanzheController {
	@Resource
	private ZhiyuanzheServer zhiyuanzheService;


   
	@RequestMapping("addZhiyuanzhe.do")
	public String addZhiyuanzhe(HttpServletRequest request,Zhiyuanzhe zhiyuanzhe,HttpSession session) throws SQLException{
		//获取当前系统时间
		Timestamp time=new Timestamp(System.currentTimeMillis());
		zhiyuanzhe.setAddtime(time.toString().substring(0, 19));
		//调用添加语句
		zhiyuanzheService.add(zhiyuanzhe);
		db dbo = new db();
		//提示
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		//session.setAttribute("backurl", "zhiyuanzheList.do");
		return "redirect:postback.jsp";
		//return "redirect:zhiyuanzheList.do";
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhiyuanzhe.do")
	public String doUpdateZhiyuanzhe(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe){
		zhiyuanzhe=zhiyuanzheService.getById(id);
		map.put("zhiyuanzhe", zhiyuanzhe);
		return "zhiyuanzhe_updt";
	}
	
	@RequestMapping("doUpdateZhiyuanzhe2.do")
	public String doUpdateZhiyuanzhe2(ModelMap map,Zhiyuanzhe zhiyuanzhe,HttpServletRequest request){
		zhiyuanzhe=zhiyuanzheService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuanzhe", zhiyuanzhe);
		return "zhiyuanzhe_updt2";
	}
	
	
	@RequestMapping("doUpdateZhiyuanzhe3.do")
	public String doUpdateZhiyuanzhe3(ModelMap map,Zhiyuanzhe zhiyuanzhe,HttpServletRequest request){
		zhiyuanzhe=zhiyuanzheService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuanzhe", zhiyuanzhe);
		return "zhiyuanzhe_updt3";
	}
	
	@RequestMapping("updateZhiyuanzhe2.do")
	public String updateZhiyuanzhe2(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe){
		zhiyuanzheService.update(zhiyuanzhe);
		return "redirect:doUpdateZhiyuanzhe2.do";
	}
	
	
	
	@RequestMapping("updateZhiyuanzhe3.do")
	public String updateZhiyuanzhe3(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe){
		zhiyuanzheService.update(zhiyuanzhe);
		return "redirect:doUpdateZhiyuanzhe3.do";
	}
	
	
	
//	后台详细
	@RequestMapping("zhiyuanzheDetail.do")
	public String zhiyuanzheDetail(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe){
		zhiyuanzhe=zhiyuanzheService.getById(id);
		map.put("zhiyuanzhe", zhiyuanzhe);
		return "zhiyuanzhe_detail";
	}
//	前台详细
	@RequestMapping("zyzDetail.do")
	public String zyzDetail(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe){
		zhiyuanzhe=zhiyuanzheService.getById(id);
		map.put("zhiyuanzhe", zhiyuanzhe);
		return "zhiyuanzhedetail";
	}
//	
	@RequestMapping("updateZhiyuanzhe.do")
	public String updateZhiyuanzhe(int id,ModelMap map,Zhiyuanzhe zhiyuanzhe,HttpServletRequest request,HttpSession session){
		zhiyuanzheService.update(zhiyuanzhe);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhiyuanzheList.do";
	}

//	分页查询
	@RequestMapping("zhiyuanzheList.do")
	public String zhiyuanzheList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_list";
	}
	
	@RequestMapping("zhiyuanzhe_yanben1.do")
	public String zhiyuanzhe_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_yanben1";
	}
	@RequestMapping("zhiyuanzhe_yanben2.do")
	public String zhiyuanzhe_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_yanben2";
	}
	@RequestMapping("zhiyuanzhe_yanben3.do")
	public String zhiyuanzhe_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_yanben3";
	}
	@RequestMapping("zhiyuanzhe_yanben4.do")
	public String zhiyuanzhe_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_yanben4";
	}
	@RequestMapping("zhiyuanzhe_yanben5.do")
	public String zhiyuanzhe_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhe_yanben5";
	}
	
	
	
	@RequestMapping("zyzList.do")
	public String zyzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhelist";
	}
	@RequestMapping("zyzListtp.do")
	public String zyzListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhe zhiyuanzhe, String zhiyuanzhezhanghao, String mima, String zhiyuanzhexingming, String xingbie, String nianling, String shenfenzheng, String youxiang, String dianhua, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhiyuanzhezhanghao==null||zhiyuanzhezhanghao.equals("")){pmap.put("zhiyuanzhezhanghao", null);}else{pmap.put("zhiyuanzhezhanghao", zhiyuanzhezhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(zhiyuanzhexingming==null||zhiyuanzhexingming.equals("")){pmap.put("zhiyuanzhexingming", null);}else{pmap.put("zhiyuanzhexingming", zhiyuanzhexingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		int total=zhiyuanzheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhe> list=zhiyuanzheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhelisttp";
	}
	
	@RequestMapping("deleteZhiyuanzhe.do")
	public String deleteZhiyuanzhe(int id,HttpServletRequest request){
		zhiyuanzheService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhiyuanzheList.do";
	}
	
	@RequestMapping("quchongZhiyuanzhe.do")
	public void quchongZhiyuanzhe(Zhiyuanzhe zhiyuanzhe,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao());
		   System.out.println("zhiyuanzhezhanghao==="+zhiyuanzhe.getZhiyuanzhezhanghao());
		   System.out.println("zhiyuanzhezhanghao222==="+zhiyuanzheService.quchongZhiyuanzhe(map));
		   JSONObject obj=new JSONObject();
		   if(zhiyuanzheService.quchongZhiyuanzhe(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "志愿者账号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
