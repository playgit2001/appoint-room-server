package com.wfuhui.modules.settings.dao;

import com.wfuhui.modules.settings.entity.TimeEntity;
import com.wfuhui.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 预约时间
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
@Mapper
public interface TimeDao extends BaseDao<TimeEntity> {

	void delPeople(Integer timeId);
	
	void addPeople(Integer timeId);
	
}
