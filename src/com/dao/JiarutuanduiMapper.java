package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiarutuandui;

public interface JiarutuanduiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiarutuandui record);

    int insertSelective(Jiarutuandui record);

    Jiarutuandui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiarutuandui record);
	
    int updateByPrimaryKey(Jiarutuandui record);
	public Jiarutuandui quchongJiarutuandui(Map<String, Object> jiaruren);
	public List<Jiarutuandui> getAll(Map<String, Object> map);
	public List<Jiarutuandui> getsyjiarutuandui1(Map<String, Object> map);
	public List<Jiarutuandui> getsyjiarutuandui3(Map<String, Object> map);
	public List<Jiarutuandui> getsyjiarutuandui2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiarutuandui> getByPage(Map<String, Object> map);
	public List<Jiarutuandui> select(Map<String, Object> map);
//	所有List
}

