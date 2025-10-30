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


import com.dao.ShengchanzheDao;
import com.entity.ShengchanzheEntity;
import com.service.ShengchanzheService;
import com.entity.vo.ShengchanzheVO;
import com.entity.view.ShengchanzheView;

@Service("shengchanzheService")
public class ShengchanzheServiceImpl extends ServiceImpl<ShengchanzheDao, ShengchanzheEntity> implements ShengchanzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShengchanzheEntity> page = this.selectPage(
                new Query<ShengchanzheEntity>(params).getPage(),
                new EntityWrapper<ShengchanzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShengchanzheEntity> wrapper) {
		  Page<ShengchanzheView> page =new Query<ShengchanzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShengchanzheVO> selectListVO(Wrapper<ShengchanzheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShengchanzheVO selectVO(Wrapper<ShengchanzheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShengchanzheView> selectListView(Wrapper<ShengchanzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShengchanzheView selectView(Wrapper<ShengchanzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
