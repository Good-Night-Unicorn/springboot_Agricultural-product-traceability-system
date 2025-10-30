package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiliangjianceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiliangjianceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiliangjianceView;


/**
 * 质量检测
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ZhiliangjianceService extends IService<ZhiliangjianceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiliangjianceVO> selectListVO(Wrapper<ZhiliangjianceEntity> wrapper);
   	
   	ZhiliangjianceVO selectVO(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);
   	
   	List<ZhiliangjianceView> selectListView(Wrapper<ZhiliangjianceEntity> wrapper);
   	
   	ZhiliangjianceView selectView(@Param("ew") Wrapper<ZhiliangjianceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiliangjianceEntity> wrapper);

   	

}

