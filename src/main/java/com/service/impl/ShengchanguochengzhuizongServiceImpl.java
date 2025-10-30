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


import com.dao.ShengchanguochengzhuizongDao;
import com.entity.ShengchanguochengzhuizongEntity;
import com.service.ShengchanguochengzhuizongService;
import com.entity.vo.ShengchanguochengzhuizongVO;
import com.entity.view.ShengchanguochengzhuizongView;

@Service("shengchanguochengzhuizongService")
public class ShengchanguochengzhuizongServiceImpl extends ServiceImpl<ShengchanguochengzhuizongDao, ShengchanguochengzhuizongEntity> implements ShengchanguochengzhuizongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShengchanguochengzhuizongEntity> page = this.selectPage(
                new Query<ShengchanguochengzhuizongEntity>(params).getPage(),
                new EntityWrapper<ShengchanguochengzhuizongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShengchanguochengzhuizongEntity> wrapper) {
		  Page<ShengchanguochengzhuizongView> page =new Query<ShengchanguochengzhuizongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShengchanguochengzhuizongVO> selectListVO(Wrapper<ShengchanguochengzhuizongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShengchanguochengzhuizongVO selectVO(Wrapper<ShengchanguochengzhuizongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShengchanguochengzhuizongView> selectListView(Wrapper<ShengchanguochengzhuizongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShengchanguochengzhuizongView selectView(Wrapper<ShengchanguochengzhuizongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
