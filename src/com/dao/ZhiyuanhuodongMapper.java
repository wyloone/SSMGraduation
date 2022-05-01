package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhiyuanhuodong;

public interface ZhiyuanhuodongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhiyuanhuodong record);

    int insertSelective(Zhiyuanhuodong record);

    Zhiyuanhuodong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhiyuanhuodong record);
	
    int updateByPrimaryKey(Zhiyuanhuodong record);
	public Zhiyuanhuodong quchongZhiyuanhuodong(Map<String, Object> tuanduizhanghao);
	public List<Zhiyuanhuodong> getAll(Map<String, Object> map);
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong1(Map<String, Object> map);
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong3(Map<String, Object> map);
	public List<Zhiyuanhuodong> getsyzhiyuanhuodong2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhiyuanhuodong> getByPage(Map<String, Object> map);
	public List<Zhiyuanhuodong> select(Map<String, Object> map);
//	所有List
}

