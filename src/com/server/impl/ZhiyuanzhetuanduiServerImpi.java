package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhiyuanzhetuanduiMapper;
import com.entity.Zhiyuanzhetuandui;
import com.server.ZhiyuanzhetuanduiServer;
@Service
public class ZhiyuanzhetuanduiServerImpi implements ZhiyuanzhetuanduiServer {
   @Resource
   private ZhiyuanzhetuanduiMapper gdao;
	@Override
	public int add(Zhiyuanzhetuandui po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhiyuanzhetuandui po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhiyuanzhetuandui> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui1(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhetuandui1(map);
	}
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui2(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhetuandui2(map);
	}
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui3(Map<String, Object> map) {
		return gdao.getsyzhiyuanzhetuandui3(map);
	}
	
	@Override
	public Zhiyuanzhetuandui quchongZhiyuanzhetuandui(Map<String, Object> account) {
		return gdao.quchongZhiyuanzhetuandui(account);
	}

	@Override
	public List<Zhiyuanzhetuandui> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhiyuanzhetuandui> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhiyuanzhetuandui getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

