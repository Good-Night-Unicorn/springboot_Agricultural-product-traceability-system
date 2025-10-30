package com.entity.vo;

import com.entity.NongchanpinjichuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农产品基础信息
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public class NongchanpinjichuxinxiVO  implements Serializable {
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
	 * 植养时间
	 */
	
	private String zhiyangshijian;
		
	/**
	 * 种植记录
	 */
	
	private String zhongzhijilu;
		
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
	 * 设置：植养时间
	 */
	 
	public void setZhiyangshijian(String zhiyangshijian) {
		this.zhiyangshijian = zhiyangshijian;
	}
	
	/**
	 * 获取：植养时间
	 */
	public String getZhiyangshijian() {
		return zhiyangshijian;
	}
				
	
	/**
	 * 设置：种植记录
	 */
	 
	public void setZhongzhijilu(String zhongzhijilu) {
		this.zhongzhijilu = zhongzhijilu;
	}
	
	/**
	 * 获取：种植记录
	 */
	public String getZhongzhijilu() {
		return zhongzhijilu;
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
