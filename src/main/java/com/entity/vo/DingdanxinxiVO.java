package com.entity.vo;

import com.entity.DingdanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单信息
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public class DingdanxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 产品名称
	 */
	
	private String chanpinmingcheng;
		
	/**
	 * 产品品种
	 */
	
	private String chanpinpinzhong;
		
	/**
	 * 经销商名
	 */
	
	private String jingxiaoshangming;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 加工企业
	 */
	
	private String jiagongqiye;
		
	/**
	 * 生产日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shengchanriqi;
		
	/**
	 * 经销商号
	 */
	
	private String jingxiaoshanghao;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 购买数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 合计
	 */
	
	private Integer heji;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：产品名称
	 */
	 
	public void setChanpinmingcheng(String chanpinmingcheng) {
		this.chanpinmingcheng = chanpinmingcheng;
	}
	
	/**
	 * 获取：产品名称
	 */
	public String getChanpinmingcheng() {
		return chanpinmingcheng;
	}
				
	
	/**
	 * 设置：产品品种
	 */
	 
	public void setChanpinpinzhong(String chanpinpinzhong) {
		this.chanpinpinzhong = chanpinpinzhong;
	}
	
	/**
	 * 获取：产品品种
	 */
	public String getChanpinpinzhong() {
		return chanpinpinzhong;
	}
				
	
	/**
	 * 设置：经销商名
	 */
	 
	public void setJingxiaoshangming(String jingxiaoshangming) {
		this.jingxiaoshangming = jingxiaoshangming;
	}
	
	/**
	 * 获取：经销商名
	 */
	public String getJingxiaoshangming() {
		return jingxiaoshangming;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：加工企业
	 */
	 
	public void setJiagongqiye(String jiagongqiye) {
		this.jiagongqiye = jiagongqiye;
	}
	
	/**
	 * 获取：加工企业
	 */
	public String getJiagongqiye() {
		return jiagongqiye;
	}
				
	
	/**
	 * 设置：生产日期
	 */
	 
	public void setShengchanriqi(Date shengchanriqi) {
		this.shengchanriqi = shengchanriqi;
	}
	
	/**
	 * 获取：生产日期
	 */
	public Date getShengchanriqi() {
		return shengchanriqi;
	}
				
	
	/**
	 * 设置：经销商号
	 */
	 
	public void setJingxiaoshanghao(String jingxiaoshanghao) {
		this.jingxiaoshanghao = jingxiaoshanghao;
	}
	
	/**
	 * 获取：经销商号
	 */
	public String getJingxiaoshanghao() {
		return jingxiaoshanghao;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Integer getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：购买数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：购买数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：合计
	 */
	 
	public void setHeji(Integer heji) {
		this.heji = heji;
	}
	
	/**
	 * 获取：合计
	 */
	public Integer getHeji() {
		return heji;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
