package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JuanzengxinxiMapper;
import com.entity.Juanzengxinxi;
import com.server.JuanzengxinxiServer;
@Service
public class JuanzengxinxiServerImpi implements JuanzengxinxiServer {
   @Resource
   private JuanzengxinxiMapper gdao;
	@Override
	public int add(Juanzengxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Juanzengxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Juanzengxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Juanzengxinxi> getsyjuanzengxinxi1(Map<String, Object> map) {
		return gdao.getsyjuanzengxinxi1(map);
	}
	public List<Juanzengxinxi> getsyjuanzengxinxi2(Map<String, Object> map) {
		return gdao.getsyjuanzengxinxi2(map);
	}
	public List<Juanzengxinxi> getsyjuanzengxinxi3(Map<String, Object> map) {
		return gdao.getsyjuanzengxinxi3(map);
	}
	
	@Override
	public Juanzengxinxi quchongJuanzengxinxi(Map<String, Object> account) {
		return gdao.quchongJuanzengxinxi(account);
	}

	@Override
	public List<Juanzengxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Juanzengxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Juanzengxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

