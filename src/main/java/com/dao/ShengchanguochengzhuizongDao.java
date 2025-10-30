package com.dao;

import com.entity.ShengchanguochengzhuizongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShengchanguochengzhuizongVO;
import com.entity.view.ShengchanguochengzhuizongView;


/**
 * 生产过程追踪
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ShengchanguochengzhuizongDao extends BaseMapper<ShengchanguochengzhuizongEntity> {
	
	List<ShengchanguochengzhuizongVO> selectListVO(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);
	
	ShengchanguochengzhuizongVO selectVO(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);
	
	List<ShengchanguochengzhuizongView> selectListView(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);

	List<ShengchanguochengzhuizongView> selectListView(Pagination page,@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);

	
	ShengchanguochengzhuizongView selectView(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);
	

}
