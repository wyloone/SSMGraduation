package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiarutuandui;

public interface JiarutuanduiServer {

  public int add(Jiarutuandui po);

  public int update(Jiarutuandui po);
  
  
  
  public int delete(int id);

  public List<Jiarutuandui> getAll(Map<String,Object> map);
  public List<Jiarutuandui> getsyjiarutuandui1(Map<String,Object> map);
  public List<Jiarutuandui> getsyjiarutuandui2(Map<String,Object> map);
  public List<Jiarutuandui> getsyjiarutuandui3(Map<String,Object> map);
  public Jiarutuandui quchongJiarutuandui(Map<String, Object> acount);

  public Jiarutuandui getById( int id);

  public List<Jiarutuandui> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiarutuandui> select(Map<String, Object> map);
}
//	所有List
