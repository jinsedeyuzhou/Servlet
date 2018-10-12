package com.ebrightmoon.dao;

import com.ebrightmoon.bean.UserInfo;

public interface UserDao {

	/**
	 * 根据手机号查询
	 * @param name
	 * @return
	 */
	public UserInfo selectUserByName(String mobile);

	/**
	 * 根据手机号和密码查询用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo selectUserByName(String mobile, String pwd);
	
	/**
	 * 查找用户
	 * @param user
	 * @return
	 */
	public UserInfo selectUser(UserInfo user);

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public Integer insertUser(UserInfo user);

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(UserInfo user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public Integer deleteUser(UserInfo user);

}
