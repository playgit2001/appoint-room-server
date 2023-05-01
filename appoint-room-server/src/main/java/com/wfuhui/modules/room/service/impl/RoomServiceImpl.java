package com.wfuhui.modules.room.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.room.dao.RoomDao;
import com.wfuhui.modules.room.entity.RoomEntity;
import com.wfuhui.modules.room.service.RoomService;



@Service("labService")
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao labDao;
	
	@Override
	public RoomEntity queryObject(Integer id){
		return labDao.queryObject(id);
	}
	
	@Override
	public List<RoomEntity> queryList(Map<String, Object> map){
		return labDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return labDao.queryTotal(map);
	}
	
	@Override
	public void save(RoomEntity lab){
		labDao.save(lab);
	}
	
	@Override
	public void update(RoomEntity lab){
		labDao.update(lab);
	}
	
	@Override
	public void delete(Integer id){
		labDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		labDao.deleteBatch(ids);
	}
	
}
