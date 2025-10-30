package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.JianguanzheEntity;
import com.entity.view.JianguanzheView;

import com.service.JianguanzheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 监管者
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-23 16:42:55
 */
@RestController
@RequestMapping("/jianguanzhe")
public class JianguanzheController {
    @Autowired
    private JianguanzheService jianguanzheService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        JianguanzheEntity u = jianguanzheService.selectOne(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"jianguanzhe",  "监管者" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JianguanzheEntity jianguanzhe){
    	//ValidatorUtils.validateEntity(jianguanzhe);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	JianguanzheEntity u = jianguanzheService.selectOne(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同监管者账号，否则返回错误信息
        if(jianguanzheService.selectCount(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()))>0) {
            return R.error("监管者账号已存在");
        }
		Long uId = new Date().getTime();
		jianguanzhe.setId(uId);
        //保存用户
        jianguanzheService.insert(jianguanzhe);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JianguanzheEntity u = jianguanzheService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        JianguanzheEntity u = jianguanzheService.selectOne(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        jianguanzheService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianguanzheEntity jianguanzhe,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianguanzheEntity> ew = new EntityWrapper<JianguanzheEntity>();


        //查询结果
		PageUtils page = jianguanzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianguanzhe), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JianguanzheEntity jianguanzhe, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JianguanzheEntity> ew = new EntityWrapper<JianguanzheEntity>();

        //查询结果
		PageUtils page = jianguanzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianguanzhe), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianguanzheEntity jianguanzhe){
       	EntityWrapper<JianguanzheEntity> ew = new EntityWrapper<JianguanzheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianguanzhe, "jianguanzhe")); 
        return R.ok().put("data", jianguanzheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianguanzheEntity jianguanzhe){
        EntityWrapper< JianguanzheEntity> ew = new EntityWrapper< JianguanzheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianguanzhe, "jianguanzhe")); 
		JianguanzheView jianguanzheView =  jianguanzheService.selectView(ew);
		return R.ok("查询监管者成功").put("data", jianguanzheView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianguanzheEntity jianguanzhe = jianguanzheService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianguanzhe,deSens);
        return R.ok().put("data", jianguanzhe);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianguanzheEntity jianguanzhe = jianguanzheService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jianguanzhe,deSens);
        return R.ok().put("data", jianguanzhe);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianguanzheEntity jianguanzhe, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jianguanzheService.selectCount(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()))>0) {
            return R.error("监管者账号已存在");
        }
        //ValidatorUtils.validateEntity(jianguanzhe);
        //验证账号唯一性，否则返回错误信息
        JianguanzheEntity u = jianguanzheService.selectOne(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jianguanzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jianguanzhe.setId(new Date().getTime());
        jianguanzheService.insert(jianguanzhe);
        return R.ok().put("data",jianguanzhe.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianguanzheEntity jianguanzhe, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jianguanzheService.selectCount(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()))>0) {
            return R.error("监管者账号已存在");
        }
        //ValidatorUtils.validateEntity(jianguanzhe);
        //验证账号唯一性，否则返回错误信息
        JianguanzheEntity u = jianguanzheService.selectOne(new EntityWrapper<JianguanzheEntity>().eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jianguanzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jianguanzhe.setId(new Date().getTime());
        jianguanzheService.insert(jianguanzhe);
        return R.ok().put("data",jianguanzhe.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianguanzheEntity jianguanzhe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianguanzhe);
        //验证字段唯一性，否则返回错误信息
        if(jianguanzheService.selectCount(new EntityWrapper<JianguanzheEntity>().ne("id", jianguanzhe.getId()).eq("jianguanzhezhanghao", jianguanzhe.getJianguanzhezhanghao()))>0) {
            return R.error("监管者账号已存在");
        }
        //全部更新
        jianguanzheService.updateById(jianguanzhe);
        if(null!=jianguanzhe.getJianguanzhezhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(jianguanzhe.getJianguanzhezhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", jianguanzhe.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianguanzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
