package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhiyuantuandui;

public interface ZhiyuantuanduiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhiyuantuandui record);

    int insertSelective(Zhiyuantuandui record);

    Zhiyuantuandui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhiyuantuandui record);
	
    int updateByPrimaryKey(Zhiyuantuandui record);
	public Zhiyuantuandui quchongZhiyuantuandui(Map<String, Object> tuanduizhanghao);
	public List<Zhiyuantuandui> getAll(Map<String, Object> map);
	public List<Zhiyuantuandui> getsyzhiyuantuandui1(Map<String, Object> map);
	public List<Zhiyuantuandui> getsyzhiyuantuandui3(Map<String, Object> map);
	public List<Zhiyuantuandui> getsyzhiyuantuandui2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhiyuantuandui> getByPage(Map<String, Object> map);
	public List<Zhiyuantuandui> select(Map<String, Object> map);
//	所有List
}

