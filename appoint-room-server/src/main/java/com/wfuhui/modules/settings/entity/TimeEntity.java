package com.wfuhui.modules.settings.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 预约时间
 */
public class TimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//房间id
	private Integer roomId;
	//预约日期
	private Date appointDate;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//状态
	private Integer status;

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
	 * 设置：房间id
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取：房间id
	 */
	public Integer getRoomId() {
		return roomId;
	}
	/**
	 * 设置：预约日期
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	/**
	 * 获取：预约日期
	 */
	public Date getAppointDate() {
		return appointDate;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	
}
