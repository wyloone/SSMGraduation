package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Baoming;

public interface BaomingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Baoming record);

    int insertSelective(Baoming record);

    Baoming selectByPrimaryKey(Integer id);

    //根据活动名称查活动报名信息
    Baoming selectByName(String huodongmingcheng);

    int updateByPrimaryKeySelective(Baoming record);
	
    int updateByPrimaryKey(Baoming record);
	public Baoming quchongBaoming(Map<String, Object> baomingren);
	public List<Baoming> getAll(Map<String, Object> map);
	public List<Baoming> getsybaoming1(Map<String, Object> map);
	public List<Baoming> getsybaoming3(Map<String, Object> map);
	public List<Baoming> getsybaoming2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Baoming> getByPage(Map<String, Object> map);
	public List<Baoming> select(Map<String, Object> map);
//	所有List
}

