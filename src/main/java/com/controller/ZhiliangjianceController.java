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

import com.entity.ZhiliangjianceEntity;
import com.entity.view.ZhiliangjianceView;

import com.service.ZhiliangjianceService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 质量检测
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/zhiliangjiance")
public class ZhiliangjianceController {
    @Autowired
    private ZhiliangjianceService zhiliangjianceService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiliangjianceEntity zhiliangjiance,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingxiaoshang")) {
			zhiliangjiance.setJingxiaoshanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jianguanzhe")) {
			zhiliangjiance.setJianguanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZhiliangjianceEntity> ew = new EntityWrapper<ZhiliangjianceEntity>();


        //查询结果
		PageUtils page = zhiliangjianceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiliangjiance), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhiliangjianceEntity zhiliangjiance, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhiliangjianceEntity> ew = new EntityWrapper<ZhiliangjianceEntity>();

        //查询结果
		PageUtils page = zhiliangjianceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiliangjiance), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiliangjianceEntity zhiliangjiance){
       	EntityWrapper<ZhiliangjianceEntity> ew = new EntityWrapper<ZhiliangjianceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiliangjiance, "zhiliangjiance")); 
        return R.ok().put("data", zhiliangjianceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiliangjianceEntity zhiliangjiance){
        EntityWrapper< ZhiliangjianceEntity> ew = new EntityWrapper< ZhiliangjianceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiliangjiance, "zhiliangjiance")); 
		ZhiliangjianceView zhiliangjianceView =  zhiliangjianceService.selectView(ew);
		return R.ok("查询质量检测成功").put("data", zhiliangjianceView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiliangjianceEntity zhiliangjiance = zhiliangjianceService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhiliangjiance,deSens);
        return R.ok().put("data", zhiliangjiance);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiliangjianceEntity zhiliangjiance = zhiliangjianceService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhiliangjiance,deSens);
        return R.ok().put("data", zhiliangjiance);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiliangjianceEntity zhiliangjiance, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiliangjiance);
        zhiliangjianceService.insert(zhiliangjiance);
        return R.ok().put("data",zhiliangjiance.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiliangjianceEntity zhiliangjiance, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiliangjiance);
        zhiliangjianceService.insert(zhiliangjiance);
        return R.ok().put("data",zhiliangjiance.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiliangjianceEntity zhiliangjiance, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiliangjiance);
        //全部更新
        zhiliangjianceService.updateById(zhiliangjiance);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiliangjianceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
