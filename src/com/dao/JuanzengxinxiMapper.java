package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Juanzengxinxi;

public interface JuanzengxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Juanzengxinxi record);

    int insertSelective(Juanzengxinxi record);

    Juanzengxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Juanzengxinxi record);
	
    int updateByPrimaryKey(Juanzengxinxi record);
	public Juanzengxinxi quchongJuanzengxinxi(Map<String, Object> juanzengren);
	public List<Juanzengxinxi> getAll(Map<String, Object> map);
	public List<Juanzengxinxi> getsyjuanzengxinxi1(Map<String, Object> map);
	public List<Juanzengxinxi> getsyjuanzengxinxi3(Map<String, Object> map);
	public List<Juanzengxinxi> getsyjuanzengxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Juanzengxinxi> getByPage(Map<String, Object> map);
	public List<Juanzengxinxi> select(Map<String, Object> map);
//	所有List
}

