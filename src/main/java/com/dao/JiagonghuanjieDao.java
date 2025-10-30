package com.dao;

import com.entity.JiagonghuanjieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiagonghuanjieVO;
import com.entity.view.JiagonghuanjieView;


/**
 * 加工环节
 * 
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface JiagonghuanjieDao extends BaseMapper<JiagonghuanjieEntity> {
	
	List<JiagonghuanjieVO> selectListVO(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);
	
	JiagonghuanjieVO selectVO(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);
	
	List<JiagonghuanjieView> selectListView(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);

	List<JiagonghuanjieView> selectListView(Pagination page,@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);

	
	JiagonghuanjieView selectView(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);
	

}
