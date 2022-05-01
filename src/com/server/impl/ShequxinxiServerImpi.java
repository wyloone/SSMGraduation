package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShequxinxiMapper;
import com.entity.Shequxinxi;
import com.server.ShequxinxiServer;
@Service
public class ShequxinxiServerImpi implements ShequxinxiServer {
   @Resource
   private ShequxinxiMapper gdao;
	@Override
	public int add(Shequxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shequxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shequxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shequxinxi> getsyshequxinxi1(Map<String, Object> map) {
		return gdao.getsyshequxinxi1(map);
	}
	public List<Shequxinxi> getsyshequxinxi2(Map<String, Object> map) {
		return gdao.getsyshequxinxi2(map);
	}
	public List<Shequxinxi> getsyshequxinxi3(Map<String, Object> map) {
		return gdao.getsyshequxinxi3(map);
	}
	
	@Override
	public Shequxinxi quchongShequxinxi(Map<String, Object> account) {
		return gdao.quchongShequxinxi(account);
	}

	@Override
	public List<Shequxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shequxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shequxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

