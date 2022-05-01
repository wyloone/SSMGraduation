package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhiyuanzhetuandui;

public interface ZhiyuanzhetuanduiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhiyuanzhetuandui record);

    int insertSelective(Zhiyuanzhetuandui record);

    Zhiyuanzhetuandui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhiyuanzhetuandui record);
	
    int updateByPrimaryKey(Zhiyuanzhetuandui record);
	public Zhiyuanzhetuandui quchongZhiyuanzhetuandui(Map<String, Object> tuanduizhanghao);
	public List<Zhiyuanzhetuandui> getAll(Map<String, Object> map);
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui1(Map<String, Object> map);
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui3(Map<String, Object> map);
	public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhiyuanzhetuandui> getByPage(Map<String, Object> map);
	public List<Zhiyuanzhetuandui> select(Map<String, Object> map);
//	所有List
}

