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

import com.entity.JiagonghuanjieEntity;
import com.entity.view.JiagonghuanjieView;

import com.service.JiagonghuanjieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 加工环节
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/jiagonghuanjie")
public class JiagonghuanjieController {
    @Autowired
    private JiagonghuanjieService jiagonghuanjieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiagonghuanjieEntity jiagonghuanjie,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingxiaoshang")) {
			jiagonghuanjie.setJingxiaoshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiagonghuanjieEntity> ew = new EntityWrapper<JiagonghuanjieEntity>();


        //查询结果
		PageUtils page = jiagonghuanjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiagonghuanjie), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiagonghuanjieEntity jiagonghuanjie, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiagonghuanjieEntity> ew = new EntityWrapper<JiagonghuanjieEntity>();

        //查询结果
		PageUtils page = jiagonghuanjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiagonghuanjie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiagonghuanjieEntity jiagonghuanjie){
       	EntityWrapper<JiagonghuanjieEntity> ew = new EntityWrapper<JiagonghuanjieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiagonghuanjie, "jiagonghuanjie")); 
        return R.ok().put("data", jiagonghuanjieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiagonghuanjieEntity jiagonghuanjie){
        EntityWrapper< JiagonghuanjieEntity> ew = new EntityWrapper< JiagonghuanjieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiagonghuanjie, "jiagonghuanjie")); 
		JiagonghuanjieView jiagonghuanjieView =  jiagonghuanjieService.selectView(ew);
		return R.ok("查询加工环节成功").put("data", jiagonghuanjieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiagonghuanjieEntity jiagonghuanjie = jiagonghuanjieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiagonghuanjie,deSens);
        return R.ok().put("data", jiagonghuanjie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiagonghuanjieEntity jiagonghuanjie = jiagonghuanjieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiagonghuanjie,deSens);
        return R.ok().put("data", jiagonghuanjie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiagonghuanjieEntity jiagonghuanjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiagonghuanjie);
        jiagonghuanjieService.insert(jiagonghuanjie);
        return R.ok().put("data",jiagonghuanjie.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiagonghuanjieEntity jiagonghuanjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiagonghuanjie);
        jiagonghuanjieService.insert(jiagonghuanjie);
        return R.ok().put("data",jiagonghuanjie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiagonghuanjieEntity jiagonghuanjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiagonghuanjie);
        //全部更新
        jiagonghuanjieService.updateById(jiagonghuanjie);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiagonghuanjieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
