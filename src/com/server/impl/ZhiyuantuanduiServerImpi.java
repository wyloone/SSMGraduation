package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhiyuantuanduiMapper;
import com.entity.Zhiyuantuandui;
import com.server.ZhiyuantuanduiServer;
@Service
public class ZhiyuantuanduiServerImpi implements ZhiyuantuanduiServer {
   @Resource
   private ZhiyuantuanduiMapper gdao;
	@Override
	public int add(Zhiyuantuandui po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhiyuantuandui po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhiyuantuandui> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhiyuantuandui> getsyzhiyuantuandui1(Map<String, Object> map) {
		return gdao.getsyzhiyuantuandui1(map);
	}
	public List<Zhiyuantuandui> getsyzhiyuantuandui2(Map<String, Object> map) {
		return gdao.getsyzhiyuantuandui2(map);
	}
	public List<Zhiyuantuandui> getsyzhiyuantuandui3(Map<String, Object> map) {
		return gdao.getsyzhiyuantuandui3(map);
	}
	
	@Override
	public Zhiyuantuandui quchongZhiyuantuandui(Map<String, Object> account) {
		return gdao.quchongZhiyuantuandui(account);
	}

	@Override
	public List<Zhiyuantuandui> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhiyuantuandui> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhiyuantuandui getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

