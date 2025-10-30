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

import com.entity.WuliuyunshuEntity;
import com.entity.view.WuliuyunshuView;

import com.service.WuliuyunshuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 物流运输
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:56
 */
@RestController
@RequestMapping("/wuliuyunshu")
public class WuliuyunshuController {
    @Autowired
    private WuliuyunshuService wuliuyunshuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WuliuyunshuEntity wuliuyunshu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingxiaoshang")) {
			wuliuyunshu.setJingxiaoshanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wuliuyunshu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WuliuyunshuEntity> ew = new EntityWrapper<WuliuyunshuEntity>();


        //查询结果
		PageUtils page = wuliuyunshuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuliuyunshu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WuliuyunshuEntity wuliuyunshu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WuliuyunshuEntity> ew = new EntityWrapper<WuliuyunshuEntity>();

        //查询结果
		PageUtils page = wuliuyunshuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wuliuyunshu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WuliuyunshuEntity wuliuyunshu){
       	EntityWrapper<WuliuyunshuEntity> ew = new EntityWrapper<WuliuyunshuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wuliuyunshu, "wuliuyunshu")); 
        return R.ok().put("data", wuliuyunshuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WuliuyunshuEntity wuliuyunshu){
        EntityWrapper< WuliuyunshuEntity> ew = new EntityWrapper< WuliuyunshuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wuliuyunshu, "wuliuyunshu")); 
		WuliuyunshuView wuliuyunshuView =  wuliuyunshuService.selectView(ew);
		return R.ok("查询物流运输成功").put("data", wuliuyunshuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WuliuyunshuEntity wuliuyunshu = wuliuyunshuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wuliuyunshu,deSens);
        return R.ok().put("data", wuliuyunshu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WuliuyunshuEntity wuliuyunshu = wuliuyunshuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wuliuyunshu,deSens);
        return R.ok().put("data", wuliuyunshu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WuliuyunshuEntity wuliuyunshu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuliuyunshu);
        wuliuyunshuService.insert(wuliuyunshu);
        return R.ok().put("data",wuliuyunshu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WuliuyunshuEntity wuliuyunshu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuliuyunshu);
        wuliuyunshuService.insert(wuliuyunshu);
        return R.ok().put("data",wuliuyunshu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WuliuyunshuEntity wuliuyunshu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wuliuyunshu);
        //全部更新
        wuliuyunshuService.updateById(wuliuyunshu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wuliuyunshuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
