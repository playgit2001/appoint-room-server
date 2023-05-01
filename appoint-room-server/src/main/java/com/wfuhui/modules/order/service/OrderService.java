package com.wfuhui.modules.order.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.order.entity.OrderEntity;

/**
 * 预约
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public interface OrderService {
	
	OrderEntity queryObject(Integer id);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void complete(Integer[] ids);

	List<Map<String, String>> queryOrderCount();
}
