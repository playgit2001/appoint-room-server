package com.wfuhui.modules.settings.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.settings.entity.SettingEntity;
import com.wfuhui.modules.settings.service.SettingService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 预约设置
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
@RestController
@RequestMapping("setting")
public class SettingController {
	@Autowired
	private SettingService settingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SettingEntity> settingList = settingService.queryList(query);
		int total = settingService.queryTotal(query);
		
		return R.ok().put("rows", settingList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		SettingEntity setting = settingService.queryObject(id);
		
		return R.ok().put("setting", setting);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SettingEntity setting){
		settingService.save(setting);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SettingEntity setting){
		settingService.update(setting);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		settingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
