package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhiyuanzhe;

public interface ZhiyuanzheServer {

  public int add(Zhiyuanzhe po);

  public int update(Zhiyuanzhe po);
  
  
  
  public int delete(int id);

  public List<Zhiyuanzhe> getAll(Map<String,Object> map);
  public List<Zhiyuanzhe> getsyzhiyuanzhe1(Map<String,Object> map);
  public List<Zhiyuanzhe> getsyzhiyuanzhe2(Map<String,Object> map);
  public List<Zhiyuanzhe> getsyzhiyuanzhe3(Map<String,Object> map);
  public Zhiyuanzhe quchongZhiyuanzhe(Map<String, Object> acount);

  public Zhiyuanzhe getById( int id);

  public List<Zhiyuanzhe> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhiyuanzhe> select(Map<String, Object> map);
}
//	所有List
