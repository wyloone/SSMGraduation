package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhiyuanhuodongMapper;
import com.entity.Zhiyuanhuodong;
import com.server.ZhiyuanhuodongServer;
@Service
public class ZhiyuanhuodongServerImpi implements ZhiyuanhuodongServer {
   @Resource
   private ZhiyuanhuodongMapper gdao;
	@Override
	public int add(Zhiyuanhuodong po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhiyuanhuodong po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhiyuanhuodong> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong1(Map<String, Object> map) {
		return gdao.getsyzhiyuanhuodong1(map);
	}
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong2(Map<String, Object> map) {
		return gdao.getsyzhiyuanhuodong2(map);
	}
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong3(Map<String, Object> map) {
		return gdao.getsyzhiyuanhuodong3(map);
	}
	
	@Override
	public Zhiyuanhuodong quchongZhiyuanhuodong(Map<String, Object> account) {
		return gdao.quchongZhiyuanhuodong(account);
	}

	@Override
	public List<Zhiyuanhuodong> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhiyuanhuodong> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhiyuanhuodong getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

