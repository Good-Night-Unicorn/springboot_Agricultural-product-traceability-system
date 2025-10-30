package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaofeizheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaofeizheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaofeizheView;


/**
 * 消费者
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface XiaofeizheService extends IService<XiaofeizheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaofeizheVO> selectListVO(Wrapper<XiaofeizheEntity> wrapper);
   	
   	XiaofeizheVO selectVO(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);
   	
   	List<XiaofeizheView> selectListView(Wrapper<XiaofeizheEntity> wrapper);
   	
   	XiaofeizheView selectView(@Param("ew") Wrapper<XiaofeizheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaofeizheEntity> wrapper);

   	

}

