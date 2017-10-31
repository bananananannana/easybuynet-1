package com.ch715.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public abstract class BaseDao<T> {
	private Logger logger = Logger.getLogger(BaseDao.class);

	/**
	 * 获得连接
	 * 
	 * @return 连接对象
	 */
	public Connection getConnection() {
		Connection conn = null;
		Context ct;
		try {
			ct = new InitialContext();
			DataSource dSource = (DataSource) ct.lookup("java:comp/env/jdbc/news");
			conn = dSource.getConnection();			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 增删改
	 * 
	 * @param sql
	 * @param params
	 * @return 影响的行数
	 */
	public int executeUpdate(String sql, Object[] params) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			// 创建语句集对象
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			logger.debug(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			closeResource(conn, null, ps, null);
		}
		return -1;
	}

	/**
	 * 查
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> executeQuery(String sql, Object[] params) {
		// 1.获得连接
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<T> list = new ArrayList<T>();
		try {
			// 2.获得语句集对象
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}

			rs = ps.executeQuery();
			// 处理数据
			while (rs.next()) {
				T t = getEntity(rs);
				list.add(t);
			}
			logger.debug(sql);
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			closeResource(conn, null, ps, rs);
		}
		return null;
	}

	public Integer executeQueryMaxId(String sql) {
		// 1.获得连接
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 2.获得语句集对象
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			// 处理数据
			if (rs.next()) {
				logger.debug(sql);

				return rs.getInt(1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {
			closeResource(conn, null, ps, rs);
		}
		return null;
	}

	/**
	 * 把表中的记录转换成JavaBean 获得实体对象的方法，由具体的DaoImpl实现
	 * 
	 * @param rs
	 * @return
	 */
	public abstract T getEntity(ResultSet rs);

	/**
	 * 关闭资
	 * 
	 * @param conn
	 * @param stmt
	 * @param ps
	 * @param rs
	 */
	public void closeResource(Connection conn, Statement stmt,
			PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
