package com.wfuhui.modules.room.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 房间
 */
public class RoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//房间名称
	private String roomName;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	
	private String picUrl;
	
	private Integer categoryId;
	
	private CategoryEntity category;
	
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
	 * 设置：房间名称
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * 获取：房间名称
	 */
	public String getRoomName() {
		return roomName;
	}
	
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public CategoryEntity getCategory() {
		return category;
	}
	
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
