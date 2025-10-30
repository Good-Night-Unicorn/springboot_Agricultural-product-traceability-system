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

import com.entity.ShengchanguochengzhuizongEntity;
import com.entity.view.ShengchanguochengzhuizongView;

import com.service.ShengchanguochengzhuizongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 生产过程追踪
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/shengchanguochengzhuizong")
public class ShengchanguochengzhuizongController {
    @Autowired
    private ShengchanguochengzhuizongService shengchanguochengzhuizongService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShengchanguochengzhuizongEntity shengchanguochengzhuizong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shengchanzhe")) {
			shengchanguochengzhuizong.setShengchanzhehao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShengchanguochengzhuizongEntity> ew = new EntityWrapper<ShengchanguochengzhuizongEntity>();


        //查询结果
		PageUtils page = shengchanguochengzhuizongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengchanguochengzhuizong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShengchanguochengzhuizongEntity shengchanguochengzhuizong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShengchanguochengzhuizongEntity> ew = new EntityWrapper<ShengchanguochengzhuizongEntity>();

        //查询结果
		PageUtils page = shengchanguochengzhuizongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shengchanguochengzhuizong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShengchanguochengzhuizongEntity shengchanguochengzhuizong){
       	EntityWrapper<ShengchanguochengzhuizongEntity> ew = new EntityWrapper<ShengchanguochengzhuizongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shengchanguochengzhuizong, "shengchanguochengzhuizong")); 
        return R.ok().put("data", shengchanguochengzhuizongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShengchanguochengzhuizongEntity shengchanguochengzhuizong){
        EntityWrapper< ShengchanguochengzhuizongEntity> ew = new EntityWrapper< ShengchanguochengzhuizongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shengchanguochengzhuizong, "shengchanguochengzhuizong")); 
		ShengchanguochengzhuizongView shengchanguochengzhuizongView =  shengchanguochengzhuizongService.selectView(ew);
		return R.ok("查询生产过程追踪成功").put("data", shengchanguochengzhuizongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShengchanguochengzhuizongEntity shengchanguochengzhuizong = shengchanguochengzhuizongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shengchanguochengzhuizong,deSens);
        return R.ok().put("data", shengchanguochengzhuizong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShengchanguochengzhuizongEntity shengchanguochengzhuizong = shengchanguochengzhuizongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shengchanguochengzhuizong,deSens);
        return R.ok().put("data", shengchanguochengzhuizong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShengchanguochengzhuizongEntity shengchanguochengzhuizong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shengchanguochengzhuizong);
        shengchanguochengzhuizongService.insert(shengchanguochengzhuizong);
        return R.ok().put("data",shengchanguochengzhuizong.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShengchanguochengzhuizongEntity shengchanguochengzhuizong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shengchanguochengzhuizong);
        shengchanguochengzhuizongService.insert(shengchanguochengzhuizong);
        return R.ok().put("data",shengchanguochengzhuizong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShengchanguochengzhuizongEntity shengchanguochengzhuizong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shengchanguochengzhuizong);
        //全部更新
        shengchanguochengzhuizongService.updateById(shengchanguochengzhuizong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shengchanguochengzhuizongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
