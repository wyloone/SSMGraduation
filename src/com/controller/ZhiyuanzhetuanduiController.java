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

import com.entity.Zhiyuanzhetuandui;
import com.server.ZhiyuanzhetuanduiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhiyuanzhetuanduiController {
	@Resource
	private ZhiyuanzhetuanduiServer zhiyuanzhetuanduiService;


   
	@RequestMapping("addZhiyuanzhetuandui.do")
	public String addZhiyuanzhetuandui(HttpServletRequest request,Zhiyuanzhetuandui zhiyuanzhetuandui,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhiyuanzhetuandui.setAddtime(time.toString().substring(0, 19));
		zhiyuanzhetuanduiService.add(zhiyuanzhetuandui);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhiyuanzhetuanduiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhiyuanzhetuanduiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhiyuanzhetuandui.do")
	public String doUpdateZhiyuanzhetuandui(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui){
		zhiyuanzhetuandui=zhiyuanzhetuanduiService.getById(id);
		map.put("zhiyuanzhetuandui", zhiyuanzhetuandui);
		return "zhiyuanzhetuandui_updt";
	}
	
	@RequestMapping("doUpdateZhiyuanzhetuandui2.do")
	public String doUpdateZhiyuanzhetuandui2(ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui,HttpServletRequest request){
		zhiyuanzhetuandui=zhiyuanzhetuanduiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuanzhetuandui", zhiyuanzhetuandui);
		return "zhiyuanzhetuandui_updt2";
	}
	
	@RequestMapping("doUpdateZhiyuanzhetuandui3.do")
	public String doUpdateZhiyuanzhetuandui3(ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui,HttpServletRequest request){
		zhiyuanzhetuandui=zhiyuanzhetuanduiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuanzhetuandui", zhiyuanzhetuandui);
		return "zhiyuanzhetuandui_updt3";
	}
	
	
	
	@RequestMapping("updateZhiyuanzhetuandui2.do")
		public String updateZhiyuanzhetuandui2(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui){
			zhiyuanzhetuanduiService.update(zhiyuanzhetuandui);
			return "redirect:doUpdateZhiyuanzhetuandui2.do";
		}

	@RequestMapping("updateZhiyuanzhetuandui3.do")
	public String updateZhiyuanzhetuandui3(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui){
		zhiyuanzhetuanduiService.update(zhiyuanzhetuandui);
		return "redirect:doUpdateZhiyuanzhetuandui3.do";
	}
	
	
	
//	后台详细
	@RequestMapping("zhiyuanzhetuanduiDetail.do")
	public String zhiyuanzhetuanduiDetail(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui){
		zhiyuanzhetuandui=zhiyuanzhetuanduiService.getById(id);
		map.put("zhiyuanzhetuandui", zhiyuanzhetuandui);
		return "zhiyuanzhetuandui_detail";
	}
//	前台详细
	@RequestMapping("zyztdDetail.do")
	public String zyztdDetail(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui){
		zhiyuanzhetuandui=zhiyuanzhetuanduiService.getById(id);
		map.put("zhiyuanzhetuandui", zhiyuanzhetuandui);
		return "zhiyuanzhetuanduidetail";
	}
//	
	@RequestMapping("updateZhiyuanzhetuandui.do")
	public String updateZhiyuanzhetuandui(int id,ModelMap map,Zhiyuanzhetuandui zhiyuanzhetuandui,HttpServletRequest request,HttpSession session){
		zhiyuanzhetuanduiService.update(zhiyuanzhetuandui);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhiyuanzhetuanduiList.do";
	}

//	分页查询
	@RequestMapping("zhiyuanzhetuanduiList.do")
	public String zhiyuanzhetuanduiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_list";
	}
	
	@RequestMapping("zhiyuanzhetuandui_yanben1.do")
	public String zhiyuanzhetuandui_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_yanben1";
	}
	@RequestMapping("zhiyuanzhetuandui_yanben2.do")
	public String zhiyuanzhetuandui_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_yanben2";
	}
	@RequestMapping("zhiyuanzhetuandui_yanben3.do")
	public String zhiyuanzhetuandui_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_yanben3";
	}
	@RequestMapping("zhiyuanzhetuandui_yanben4.do")
	public String zhiyuanzhetuandui_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_yanben4";
	}
	@RequestMapping("zhiyuanzhetuandui_yanben5.do")
	public String zhiyuanzhetuandui_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuandui_yanben5";
	}
	
	
	
	@RequestMapping("zyztdList.do")
	public String zyztdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuanduilist";
	}
	@RequestMapping("zyztdListtp.do")
	public String zyztdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanzhetuandui zhiyuanzhetuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianrenxingming, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianrenxingming==null||chuangjianrenxingming.equals("")){pmap.put("chuangjianrenxingming", null);}else{pmap.put("chuangjianrenxingming", chuangjianrenxingming);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		
		int total=zhiyuanzhetuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanzhetuandui> list=zhiyuanzhetuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanzhetuanduilisttp";
	}
	
	@RequestMapping("deleteZhiyuanzhetuandui.do")
	public String deleteZhiyuanzhetuandui(int id,HttpServletRequest request){
		zhiyuanzhetuanduiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhiyuanzhetuanduiList.do";
	}
	
	
}
