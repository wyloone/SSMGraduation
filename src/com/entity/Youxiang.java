package com.entity;

public class Youxiang {
    private Integer id;
	private String shoujianren;	private String fajianren;	private String biaoti;	private String zhengwen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShoujianren() {
        return shoujianren;
    }
    public void setShoujianren(String shoujianren) {
        this.shoujianren = shoujianren == null ? null : shoujianren.trim();
    }	public String getFajianren() {
        return fajianren;
    }
    public void setFajianren(String fajianren) {
        this.fajianren = fajianren == null ? null : fajianren.trim();
    }	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getZhengwen() {
        return zhengwen;
    }
    public void setZhengwen(String zhengwen) {
        this.zhengwen = zhengwen == null ? null : zhengwen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
