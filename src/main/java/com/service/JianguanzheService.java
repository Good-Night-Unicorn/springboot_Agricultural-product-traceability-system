package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianguanzheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianguanzheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianguanzheView;


/**
 * 监管者
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface JianguanzheService extends IService<JianguanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianguanzheVO> selectListVO(Wrapper<JianguanzheEntity> wrapper);
   	
   	JianguanzheVO selectVO(@Param("ew") Wrapper<JianguanzheEntity> wrapper);
   	
   	List<JianguanzheView> selectListView(Wrapper<JianguanzheEntity> wrapper);
   	
   	JianguanzheView selectView(@Param("ew") Wrapper<JianguanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianguanzheEntity> wrapper);

   	

}

