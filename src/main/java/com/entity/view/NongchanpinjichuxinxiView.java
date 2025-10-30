package com.entity.view;

import com.entity.NongchanpinjichuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 农产品基础信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@TableName("nongchanpinjichuxinxi")
public class NongchanpinjichuxinxiView  extends NongchanpinjichuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanpinjichuxinxiView(){
	}
 
 	public NongchanpinjichuxinxiView(NongchanpinjichuxinxiEntity nongchanpinjichuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanpinjichuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
