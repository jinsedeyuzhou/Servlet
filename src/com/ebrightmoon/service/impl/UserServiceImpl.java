package com.ebrightmoon.service.impl;

import com.ebrightmoon.bean.UserInfo;
import com.ebrightmoon.dao.UserDao;
import com.ebrightmoon.dao.impl.UserDaoImpl;
import com.ebrightmoon.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public UserInfo login(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		UserInfo selectUser = userDao.selectUser(user);
		if (selectUser!=null) {
			return selectUser;
		}
		
		return null;
	}

	@Override
	public boolean modifyUser(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		Integer updateUser = userDao.updateUser(user);
		if (updateUser > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findUser(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		UserInfo selectUser = userDao.selectUser(user);
		if (selectUser != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ebrightmoon.service.UserService#regist(com.ebrightmoon.bean.UserInfo)
	 */
	@Override
	public boolean regist(UserInfo user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		Integer integer = userDao.insertUser(user);
		if (integer > 0) {
			return true;
		}
		return false;

	}

}
