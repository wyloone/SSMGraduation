package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shequxinxi;

public interface ShequxinxiServer {

  public int add(Shequxinxi po);

  public int update(Shequxinxi po);
  
  
  
  public int delete(int id);

  public List<Shequxinxi> getAll(Map<String,Object> map);
  public List<Shequxinxi> getsyshequxinxi1(Map<String,Object> map);
  public List<Shequxinxi> getsyshequxinxi2(Map<String,Object> map);
  public List<Shequxinxi> getsyshequxinxi3(Map<String,Object> map);
  public Shequxinxi quchongShequxinxi(Map<String, Object> acount);

  public Shequxinxi getById( int id);

  public List<Shequxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shequxinxi> select(Map<String, Object> map);
}
//	所有List
