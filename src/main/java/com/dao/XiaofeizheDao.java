package com.dao;

import com.entity.XiaofeizheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaofeizheVO;
import com.entity.view.XiaofeizheView;


/**
 * 消费者
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface XiaofeizheDao extends BaseMapper<XiaofeizheEntity> {
	
	List<XiaofeizheVO> selectListVO(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);
	
	XiaofeizheVO selectVO(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);
	
	List<XiaofeizheView> selectListView(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);

	List<XiaofeizheView> selectListView(Pagination page,@Param("ew") Wrapper<XiaofeizheEntity> wrapper);

	
	XiaofeizheView selectView(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);
	

}
