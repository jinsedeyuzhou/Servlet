package com.ebrightmoon.service;

import com.ebrightmoon.bean.UserInfo;

public interface UserService {

	public boolean findUser(UserInfo user);

	public boolean register(UserInfo user);

	public UserInfo login(UserInfo user);

	public boolean modifyUser(UserInfo user);

}
