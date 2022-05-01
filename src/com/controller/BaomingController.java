package com.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Baoming;
import com.server.BaomingServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;

@Controller
public class BaomingController {
	@Resource
	private BaomingServer baomingService;


   
	@RequestMapping("addBaoming.do")
	public String addBaoming(HttpServletRequest request,Baoming baoming,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		baoming.setAddtime(time.toString().substring(0, 19));
		baomingService.add(baoming);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "baomingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:baomingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBaoming.do")
	public String doUpdateBaoming(int id,ModelMap map,Baoming baoming){
		baoming=baomingService.getById(id);
		map.put("baoming", baoming);
		return "baoming_updt";
	}

	/**
	 * 导出商品信息表
	 */
	/*@RequestMapping("/template")
	public void printExcelTemplate(HttpServletResponse response, HttpSession session){
		//查询示例数据
		List<Baoming> list=baomingService.getBaomingByName();
		try{
			ExcelUtils.printEasyExcelTemplate(list,"goodsInfo-template",response,session);
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	
	
	
//	后台详细
	@RequestMapping("baomingDetail.do")
	public String baomingDetail(int id,ModelMap map,Baoming baoming){
		baoming=baomingService.getById(id);
		map.put("baoming", baoming);
		return "baoming_detail";
	}
//	前台详细
	@RequestMapping("bmDetail.do")
	public String bmDetail(int id,ModelMap map,Baoming baoming){
		baoming=baomingService.getById(id);
		map.put("baoming", baoming);
		return "baomingdetail";
	}
//	
	@RequestMapping("updateBaoming.do")
	public String updateBaoming(int id,ModelMap map,Baoming baoming,HttpServletRequest request,HttpSession session){
		baomingService.update(baoming);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:baomingList.do";
	}

//	分页查询
	@RequestMapping("baomingList.do")
	public String baomingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_list";
	}
	
	@RequestMapping("baoming_yanben1.do")
	public String baoming_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_yanben1";
	}
	@RequestMapping("baoming_yanben2.do")
	public String baoming_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_yanben2";
	}
	@RequestMapping("baoming_yanben3.do")
	public String baoming_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_yanben3";
	}
	@RequestMapping("baoming_yanben4.do")
	public String baoming_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_yanben4";
	}
	@RequestMapping("baoming_yanben5.do")
	public String baoming_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_yanben5";
	}
	
	@RequestMapping("baomingList2.do")
	public String baomingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh,HttpServletRequest request){
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
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_list2";
	}
	@RequestMapping("baomingList3.do")
	public String baomingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh,HttpServletRequest request){
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
		
		pmap.put("baomingren", (String)request.getSession().getAttribute("username"));
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baoming_list3";
	}
	
	
	@RequestMapping("bmList.do")
	public String bmList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baominglist";
	}
	@RequestMapping("bmListtp.do")
	public String bmListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baoming baoming, String huodongmingcheng, String huodongkaishishijian, String huodongjieshushijian, String huodongdizhi, String tuanduizhanghao, String tuanduimingcheng, String lianxidianhua, String baomingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}
		if(huodongkaishishijian==null||huodongkaishishijian.equals("")){pmap.put("huodongkaishishijian", null);}else{pmap.put("huodongkaishishijian", huodongkaishishijian);}
		if(huodongjieshushijian==null||huodongjieshushijian.equals("")){pmap.put("huodongjieshushijian", null);}else{pmap.put("huodongjieshushijian", huodongjieshushijian);}
		if(huodongdizhi==null||huodongdizhi.equals("")){pmap.put("huodongdizhi", null);}else{pmap.put("huodongdizhi", huodongdizhi);}
		if(tuanduizhanghao==null||tuanduizhanghao.equals("")){pmap.put("tuanduizhanghao", null);}else{pmap.put("tuanduizhanghao", tuanduizhanghao);}
		if(tuanduimingcheng==null||tuanduimingcheng.equals("")){pmap.put("tuanduimingcheng", null);}else{pmap.put("tuanduimingcheng", tuanduimingcheng);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}
		
		int total=baomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baoming> list=baomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baominglisttp";
	}
	
	@RequestMapping("deleteBaoming.do")
	public String deleteBaoming(int id,HttpServletRequest request){
		baomingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:baomingList.do";
	}
	
	
}
