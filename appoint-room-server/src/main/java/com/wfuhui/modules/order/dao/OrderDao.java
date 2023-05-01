package com.wfuhui.modules.order.dao;

import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 预约
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {

	List<Map<String, String>> queryOrderCount();
	
}
