package com.ebrightmoon.service;

import com.ebrightmoon.bean.UserInfo;

public interface UserService {

	public UserInfo findUserByName(String name);

	public boolean registUser(UserInfo user);

	public UserInfo login(UserInfo user);

	public boolean modifyUser(UserInfo user);

}
