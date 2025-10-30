package com.dao;

import com.entity.ShengchanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShengchanzheVO;
import com.entity.view.ShengchanzheView;


/**
 * 生产者
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ShengchanzheDao extends BaseMapper<ShengchanzheEntity> {
	
	List<ShengchanzheVO> selectListVO(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);
	
	ShengchanzheVO selectVO(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);
	
	List<ShengchanzheView> selectListView(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);

	List<ShengchanzheView> selectListView(Pagination page,@Param("ew") Wrapper<ShengchanzheEntity> wrapper);

	
	ShengchanzheView selectView(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);
	

}
