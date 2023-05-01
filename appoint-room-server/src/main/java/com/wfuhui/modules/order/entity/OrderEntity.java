package com.wfuhui.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wfuhui.modules.member.entity.MemberEntity;
import com.wfuhui.modules.room.entity.RoomEntity;


/**
 * 预约预约
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	// 预约编号
	private String orderNumber;
	//房间
	private Integer roomId;
	
	private String roomName;
	//用户
	private Long userId;
	//预约时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date appointTime;
	//创建时间
	private Date createTime;
	
	private RoomEntity room;
	
	private MemberEntity user;
	
	private Integer status;
	
	private BigDecimal totalAmount;
	
	private Integer timeId;
	
	private String time;
	
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：房间
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取：房间
	 */
	public Integer getRoomId() {
		return roomId;
	}
	/**
	 * 设置：用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：预约时间
	 */
	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getAppointTime() {
		return appointTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	public RoomEntity getRoom() {
		return room;
	}
	
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	
	public MemberEntity getUser() {
		return user;
	}
	
	public void setUser(MemberEntity user) {
		this.user = user;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Integer getTimeId() {
		return timeId;
	}
	
	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
}
