package com.wfuhui.modules.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.order.dao.OrderDao;
import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.order.service.OrderService;
import com.wfuhui.modules.settings.dao.TimeDao;
import com.wfuhui.modules.settings.entity.TimeEntity;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TimeDao timeDao;
	
	@Override
	public OrderEntity queryObject(Integer id){
		return orderDao.queryObject(id);
	}
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map){
		return orderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
		TimeEntity time = new TimeEntity();
		time.setId(order.getTimeId());
		timeDao.update(time);
	}
	
	@Override
	public void delete(Integer id){
		orderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderDao.deleteBatch(ids);
	}

	@Override
	public void complete(Integer[] ids) {
		for (Integer id : ids) {
			OrderEntity order = new OrderEntity();
			order.setId(id);
			order.setStatus(2);
			orderDao.update(order);
		}
	}

	@Override
	public List<Map<String, String>> queryOrderCount() {
		return orderDao.queryOrderCount();
	}
	
}
