package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhiyuantuandui;

public interface ZhiyuantuanduiServer {

  public int add(Zhiyuantuandui po);

  public int update(Zhiyuantuandui po);
  
  
  
  public int delete(int id);

  public List<Zhiyuantuandui> getAll(Map<String,Object> map);
  public List<Zhiyuantuandui> getsyzhiyuantuandui1(Map<String,Object> map);
  public List<Zhiyuantuandui> getsyzhiyuantuandui2(Map<String,Object> map);
  public List<Zhiyuantuandui> getsyzhiyuantuandui3(Map<String,Object> map);
  public Zhiyuantuandui quchongZhiyuantuandui(Map<String, Object> acount);

  public Zhiyuantuandui getById( int id);

  public List<Zhiyuantuandui> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhiyuantuandui> select(Map<String, Object> map);
}
//	所有List
