package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dao.BaomingMapper;
import com.entity.Baoming;
import com.server.BaomingServer;
@Service
public class BaomingServerImpi implements BaomingServer {
   @Resource
   private BaomingMapper gdao;
	@Override
	public int add(Baoming po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Baoming po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	//根据活动名称查活动报名信息
	@Override
	public Baoming getBaomingByName(String huodongmingcheng) {
		if(StringUtils.isNotBlank(huodongmingcheng)){
			return gdao.selectByName(huodongmingcheng);
		}
		return null;
	}


	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Baoming> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Baoming> getsybaoming1(Map<String, Object> map) {
		return gdao.getsybaoming1(map);
	}
	public List<Baoming> getsybaoming2(Map<String, Object> map) {
		return gdao.getsybaoming2(map);
	}
	public List<Baoming> getsybaoming3(Map<String, Object> map) {
		return gdao.getsybaoming3(map);
	}
	
	@Override
	public Baoming quchongBaoming(Map<String, Object> account) {
		return gdao.quchongBaoming(account);
	}

	@Override
	public List<Baoming> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Baoming> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Baoming getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

