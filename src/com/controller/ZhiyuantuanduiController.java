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

import com.entity.Zhiyuantuandui;
import com.server.ZhiyuantuanduiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhiyuantuanduiController {
	@Resource
	private ZhiyuantuanduiServer zhiyuantuanduiService;



	@RequestMapping("addZhiyuantuandui.do")
	public String addZhiyuantuandui(HttpServletRequest request,Zhiyuantuandui zhiyuantuandui,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());

		zhiyuantuandui.setAddtime(time.toString().substring(0, 19));
		zhiyuantuanduiService.add(zhiyuantuandui);
		db dbo = new db();

		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));

		//session.setAttribute("backurl", "zhiyuantuanduiList.do");

		return "redirect:postback.jsp";
		//return "redirect:zhiyuantuanduiList.do";



	}

	//	处理编辑
	@RequestMapping("doUpdateZhiyuantuandui.do")
	public String doUpdateZhiyuantuandui(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui){
		zhiyuantuandui=zhiyuantuanduiService.getById(id);
		map.put("zhiyuantuandui", zhiyuantuandui);
		return "zhiyuantuandui_updt";
	}


	@RequestMapping("doUpdateZhiyuantuandui3.do")
	public String doUpdateZhiyuantuandui3(ModelMap map,Zhiyuantuandui zhiyuantuandui,HttpServletRequest request){
		zhiyuantuandui=zhiyuantuanduiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuantuandui", zhiyuantuandui);
		return "zhiyuanzhetuandui_updt3";
	}

	@RequestMapping("updateZhiyuantuandui3.do")
	public String updateZhiyuantuandui3(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui){
		zhiyuantuanduiService.update(zhiyuantuandui);
		return "redirect:doUpdateZhiyuantuandui3.do";
	}



	@RequestMapping("doUpdateZhiyuantuandui2.do")
	public String doUpdateZhiyuantuandui2(ModelMap map,Zhiyuantuandui zhiyuantuandui,HttpServletRequest request){
		zhiyuantuandui=zhiyuantuanduiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhiyuantuandui", zhiyuantuandui);
		return "zhiyuantuandui_updt2";
	}

	@RequestMapping("updateZhiyuantuandui2.do")
	public String updateZhiyuantuandui2(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui){
		zhiyuantuanduiService.update(zhiyuantuandui);
		return "redirect:doUpdateZhiyuantuandui2.do";
	}

	//	后台详细
	@RequestMapping("zhiyuantuanduiDetail.do")
	public String zhiyuantuanduiDetail(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui){
		zhiyuantuandui=zhiyuantuanduiService.getById(id);
		map.put("zhiyuantuandui", zhiyuantuandui);
		return "zhiyuantuandui_detail";
	}
	//	前台详细
	@RequestMapping("zytdDetail.do")
	public String zytdDetail(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui){
		zhiyuantuandui=zhiyuantuanduiService.getById(id);
		map.put("zhiyuantuandui", zhiyuantuandui);
		return "zhiyuantuanduidetail";
	}
	//
	@RequestMapping("updateZhiyuantuandui.do")
	public String updateZhiyuantuandui(int id,ModelMap map,Zhiyuantuandui zhiyuantuandui,HttpServletRequest request,HttpSession session){
		zhiyuantuanduiService.update(zhiyuantuandui);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhiyuantuanduiList.do";
	}

	//	分页查询
	@RequestMapping("zhiyuantuanduiList.do")
	public String zhiyuantuanduiList(@RequestParam(value="page",required=false)String page,
									 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_list";
	}

	@RequestMapping("zhiyuantuandui_yanben1.do")
	public String zhiyuantuandui_yanben1(@RequestParam(value="page",required=false)String page,
										 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_yanben1";
	}
	@RequestMapping("zhiyuantuandui_yanben2.do")
	public String zhiyuantuandui_yanben2(@RequestParam(value="page",required=false)String page,
										 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_yanben2";
	}
	@RequestMapping("zhiyuantuandui_yanben3.do")
	public String zhiyuantuandui_yanben3(@RequestParam(value="page",required=false)String page,
										 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_yanben3";
	}
	@RequestMapping("zhiyuantuandui_yanben4.do")
	public String zhiyuantuandui_yanben4(@RequestParam(value="page",required=false)String page,
										 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_yanben4";
	}
	@RequestMapping("zhiyuantuandui_yanben5.do")
	public String zhiyuantuandui_yanben5(@RequestParam(value="page",required=false)String page,
										 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuandui_yanben5";
	}



	@RequestMapping("zytdList.do")
	public String zytdList(@RequestParam(value="page",required=false)String page,
						   ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
		//分页操作
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		//进行判空和匹配操作
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(tuanduilogo==null||tuanduilogo.equals("")){pmap.put("tuanduilogo", null);}else{pmap.put("tuanduilogo", tuanduilogo);}
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}
		//调用查询语句
		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuanduilist";
	}
	@RequestMapping("zytdListtp.do")
	public String zytdListtp(@RequestParam(value="page",required=false)String page,
							 ModelMap map,HttpSession session,Zhiyuantuandui zhiyuantuandui, String tuanduizhanghao, String mima, String tuanduimingcheng, String tuanduilogo, String chuangjianren, String lianxidianhua, String youxiang, String chuangjianshijian1,String chuangjianshijian2, String tuanduijianjie, String issh){
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
		if(chuangjianren==null||chuangjianren.equals("")){pmap.put("chuangjianren", null);}else{pmap.put("chuangjianren", chuangjianren);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(tuanduijianjie==null||tuanduijianjie.equals("")){pmap.put("tuanduijianjie", null);}else{pmap.put("tuanduijianjie", tuanduijianjie);}

		int total=zhiyuantuanduiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhiyuantuandui> list=zhiyuantuanduiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhiyuantuanduilisttp";
	}

	@RequestMapping("deleteZhiyuantuandui.do")
	public String deleteZhiyuantuandui(int id,HttpServletRequest request){
		zhiyuantuanduiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhiyuantuanduiList.do";
	}


}
