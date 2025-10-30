package com.dao;

import com.entity.JianguanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianguanzheVO;
import com.entity.view.JianguanzheView;


/**
 * 监管者
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface JianguanzheDao extends BaseMapper<JianguanzheEntity> {
	
	List<JianguanzheVO> selectListVO(@Param("ew") Wrapper<JianguanzheEntity> wrapper);
	
	JianguanzheVO selectVO(@Param("ew") Wrapper<JianguanzheEntity> wrapper);
	
	List<JianguanzheView> selectListView(@Param("ew") Wrapper<JianguanzheEntity> wrapper);

	List<JianguanzheView> selectListView(Pagination page,@Param("ew") Wrapper<JianguanzheEntity> wrapper);

	
	JianguanzheView selectView(@Param("ew") Wrapper<JianguanzheEntity> wrapper);
	

}
