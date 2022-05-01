package com.entity;

public class Juanzengxinxi {
    private Integer id;
	private String juanzengbianhao;	private String juanzengshijian;	private String juanzengneirong;	private String wuzitupian;	private String juanzengren;	private String issh;	private String shhf;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getJuanzengbianhao() {
        return juanzengbianhao;
    }
    public void setJuanzengbianhao(String juanzengbianhao) {
        this.juanzengbianhao = juanzengbianhao == null ? null : juanzengbianhao.trim();
    }	public String getJuanzengshijian() {
        return juanzengshijian;
    }
    public void setJuanzengshijian(String juanzengshijian) {
        this.juanzengshijian = juanzengshijian == null ? null : juanzengshijian.trim();
    }	public String getJuanzengneirong() {
        return juanzengneirong;
    }
    public void setJuanzengneirong(String juanzengneirong) {
        this.juanzengneirong = juanzengneirong == null ? null : juanzengneirong.trim();
    }	public String getWuzitupian() {
        return wuzitupian;
    }
    public void setWuzitupian(String wuzitupian) {
        this.wuzitupian = wuzitupian == null ? null : wuzitupian.trim();
    }	public String getJuanzengren() {
        return juanzengren;
    }
    public void setJuanzengren(String juanzengren) {
        this.juanzengren = juanzengren == null ? null : juanzengren.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	public String getShhf() {
        return shhf;
    }
    public void setShhf(String shhf) {
        this.shhf = shhf == null ? null : shhf.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
