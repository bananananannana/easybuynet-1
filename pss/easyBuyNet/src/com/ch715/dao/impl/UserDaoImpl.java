package com.ch715.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ch715.dao.BaseDao;
import com.ch715.dao.UserDao;
import com.ch715.entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User loginUser(String loginName, String password) {
		String sql="select * from easyBuy_User where loginName=? and password=?";
		List<User> list= super.executeQuery(sql, new Object[]{loginName,password});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User getEntity(ResultSet rs) {
			User user=null;
		if(rs!=null){		
			try {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String loginName = rs.getString("loginName");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				int type = rs.getInt("type");
				user=new User(id, userName, loginName, password, sex, identityCode, email, mobile, type);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return user;
	}

	
}
