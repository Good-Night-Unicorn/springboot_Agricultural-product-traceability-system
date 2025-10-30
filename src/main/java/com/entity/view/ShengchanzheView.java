package com.entity.view;

import com.entity.ShengchanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 生产者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@TableName("shengchanzhe")
public class ShengchanzheView  extends ShengchanzheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShengchanzheView(){
	}
 
 	public ShengchanzheView(ShengchanzheEntity shengchanzheEntity){
 	try {
			BeanUtils.copyProperties(this, shengchanzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
