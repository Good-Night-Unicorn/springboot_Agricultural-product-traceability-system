package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShengchanzheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShengchanzheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShengchanzheView;


/**
 * 生产者
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ShengchanzheService extends IService<ShengchanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShengchanzheVO> selectListVO(Wrapper<ShengchanzheEntity> wrapper);
   	
   	ShengchanzheVO selectVO(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);
   	
   	List<ShengchanzheView> selectListView(Wrapper<ShengchanzheEntity> wrapper);
   	
   	ShengchanzheView selectView(@Param("ew") Wrapper<ShengchanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShengchanzheEntity> wrapper);

   	

}

