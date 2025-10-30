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


import com.dao.XiaofeizheDao;
import com.entity.XiaofeizheEntity;
import com.service.XiaofeizheService;
import com.entity.vo.XiaofeizheVO;
import com.entity.view.XiaofeizheView;

@Service("xiaofeizheService")
public class XiaofeizheServiceImpl extends ServiceImpl<XiaofeizheDao, XiaofeizheEntity> implements XiaofeizheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaofeizheEntity> page = this.selectPage(
                new Query<XiaofeizheEntity>(params).getPage(),
                new EntityWrapper<XiaofeizheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaofeizheEntity> wrapper) {
		  Page<XiaofeizheView> page =new Query<XiaofeizheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XiaofeizheVO> selectListVO(Wrapper<XiaofeizheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaofeizheVO selectVO(Wrapper<XiaofeizheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaofeizheView> selectListView(Wrapper<XiaofeizheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaofeizheView selectView(Wrapper<XiaofeizheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
