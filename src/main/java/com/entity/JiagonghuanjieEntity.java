package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 加工环节
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@TableName("jiagonghuanjie")
public class JiagonghuanjieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiagonghuanjieEntity() {
		
	}
	
	public JiagonghuanjieEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 溯源码
	 */
					
	private String suyuanma;
	
	/**
	 * 经销商名
	 */
					
	private String jingxiaoshangming;
	
	/**
	 * 产品名称
	 */
					
	private String chanpinmingcheng;
	
	/**
	 * 产品品种
	 */
					
	private String chanpinpinzhong;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 加工企业
	 */
					
	private String jiagongqiye;
	
	/**
	 * 生产日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 农产品名称
	 */
					
	private String nongchanpinmingcheng;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：溯源码
	 */
	public void setSuyuanma(String suyuanma) {
		this.suyuanma = suyuanma;
	}
	/**
	 * 获取：溯源码
	 */
	public String getSuyuanma() {
		return suyuanma;
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

}
