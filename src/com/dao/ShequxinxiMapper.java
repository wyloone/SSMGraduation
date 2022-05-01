package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shequxinxi;

public interface ShequxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shequxinxi record);

    int insertSelective(Shequxinxi record);

    Shequxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shequxinxi record);
	
    int updateByPrimaryKey(Shequxinxi record);
	public Shequxinxi quchongShequxinxi(Map<String, Object> shequbianhao);
	public List<Shequxinxi> getAll(Map<String, Object> map);
	public List<Shequxinxi> getsyshequxinxi1(Map<String, Object> map);
	public List<Shequxinxi> getsyshequxinxi3(Map<String, Object> map);
	public List<Shequxinxi> getsyshequxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shequxinxi> getByPage(Map<String, Object> map);
	public List<Shequxinxi> select(Map<String, Object> map);
//	所有List
}

