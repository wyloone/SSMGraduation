package com.entity;

public class Shequxinxi {
    private Integer id;
	private String shequbianhao;	private String shequmingcheng;	private String shequzhaopian;	private String shequdianhua;	private String shequdizhi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShequbianhao() {
        return shequbianhao;
    }
    public void setShequbianhao(String shequbianhao) {
        this.shequbianhao = shequbianhao == null ? null : shequbianhao.trim();
    }	public String getShequmingcheng() {
        return shequmingcheng;
    }
    public void setShequmingcheng(String shequmingcheng) {
        this.shequmingcheng = shequmingcheng == null ? null : shequmingcheng.trim();
    }	public String getShequzhaopian() {
        return shequzhaopian;
    }
    public void setShequzhaopian(String shequzhaopian) {
        this.shequzhaopian = shequzhaopian == null ? null : shequzhaopian.trim();
    }	public String getShequdianhua() {
        return shequdianhua;
    }
    public void setShequdianhua(String shequdianhua) {
        this.shequdianhua = shequdianhua == null ? null : shequdianhua.trim();
    }	public String getShequdizhi() {
        return shequdizhi;
    }
    public void setShequdizhi(String shequdizhi) {
        this.shequdizhi = shequdizhi == null ? null : shequdizhi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
