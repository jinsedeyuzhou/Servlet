package com.ebrightmoon.dao;

import com.ebrightmoon.bean.UserInfo;

public interface UserDao {

	public UserInfo selectUserByName(String name);

	public UserInfo selectUserByName(String name, String pwd);

	public Integer insertUser(UserInfo user);


	public Integer updateUser(UserInfo user);

}
