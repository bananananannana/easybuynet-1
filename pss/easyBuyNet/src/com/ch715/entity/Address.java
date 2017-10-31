package com.ch715.entity;

import java.io.Serializable;

public class Address implements Serializable {

	private int id;
	private String address;
	private String createTime;
	private int userId;
	private int isDefault;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String address, String createTime, int userId,
			int isDefault, String remark) {
		super();
		this.id = id;
		this.address = address;
		this.createTime = createTime;
		this.userId = userId;
		this.isDefault = isDefault;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", createTime="
				+ createTime + ", userId=" + userId + ", isDefault="
				+ isDefault + ", remark=" + remark + "]";
	}

}
