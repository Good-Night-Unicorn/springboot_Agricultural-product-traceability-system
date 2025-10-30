package com.dao;

import com.entity.NongchanpinjichuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchanpinjichuxinxiVO;
import com.entity.view.NongchanpinjichuxinxiView;


/**
 * 农产品基础信息
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface NongchanpinjichuxinxiDao extends BaseMapper<NongchanpinjichuxinxiEntity> {
	
	List<NongchanpinjichuxinxiVO> selectListVO(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);
	
	NongchanpinjichuxinxiVO selectVO(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);
	
	List<NongchanpinjichuxinxiView> selectListView(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);

	List<NongchanpinjichuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);

	
	NongchanpinjichuxinxiView selectView(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);
	

}
