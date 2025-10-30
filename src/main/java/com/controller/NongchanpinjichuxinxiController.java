package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.NongchanpinjichuxinxiEntity;
import com.entity.view.NongchanpinjichuxinxiView;

import com.service.NongchanpinjichuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品基础信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/nongchanpinjichuxinxi")
public class NongchanpinjichuxinxiController {
    @Autowired
    private NongchanpinjichuxinxiService nongchanpinjichuxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinjichuxinxiEntity nongchanpinjichuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shengchanzhe")) {
			nongchanpinjichuxinxi.setShengchanzhehao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<NongchanpinjichuxinxiEntity> ew = new EntityWrapper<NongchanpinjichuxinxiEntity>();


        //查询结果
		PageUtils page = nongchanpinjichuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjichuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinjichuxinxiEntity nongchanpinjichuxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongchanpinjichuxinxiEntity> ew = new EntityWrapper<NongchanpinjichuxinxiEntity>();

        //查询结果
		PageUtils page = nongchanpinjichuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinjichuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinjichuxinxiEntity nongchanpinjichuxinxi){
       	EntityWrapper<NongchanpinjichuxinxiEntity> ew = new EntityWrapper<NongchanpinjichuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinjichuxinxi, "nongchanpinjichuxinxi")); 
        return R.ok().put("data", nongchanpinjichuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinjichuxinxiEntity nongchanpinjichuxinxi){
        EntityWrapper< NongchanpinjichuxinxiEntity> ew = new EntityWrapper< NongchanpinjichuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinjichuxinxi, "nongchanpinjichuxinxi")); 
		NongchanpinjichuxinxiView nongchanpinjichuxinxiView =  nongchanpinjichuxinxiService.selectView(ew);
		return R.ok("查询农产品基础信息成功").put("data", nongchanpinjichuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinjichuxinxiEntity nongchanpinjichuxinxi = nongchanpinjichuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongchanpinjichuxinxi,deSens);
        return R.ok().put("data", nongchanpinjichuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinjichuxinxiEntity nongchanpinjichuxinxi = nongchanpinjichuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongchanpinjichuxinxi,deSens);
        return R.ok().put("data", nongchanpinjichuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinjichuxinxiEntity nongchanpinjichuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinjichuxinxi);
        nongchanpinjichuxinxiService.insert(nongchanpinjichuxinxi);
        return R.ok().put("data",nongchanpinjichuxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinjichuxinxiEntity nongchanpinjichuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinjichuxinxi);
        nongchanpinjichuxinxiService.insert(nongchanpinjichuxinxi);
        return R.ok().put("data",nongchanpinjichuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinjichuxinxiEntity nongchanpinjichuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinjichuxinxi);
        //全部更新
        nongchanpinjichuxinxiService.updateById(nongchanpinjichuxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinjichuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
