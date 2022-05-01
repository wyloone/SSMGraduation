package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Baoming;

public interface BaomingServer {

  public int add(Baoming po);

  public int update(Baoming po);

  //根据活动名称查活动报名信息
  public Baoming getBaomingByName(String huodongmingcheng);
  
  public int delete(int id);

  public List<Baoming> getAll(Map<String,Object> map);
  public List<Baoming> getsybaoming1(Map<String,Object> map);
  public List<Baoming> getsybaoming2(Map<String,Object> map);
  public List<Baoming> getsybaoming3(Map<String,Object> map);
  public Baoming quchongBaoming(Map<String, Object> acount);

  public Baoming getById( int id);

  public List<Baoming> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Baoming> select(Map<String, Object> map);
}
//	所有List
