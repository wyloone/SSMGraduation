package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Youxiang;

public interface YouxiangServer {

  public int add(Youxiang po);

  public int update(Youxiang po);
  
  
  
  public int delete(int id);

  public List<Youxiang> getAll(Map<String,Object> map);
  public List<Youxiang> getsyyouxiang1(Map<String,Object> map);
  public List<Youxiang> getsyyouxiang2(Map<String,Object> map);
  public List<Youxiang> getsyyouxiang3(Map<String,Object> map);
  public Youxiang quchongYouxiang(Map<String, Object> acount);

  public Youxiang getById( int id);

  public List<Youxiang> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Youxiang> select(Map<String, Object> map);
}
//	所有List
