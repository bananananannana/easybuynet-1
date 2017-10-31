package com.ch715.entity;

import java.io.Serializable;

public class ProductCategory implements Serializable{

	private int id;
	private String name;
	private int parentId;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(int id, String name, int parentId, int type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", type=" + type + "]";
	}

}
