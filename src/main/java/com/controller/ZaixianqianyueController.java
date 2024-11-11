package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZaixianqianyueEntity;
import com.entity.view.ZaixianqianyueView;

import com.service.ZaixianqianyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 在线签约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
@RestController
@RequestMapping("/zaixianqianyue")
public class ZaixianqianyueController {
    @Autowired
    private ZaixianqianyueService zaixianqianyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianqianyueEntity zaixianqianyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zaixianqianyue.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianqianyueEntity> ew = new EntityWrapper<ZaixianqianyueEntity>();
		PageUtils page = zaixianqianyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianqianyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianqianyueEntity zaixianqianyue, HttpServletRequest request){
        EntityWrapper<ZaixianqianyueEntity> ew = new EntityWrapper<ZaixianqianyueEntity>();
		PageUtils page = zaixianqianyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianqianyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianqianyueEntity zaixianqianyue){
       	EntityWrapper<ZaixianqianyueEntity> ew = new EntityWrapper<ZaixianqianyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianqianyue, "zaixianqianyue")); 
        return R.ok().put("data", zaixianqianyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianqianyueEntity zaixianqianyue){
        EntityWrapper< ZaixianqianyueEntity> ew = new EntityWrapper< ZaixianqianyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianqianyue, "zaixianqianyue")); 
		ZaixianqianyueView zaixianqianyueView =  zaixianqianyueService.selectView(ew);
		return R.ok("查询在线签约成功").put("data", zaixianqianyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianqianyueEntity zaixianqianyue = zaixianqianyueService.selectById(id);
        return R.ok().put("data", zaixianqianyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianqianyueEntity zaixianqianyue = zaixianqianyueService.selectById(id);
        return R.ok().put("data", zaixianqianyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianqianyueEntity zaixianqianyue, HttpServletRequest request){
    	zaixianqianyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianqianyue);
        zaixianqianyueService.insert(zaixianqianyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianqianyueEntity zaixianqianyue, HttpServletRequest request){
    	zaixianqianyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianqianyue);
        zaixianqianyueService.insert(zaixianqianyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZaixianqianyueEntity zaixianqianyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianqianyue);
        zaixianqianyueService.updateById(zaixianqianyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianqianyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZaixianqianyueEntity> wrapper = new EntityWrapper<ZaixianqianyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianqianyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
