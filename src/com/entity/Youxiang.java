package com.entity;

public class Youxiang {
    private Integer id;
	private String shoujianren;
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
    }
        return fajianren;
    }
    public void setFajianren(String fajianren) {
        this.fajianren = fajianren == null ? null : fajianren.trim();
    }
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }
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