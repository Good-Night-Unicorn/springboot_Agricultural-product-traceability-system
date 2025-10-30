package com.entity.view;

import com.entity.WuliuyunshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 物流运输
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-23 16:42:56
 */
@TableName("wuliuyunshu")
public class WuliuyunshuView  extends WuliuyunshuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WuliuyunshuView(){
	}
 
 	public WuliuyunshuView(WuliuyunshuEntity wuliuyunshuEntity){
 	try {
			BeanUtils.copyProperties(this, wuliuyunshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
