package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhiyuanzhe;

public interface ZhiyuanzheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhiyuanzhe record);

    int insertSelective(Zhiyuanzhe record);

    Zhiyuanzhe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhiyuanzhe record);
	
    int updateByPrimaryKey(Zhiyuanzhe record);
	public Zhiyuanzhe quchongZhiyuanzhe(Map<String, Object> zhiyuanzhezhanghao);
	public List<Zhiyuanzhe> getAll(Map<String, Object> map);
	public List<Zhiyuanzhe> getsyzhiyuanzhe1(Map<String, Object> map);
	public List<Zhiyuanzhe> getsyzhiyuanzhe3(Map<String, Object> map);
	public List<Zhiyuanzhe> getsyzhiyuanzhe2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhiyuanzhe> getByPage(Map<String, Object> map);
	public List<Zhiyuanzhe> select(Map<String, Object> map);
//	所有List
}

