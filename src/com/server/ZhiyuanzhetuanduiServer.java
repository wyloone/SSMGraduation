package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhiyuanzhetuandui;

public interface ZhiyuanzhetuanduiServer {

  public int add(Zhiyuanzhetuandui po);

  public int update(Zhiyuanzhetuandui po);
  
  
  
  public int delete(int id);

  public List<Zhiyuanzhetuandui> getAll(Map<String,Object> map);
  public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui1(Map<String,Object> map);
  public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui2(Map<String,Object> map);
  public List<Zhiyuanzhetuandui> getsyzhiyuanzhetuandui3(Map<String,Object> map);
  public Zhiyuanzhetuandui quchongZhiyuanzhetuandui(Map<String, Object> acount);

  public Zhiyuanzhetuandui getById( int id);

  public List<Zhiyuanzhetuandui> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhiyuanzhetuandui> select(Map<String, Object> map);
}
//	所有List
