package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhiyuanhuodong;

public interface ZhiyuanhuodongServer {

  public int add(Zhiyuanhuodong po);

  public int update(Zhiyuanhuodong po);
  
  
  
  public int delete(int id);

  public List<Zhiyuanhuodong> getAll(Map<String,Object> map);
  public List<Zhiyuanhuodong> getsyzhiyuanhuodong1(Map<String,Object> map);
  public List<Zhiyuanhuodong> getsyzhiyuanhuodong2(Map<String,Object> map);
  public List<Zhiyuanhuodong> getsyzhiyuanhuodong3(Map<String,Object> map);
  public Zhiyuanhuodong quchongZhiyuanhuodong(Map<String, Object> acount);

  public Zhiyuanhuodong getById( int id);

  public List<Zhiyuanhuodong> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhiyuanhuodong> select(Map<String, Object> map);
}
//	所有List
