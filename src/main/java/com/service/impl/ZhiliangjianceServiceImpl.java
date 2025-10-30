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


import com.dao.ZhiliangjianceDao;
import com.entity.ZhiliangjianceEntity;
import com.service.ZhiliangjianceService;
import com.entity.vo.ZhiliangjianceVO;
import com.entity.view.ZhiliangjianceView;

@Service("zhiliangjianceService")
public class ZhiliangjianceServiceImpl extends ServiceImpl<ZhiliangjianceDao, ZhiliangjianceEntity> implements ZhiliangjianceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiliangjianceEntity> page = this.selectPage(
                new Query<ZhiliangjianceEntity>(params).getPage(),
                new EntityWrapper<ZhiliangjianceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiliangjianceEntity> wrapper) {
		  Page<ZhiliangjianceView> page =new Query<ZhiliangjianceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhiliangjianceVO> selectListVO(Wrapper<ZhiliangjianceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiliangjianceVO selectVO(Wrapper<ZhiliangjianceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiliangjianceView> selectListView(Wrapper<ZhiliangjianceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiliangjianceView selectView(Wrapper<ZhiliangjianceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
