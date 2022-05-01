package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhiyuanzheMapper;
import com.entity.Zhiyuanzhe;
import com.server.ZhiyuanzheServer;
@Service
public class ZhiyuanzheServerImpi implements ZhiyuanzheServer {
   @Resource
   private ZhiyuanzheMapper gdao;
	@Override
	public int add(Zhiyuanzhe po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhiyuanzhe po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhiyuanzhe> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhiyuanzhe> getsyzhiyuanzhe1(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhe1(map);
	}
	public List<Zhiyuanzhe> getsyzhiyuanzhe2(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhe2(map);
	}
	public List<Zhiyuanzhe> getsyzhiyuanzhe3(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhe3(map);
	}
	
	@Override
	public Zhiyuanzhe quchongZhiyuanzhe(Map<String, Object> account) {
		return gdao.quchongZhiyuanzhe(account);
	}

	@Override
	public List<Zhiyuanzhe> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhiyuanzhe> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhiyuanzhe getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

