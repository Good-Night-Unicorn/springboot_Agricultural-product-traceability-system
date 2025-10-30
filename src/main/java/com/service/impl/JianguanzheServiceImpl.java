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


import com.dao.JianguanzheDao;
import com.entity.JianguanzheEntity;
import com.service.JianguanzheService;
import com.entity.vo.JianguanzheVO;
import com.entity.view.JianguanzheView;

@Service("jianguanzheService")
public class JianguanzheServiceImpl extends ServiceImpl<JianguanzheDao, JianguanzheEntity> implements JianguanzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianguanzheEntity> page = this.selectPage(
                new Query<JianguanzheEntity>(params).getPage(),
                new EntityWrapper<JianguanzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianguanzheEntity> wrapper) {
		  Page<JianguanzheView> page =new Query<JianguanzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianguanzheVO> selectListVO(Wrapper<JianguanzheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianguanzheVO selectVO(Wrapper<JianguanzheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianguanzheView> selectListView(Wrapper<JianguanzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianguanzheView selectView(Wrapper<JianguanzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
