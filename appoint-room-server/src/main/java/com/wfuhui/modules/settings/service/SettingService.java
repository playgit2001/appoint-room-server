package com.wfuhui.modules.settings.service;

import com.wfuhui.modules.settings.entity.SettingEntity;

import java.util.List;
import java.util.Map;

/**
 * 预约设置
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public interface SettingService {
	
	SettingEntity queryObject(Integer id);
	
	List<SettingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SettingEntity setting);
	
	void update(SettingEntity setting);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
