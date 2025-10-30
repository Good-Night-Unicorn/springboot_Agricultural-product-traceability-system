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

import com.entity.ShouhuoxinxiEntity;
import com.entity.view.ShouhuoxinxiView;

import com.service.ShouhuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 收货信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:56
 */
@RestController
@RequestMapping("/shouhuoxinxi")
public class ShouhuoxinxiController {
    @Autowired
    private ShouhuoxinxiService shouhuoxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShouhuoxinxiEntity shouhuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingxiaoshang")) {
			shouhuoxinxi.setJingxiaoshanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			shouhuoxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShouhuoxinxiEntity> ew = new EntityWrapper<ShouhuoxinxiEntity>();


        //查询结果
		PageUtils page = shouhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shouhuoxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShouhuoxinxiEntity shouhuoxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShouhuoxinxiEntity> ew = new EntityWrapper<ShouhuoxinxiEntity>();

        //查询结果
		PageUtils page = shouhuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shouhuoxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShouhuoxinxiEntity shouhuoxinxi){
       	EntityWrapper<ShouhuoxinxiEntity> ew = new EntityWrapper<ShouhuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shouhuoxinxi, "shouhuoxinxi")); 
        return R.ok().put("data", shouhuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShouhuoxinxiEntity shouhuoxinxi){
        EntityWrapper< ShouhuoxinxiEntity> ew = new EntityWrapper< ShouhuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shouhuoxinxi, "shouhuoxinxi")); 
		ShouhuoxinxiView shouhuoxinxiView =  shouhuoxinxiService.selectView(ew);
		return R.ok("查询收货信息成功").put("data", shouhuoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShouhuoxinxiEntity shouhuoxinxi = shouhuoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shouhuoxinxi,deSens);
        return R.ok().put("data", shouhuoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShouhuoxinxiEntity shouhuoxinxi = shouhuoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shouhuoxinxi,deSens);
        return R.ok().put("data", shouhuoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShouhuoxinxiEntity shouhuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shouhuoxinxi);
        shouhuoxinxiService.insert(shouhuoxinxi);
        return R.ok().put("data",shouhuoxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShouhuoxinxiEntity shouhuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shouhuoxinxi);
        shouhuoxinxiService.insert(shouhuoxinxi);
        return R.ok().put("data",shouhuoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShouhuoxinxiEntity shouhuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shouhuoxinxi);
        //全部更新
        shouhuoxinxiService.updateById(shouhuoxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shouhuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
