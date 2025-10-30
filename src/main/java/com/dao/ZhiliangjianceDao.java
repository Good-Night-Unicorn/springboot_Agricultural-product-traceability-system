package com.dao;

import com.entity.ZhiliangjianceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiliangjianceVO;
import com.entity.view.ZhiliangjianceView;


/**
 * 质量检测
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ZhiliangjianceDao extends BaseMapper<ZhiliangjianceEntity> {
	
	List<ZhiliangjianceVO> selectListVO(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);
	
	ZhiliangjianceVO selectVO(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);
	
	List<ZhiliangjianceView> selectListView(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);

	List<ZhiliangjianceView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);

	
	ZhiliangjianceView selectView(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);
	

}
