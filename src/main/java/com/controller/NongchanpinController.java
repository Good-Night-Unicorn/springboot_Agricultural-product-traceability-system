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

import com.entity.NongchanpinEntity;
import com.entity.view.NongchanpinView;

import com.service.NongchanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/nongchanpin")
public class NongchanpinController {
    @Autowired
    private NongchanpinService nongchanpinService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinEntity nongchanpin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingxiaoshang")) {
			nongchanpin.setJingxiaoshanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<NongchanpinEntity> ew = new EntityWrapper<NongchanpinEntity>();


        //查询结果
		PageUtils page = nongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,NongchanpinEntity nongchanpin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongchanpinEntity> ew = new EntityWrapper<NongchanpinEntity>();

        //查询结果
		PageUtils page = nongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinEntity nongchanpin){
       	EntityWrapper<NongchanpinEntity> ew = new EntityWrapper<NongchanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpin, "nongchanpin")); 
        return R.ok().put("data", nongchanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinEntity nongchanpin){
        EntityWrapper< NongchanpinEntity> ew = new EntityWrapper< NongchanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpin, "nongchanpin")); 
		NongchanpinView nongchanpinView =  nongchanpinService.selectView(ew);
		return R.ok("查询农产品成功").put("data", nongchanpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinEntity nongchanpin = nongchanpinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongchanpin,deSens);
        return R.ok().put("data", nongchanpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinEntity nongchanpin = nongchanpinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongchanpin,deSens);
        return R.ok().put("data", nongchanpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpin);
        nongchanpinService.insert(nongchanpin);
        return R.ok().put("data",nongchanpin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpin);
        nongchanpinService.insert(nongchanpin);
        return R.ok().put("data",nongchanpin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpin);
        //全部更新
        nongchanpinService.updateById(nongchanpin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
