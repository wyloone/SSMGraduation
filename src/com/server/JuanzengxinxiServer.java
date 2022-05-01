package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Juanzengxinxi;

public interface JuanzengxinxiServer {

  public int add(Juanzengxinxi po);

  public int update(Juanzengxinxi po);
  
  
  
  public int delete(int id);

  public List<Juanzengxinxi> getAll(Map<String,Object> map);
  public List<Juanzengxinxi> getsyjuanzengxinxi1(Map<String,Object> map);
  public List<Juanzengxinxi> getsyjuanzengxinxi2(Map<String,Object> map);
  public List<Juanzengxinxi> getsyjuanzengxinxi3(Map<String,Object> map);
  public Juanzengxinxi quchongJuanzengxinxi(Map<String, Object> acount);

  public Juanzengxinxi getById( int id);

  public List<Juanzengxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Juanzengxinxi> select(Map<String, Object> map);
}
//	所有List
