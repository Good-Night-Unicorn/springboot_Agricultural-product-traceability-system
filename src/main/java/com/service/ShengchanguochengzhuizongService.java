package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShengchanguochengzhuizongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShengchanguochengzhuizongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShengchanguochengzhuizongView;


/**
 * 生产过程追踪
 *
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
public interface ShengchanguochengzhuizongService extends IService<ShengchanguochengzhuizongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShengchanguochengzhuizongVO> selectListVO(Wrapper<ShengchanguochengzhuizongEntity> wrapper);
   	
   	ShengchanguochengzhuizongVO selectVO(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);
   	
   	List<ShengchanguochengzhuizongView> selectListView(Wrapper<ShengchanguochengzhuizongEntity> wrapper);
   	
   	ShengchanguochengzhuizongView selectView(@Param("ew") Wrapper<ShengchanguochengzhuizongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShengchanguochengzhuizongEntity> wrapper);

   	

}

