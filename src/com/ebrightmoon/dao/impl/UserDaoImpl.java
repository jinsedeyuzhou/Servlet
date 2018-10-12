package com.ebrightmoon.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ebrightmoon.bean.UserInfo;
import com.ebrightmoon.dao.UserDao;
import com.ebrightmoon.utils.JDBCHelper;
import com.ebrightmoon.utils.JDBCUtils;



public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#selectUserByName(java.lang.String)
	 */
	@Override
	public UserInfo selectUserByName(String mobile) {
		// TODO Auto-generated method stub

		try {
			String sql = "SELECT * FROM user_info WHERE mobile=?";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			UserInfo userInfo = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), mobile);
			return userInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#selectUserByName(java.lang.String, java.lang.String)
	 */
	@Override
	public UserInfo selectUserByName(String name, String pwd) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM user_info WHERE user_name=? AND user_pwd=?";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			UserInfo userInfo = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), name,pwd);
			return userInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#selectUser(com.ebrightmoon.bean.UserInfo)
	 */
	@Override
	public UserInfo selectUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM user_info WHERE mobile=? AND user_pwd=?";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			UserInfo user = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), userInfo.getMobile(),userInfo.getUserPwd());
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#insertUser(com.ebrightmoon.bean.UserInfo)
	 */
	@Override
	public Integer insertUser(UserInfo user) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO user_info (user_id,mobile,user_pwd,uuid,token,gen_time) VALUES(null,?,?,?,?,null)";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			Integer result = queryRunner.update(sql,user.getMobile(),user.getUserPwd()
					,user.getUuid(),user.getToken());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#updateUser(com.ebrightmoon.bean.UserInfo)
	 */
	@Override
	public Integer updateUser(UserInfo user) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE  user_info SET userName=?,sex=?,userPwd=?,mobile=?, userEmail=?, loginTime=?,lastLoginTime=?,token=?";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			Integer result = queryRunner.update(sql,user.getUserName(),user.getSex(),user.getUserPwd(),user.getMobile(),user.getUserEmail()
					,user.getLoginTime(),user.getLastLoginTime(),user.getToken());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see com.ebrightmoon.dao.UserDao#deleteUser(com.ebrightmoon.bean.UserInfo)
	 */
	@Override
	public Integer deleteUser(UserInfo user) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM user_info WHERE user_name=?";
			QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
			Integer result = queryRunner.update(sql,user.getUserName());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
