package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiagonghuanjieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiagonghuanjieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiagonghuanjieView;


/**
 * 加工环节
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface JiagonghuanjieService extends IService<JiagonghuanjieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiagonghuanjieVO> selectListVO(Wrapper<JiagonghuanjieEntity> wrapper);
   	
   	JiagonghuanjieVO selectVO(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);
   	
   	List<JiagonghuanjieView> selectListView(Wrapper<JiagonghuanjieEntity> wrapper);
   	
   	JiagonghuanjieView selectView(@Param("ew") Wrapper<JiagonghuanjieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiagonghuanjieEntity> wrapper);

   	

}

