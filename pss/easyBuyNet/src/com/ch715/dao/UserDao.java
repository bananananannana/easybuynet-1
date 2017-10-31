package com.ch715.dao;

import com.ch715.entity.User;

public interface UserDao {

	public User	loginUser(String loginName,String password);
}
