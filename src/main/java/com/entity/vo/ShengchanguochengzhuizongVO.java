package com.entity.vo;

import com.entity.ShengchanguochengzhuizongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 生产过程追踪
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public class ShengchanguochengzhuizongVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 农产品名称
	 */
	
	private String nongchanpinmingcheng;
		
	/**
	 * 农产品品种
	 */
	
	private String nongchanpinpinzhong;
		
	/**
	 * 产品图片
	 */
	
	private String chanpintupian;
		
	/**
	 * 土壤酸碱度
	 */
	
	private String turangsuanjiandu;
		
	/**
	 * 土壤肥力值
	 */
	
	private String turangfeilizhi;
		
	/**
	 * 灌溉
	 */
	
	private String guangai;
		
	/**
	 * 播种记录
	 */
	
	private String bozhongjilu;
		
	/**
	 * 施肥记录
	 */
	
	private String shifeijilu;
		
	/**
	 * 施药记录
	 */
	
	private String shiyaojilu;
		
	/**
	 * 采摘时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date caizhaishijian;
		
	/**
	 * 生产者号
	 */
	
	private String shengchanzhehao;
		
	/**
	 * 生产者名
	 */
	
	private String shengchanzheming;
				
	
	/**
	 * 设置：农产品名称
	 */
	 
	public void setNongchanpinmingcheng(String nongchanpinmingcheng) {
		this.nongchanpinmingcheng = nongchanpinmingcheng;
	}
	
	/**
	 * 获取：农产品名称
	 */
	public String getNongchanpinmingcheng() {
		return nongchanpinmingcheng;
	}
				
	
	/**
	 * 设置：农产品品种
	 */
	 
	public void setNongchanpinpinzhong(String nongchanpinpinzhong) {
		this.nongchanpinpinzhong = nongchanpinpinzhong;
	}
	
	/**
	 * 获取：农产品品种
	 */
	public String getNongchanpinpinzhong() {
		return nongchanpinpinzhong;
	}
				
	
	/**
	 * 设置：产品图片
	 */
	 
	public void setChanpintupian(String chanpintupian) {
		this.chanpintupian = chanpintupian;
	}
	
	/**
	 * 获取：产品图片
	 */
	public String getChanpintupian() {
		return chanpintupian;
	}
				
	
	/**
	 * 设置：土壤酸碱度
	 */
	 
	public void setTurangsuanjiandu(String turangsuanjiandu) {
		this.turangsuanjiandu = turangsuanjiandu;
	}
	
	/**
	 * 获取：土壤酸碱度
	 */
	public String getTurangsuanjiandu() {
		return turangsuanjiandu;
	}
				
	
	/**
	 * 设置：土壤肥力值
	 */
	 
	public void setTurangfeilizhi(String turangfeilizhi) {
		this.turangfeilizhi = turangfeilizhi;
	}
	
	/**
	 * 获取：土壤肥力值
	 */
	public String getTurangfeilizhi() {
		return turangfeilizhi;
	}
				
	
	/**
	 * 设置：灌溉
	 */
	 
	public void setGuangai(String guangai) {
		this.guangai = guangai;
	}
	
	/**
	 * 获取：灌溉
	 */
	public String getGuangai() {
		return guangai;
	}
				
	
	/**
	 * 设置：播种记录
	 */
	 
	public void setBozhongjilu(String bozhongjilu) {
		this.bozhongjilu = bozhongjilu;
	}
	
	/**
	 * 获取：播种记录
	 */
	public String getBozhongjilu() {
		return bozhongjilu;
	}
				
	
	/**
	 * 设置：施肥记录
	 */
	 
	public void setShifeijilu(String shifeijilu) {
		this.shifeijilu = shifeijilu;
	}
	
	/**
	 * 获取：施肥记录
	 */
	public String getShifeijilu() {
		return shifeijilu;
	}
				
	
	/**
	 * 设置：施药记录
	 */
	 
	public void setShiyaojilu(String shiyaojilu) {
		this.shiyaojilu = shiyaojilu;
	}
	
	/**
	 * 获取：施药记录
	 */
	public String getShiyaojilu() {
		return shiyaojilu;
	}
				
	
	/**
	 * 设置：采摘时间
	 */
	 
	public void setCaizhaishijian(Date caizhaishijian) {
		this.caizhaishijian = caizhaishijian;
	}
	
	/**
	 * 获取：采摘时间
	 */
	public Date getCaizhaishijian() {
		return caizhaishijian;
	}
				
	
	/**
	 * 设置：生产者号
	 */
	 
	public void setShengchanzhehao(String shengchanzhehao) {
		this.shengchanzhehao = shengchanzhehao;
	}
	
	/**
	 * 获取：生产者号
	 */
	public String getShengchanzhehao() {
		return shengchanzhehao;
	}
				
	
	/**
	 * 设置：生产者名
	 */
	 
	public void setShengchanzheming(String shengchanzheming) {
		this.shengchanzheming = shengchanzheming;
	}
	
	/**
	 * 获取：生产者名
	 */
	public String getShengchanzheming() {
		return shengchanzheming;
	}
			
}
