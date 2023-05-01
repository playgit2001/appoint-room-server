package com.wfuhui.modules.room.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.room.entity.RoomEntity;
import com.wfuhui.modules.room.service.RoomService;

@RestController
@RequestMapping("/api/room/")
public class ApiRoomController {
	
	@Autowired
	private RoomService roomService;
	
	@AuthIgnore
    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params){
		Query query = new Query(params);
    	List<RoomEntity> roomList = roomService.queryList(query);
        return R.ok().put("roomList", roomList);
    }
    
	@AuthIgnore
    @GetMapping("detail")
    public R detail(Integer id){
    	RoomEntity room = roomService.queryObject(id);
        return R.ok().put("room", room);
    }
}
