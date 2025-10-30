package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NongchanpinjichuxinxiDao;
import com.entity.NongchanpinjichuxinxiEntity;
import com.service.NongchanpinjichuxinxiService;
import com.entity.vo.NongchanpinjichuxinxiVO;
import com.entity.view.NongchanpinjichuxinxiView;

@Service("nongchanpinjichuxinxiService")
public class NongchanpinjichuxinxiServiceImpl extends ServiceImpl<NongchanpinjichuxinxiDao, NongchanpinjichuxinxiEntity> implements NongchanpinjichuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanpinjichuxinxiEntity> page = this.selectPage(
                new Query<NongchanpinjichuxinxiEntity>(params).getPage(),
                new EntityWrapper<NongchanpinjichuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanpinjichuxinxiEntity> wrapper) {
		  Page<NongchanpinjichuxinxiView> page =new Query<NongchanpinjichuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<NongchanpinjichuxinxiVO> selectListVO(Wrapper<NongchanpinjichuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchanpinjichuxinxiVO selectVO(Wrapper<NongchanpinjichuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchanpinjichuxinxiView> selectListView(Wrapper<NongchanpinjichuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanpinjichuxinxiView selectView(Wrapper<NongchanpinjichuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
