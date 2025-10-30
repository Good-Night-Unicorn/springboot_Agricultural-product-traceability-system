package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchanpinjichuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchanpinjichuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinjichuxinxiView;


/**
 * 农产品基础信息
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface NongchanpinjichuxinxiService extends IService<NongchanpinjichuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinjichuxinxiVO> selectListVO(Wrapper<NongchanpinjichuxinxiEntity> wrapper);
   	
   	NongchanpinjichuxinxiVO selectVO(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);
   	
   	List<NongchanpinjichuxinxiView> selectListView(Wrapper<NongchanpinjichuxinxiEntity> wrapper);
   	
   	NongchanpinjichuxinxiView selectView(@Param("ew") Wrapper<NongchanpinjichuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinjichuxinxiEntity> wrapper);

   	

}

