package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Youxiang;

public interface YouxiangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Youxiang record);

    int insertSelective(Youxiang record);

    Youxiang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Youxiang record);
	
    int updateByPrimaryKey(Youxiang record);
	public Youxiang quchongYouxiang(Map<String, Object> fajianren);
	public List<Youxiang> getAll(Map<String, Object> map);
	public List<Youxiang> getsyyouxiang1(Map<String, Object> map);
	public List<Youxiang> getsyyouxiang3(Map<String, Object> map);
	public List<Youxiang> getsyyouxiang2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Youxiang> getByPage(Map<String, Object> map);
	public List<Youxiang> select(Map<String, Object> map);
//	所有List
}

