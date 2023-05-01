package com.wfuhui.modules.room.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.room.entity.RoomEntity;

/**
 * 房间
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-12-01 11:32:48
 */
public interface RoomService {
	
	RoomEntity queryObject(Integer id);
	
	List<RoomEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RoomEntity room);
	
	void update(RoomEntity room);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
