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


import com.dao.JiagonghuanjieDao;
import com.entity.JiagonghuanjieEntity;
import com.service.JiagonghuanjieService;
import com.entity.vo.JiagonghuanjieVO;
import com.entity.view.JiagonghuanjieView;

@Service("jiagonghuanjieService")
public class JiagonghuanjieServiceImpl extends ServiceImpl<JiagonghuanjieDao, JiagonghuanjieEntity> implements JiagonghuanjieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiagonghuanjieEntity> page = this.selectPage(
                new Query<JiagonghuanjieEntity>(params).getPage(),
                new EntityWrapper<JiagonghuanjieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiagonghuanjieEntity> wrapper) {
		  Page<JiagonghuanjieView> page =new Query<JiagonghuanjieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiagonghuanjieVO> selectListVO(Wrapper<JiagonghuanjieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiagonghuanjieVO selectVO(Wrapper<JiagonghuanjieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiagonghuanjieView> selectListView(Wrapper<JiagonghuanjieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiagonghuanjieView selectView(Wrapper<JiagonghuanjieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
