package com.ebrightmoon.dao;

import com.ebrightmoon.bean.UserInfo;

public interface UserDao {

	/**
	 * @param name
	 * @return
	 */
	public UserInfo selectUserByName(String name);

	/**
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo selectUserByName(String name, String pwd);
	
	/**
	 * @param user
	 * @return
	 */
	public UserInfo selectUser(UserInfo user);

	/**
	 * @param user
	 * @return
	 */
	public Integer insertUser(UserInfo user);

	/**
	 * @param user
	 * @return
	 */
	public Integer updateUser(UserInfo user);
	
	/**
	 * @param user
	 * @return
	 */
	public Integer deleteUser(UserInfo user);

}
