package com.ch715.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	private int id;
	private int userId;
	private String loginName;
	private String userAddress;
	private Date createTime;
	private float cost;
	private int status;
	private int type;
	private String serialNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int userId, String loginName, String userAddress,
			Date createTime, float cost, int status, int type,
			String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", loginName="
				+ loginName + ", userAddress=" + userAddress + ", createTime="
				+ createTime + ", cost=" + cost + ", status=" + status
				+ ", type=" + type + ", serialNumber=" + serialNumber + "]";
	}

}
