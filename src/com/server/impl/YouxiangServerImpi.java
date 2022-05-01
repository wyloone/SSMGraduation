package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YouxiangMapper;
import com.entity.Youxiang;
import com.server.YouxiangServer;
@Service
public class YouxiangServerImpi implements YouxiangServer {
   @Resource
   private YouxiangMapper gdao;
	@Override
	public int add(Youxiang po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Youxiang po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Youxiang> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Youxiang> getsyyouxiang1(Map<String, Object> map) {
		return gdao.getsyyouxiang1(map);
	}
	public List<Youxiang> getsyyouxiang2(Map<String, Object> map) {
		return gdao.getsyyouxiang2(map);
	}
	public List<Youxiang> getsyyouxiang3(Map<String, Object> map) {
		return gdao.getsyyouxiang3(map);
	}
	
	@Override
	public Youxiang quchongYouxiang(Map<String, Object> account) {
		return gdao.quchongYouxiang(account);
	}

	@Override
	public List<Youxiang> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Youxiang> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Youxiang getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

