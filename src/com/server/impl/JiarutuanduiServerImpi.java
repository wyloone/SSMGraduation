package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiarutuanduiMapper;
import com.entity.Jiarutuandui;
import com.server.JiarutuanduiServer;
@Service
public class JiarutuanduiServerImpi implements JiarutuanduiServer {
   @Resource
   private JiarutuanduiMapper gdao;
	@Override
	public int add(Jiarutuandui po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiarutuandui po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiarutuandui> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiarutuandui> getsyjiarutuandui1(Map<String, Object> map) {
		return gdao.getsyjiarutuandui1(map);
	}
	public List<Jiarutuandui> getsyjiarutuandui2(Map<String, Object> map) {
		return gdao.getsyjiarutuandui2(map);
	}
	public List<Jiarutuandui> getsyjiarutuandui3(Map<String, Object> map) {
		return gdao.getsyjiarutuandui3(map);
	}
	
	@Override
	public Jiarutuandui quchongJiarutuandui(Map<String, Object> account) {
		return gdao.quchongJiarutuandui(account);
	}

	@Override
	public List<Jiarutuandui> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiarutuandui> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiarutuandui getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

