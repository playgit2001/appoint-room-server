package com.wfuhui.modules.room.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.room.entity.RoomEntity;
import com.wfuhui.modules.room.service.RoomService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;

/**
 * 房间
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<RoomEntity> roomList = roomService.queryList(params);
		return R.ok().put("roomList", roomList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RoomEntity> roomList = roomService.queryList(query);
		int total = roomService.queryTotal(query);
		
		return R.ok().put("rows", roomList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RoomEntity room = roomService.queryObject(id);
		
		return R.ok().put("room", room);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody RoomEntity room){
		room.setCreateTime(new Date());
		roomService.save(room);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody RoomEntity room){
		roomService.update(room);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		roomService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
