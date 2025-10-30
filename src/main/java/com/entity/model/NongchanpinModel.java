package com.entity.model;

import com.entity.NongchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农产品
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public class NongchanpinModel  implements Serializable {
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
	 * 加工工艺
	 */
	
	private String jiagonggongyi;
		
	/**
	 * 加工流程
	 */
	
	private String jiagongliucheng;
		
	/**
	 * 添加剂
	 */
	
	private String tianjiaji;
		
	/**
	 * 经销商号
	 */
	
	private String jingxiaoshanghao;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
				
	
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
	 * 设置：加工工艺
	 */
	 
	public void setJiagonggongyi(String jiagonggongyi) {
		this.jiagonggongyi = jiagonggongyi;
	}
	
	/**
	 * 获取：加工工艺
	 */
	public String getJiagonggongyi() {
		return jiagonggongyi;
	}
				
	
	/**
	 * 设置：加工流程
	 */
	 
	public void setJiagongliucheng(String jiagongliucheng) {
		this.jiagongliucheng = jiagongliucheng;
	}
	
	/**
	 * 获取：加工流程
	 */
	public String getJiagongliucheng() {
		return jiagongliucheng;
	}
				
	
	/**
	 * 设置：添加剂
	 */
	 
	public void setTianjiaji(String tianjiaji) {
		this.tianjiaji = tianjiaji;
	}
	
	/**
	 * 获取：添加剂
	 */
	public String getTianjiaji() {
		return tianjiaji;
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
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
			
}
