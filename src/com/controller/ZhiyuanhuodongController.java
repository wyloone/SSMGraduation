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

import com.entity.Zhiyuanhuodong;
import com.server.ZhiyuanhuodongServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhiyuanhuodongController {
	@Resource
	private ZhiyuanhuodongServer zhiyuanhuodongService;


   
	@RequestMapping("addZhiyuanhuodong.do")
	public String addZhiyuanhuodong(HttpServletRequest request,Zhiyuanhuodong zhiyuanhuodong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhiyuanhuodong.setAddtime(time.toString().substring(0, 19));
		zhiyuanhuodongService.add(zhiyuanhuodong);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhiyuanhuodongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhiyuanhuodongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhiyuanhuodong.do")
	public String doUpdateZhiyuanhuodong(int id,ModelMap map,Zhiyuanhuodong zhiyuanhuodong){
		zhiyuanhuodong=zhiyuanhuodongService.getById(id);
		map.put("zhiyuanhuodong", zhiyuanhuodong);
		return "zhiyuanhuodong_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zhiyuanhuodongDetail.do")
	public String zhiyuanhuodongDetail(int id,ModelMap map,Zhiyuanhuodong zhiyuanhuodong){
		zhiyuanhuodong=zhiyuanhuodongService.getById(id);
		map.put("zhiyuanhuodong", zhiyuanhuodong);
		return "zhiyuanhuodong_detail";
	}
//	前台详细
	@RequestMapping("zyhdDetail.do")
	public String zyhdDetail(int id,ModelMap map,Zhiyuanhuodong zhiyuanhuodong){
		zhiyuanhuodong=zhiyuanhuodongService.getById(id);
		map.put("zhiyuanhuodong", zhiyuanhuodong);
		return "zhiyuanhuodongdetail";
	}
//	
	@RequestMapping("updateZhiyuanhuodong.do")
	public String updateZhiyuanhuodong(int id,ModelMap map,Zhiyuanhuodong zhiyuanhuodong,HttpServletRequest request,HttpSession session){
		zhiyuanhuodongService.update(zhiyuanhuodong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhiyuanhuodongList.do";
	}

//	分页查询
	@RequestMapping("zhiyuanhuodongList.do")
	public String zhiyuanhuodongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		//分页操作
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);

		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_list";
	}
	
	@RequestMapping("zhiyuanhuodong_yanben1.do")
	public String zhiyuanhuodong_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_yanben1";
	}
	@RequestMapping("zhiyuanhuodong_yanben2.do")
	public String zhiyuanhuodong_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_yanben2";
	}
	@RequestMapping("zhiyuanhuodong_yanben3.do")
	public String zhiyuanhuodong_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_yanben3";
	}
	@RequestMapping("zhiyuanhuodong_yanben4.do")
	public String zhiyuanhuodong_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_yanben4";
	}
	@RequestMapping("zhiyuanhuodong_yanben5.do")
	public String zhiyuanhuodong_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_yanben5";
	}
	
	@RequestMapping("zhiyuanhuodongList2.do")
	public String zhiyuanhuodongList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh,HttpServletRequest request){
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
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodong_list2";
	}
	
	
	@RequestMapping("zyhdList.do")
	public String zyhdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodonglist";
	}
	@RequestMapping("zyhdListtp.do")
	public String zyhdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhiyuanhuodong zhiyuanhuodong, String huodongmingcheng, String huodongkaishishijian1,String huodongkaishishijian2, String huodongjieshushijian1,String huodongjieshushijian2, String huodongneirong, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String chuangjianren, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian1==null||huodongkaishishijian1.equals("")){pmap.put("huodongkaishishijian1", null);}else{pmap.put("huodongkaishishijian1", huodongkaishishijian1);}
		if(huodongkaishishijian2==null||huodongkaishishijian2.equals("")){pmap.put("huodongkaishishijian2", null);}else{pmap.put("huodongkaishishijian2", huodongkaishishijian2);}
		if(huodongjieshushijian1==null||huodongjieshushijian1.equals("")){pmap.put("huodongjieshushijian1", null);}else{pmap.put("huodongjieshushijian1", huodongjieshushijian1);}
		if(huodongjieshushijian2==null||huodongjieshushijian2.equals("")){pmap.put("huodongjieshushijian2", null);}else{pmap.put("huodongjieshushijian2", huodongjieshushijian2);}
		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=zhiyuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuanhuodong> list=zhiyuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuanhuodonglisttp";
	}
	
	@RequestMapping("deleteZhiyuanhuodong.do")
	public String deleteZhiyuanhuodong(int id,HttpServletRequest request){
		zhiyuanhuodongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhiyuanhuodongList.do";
	}
	
	
}
