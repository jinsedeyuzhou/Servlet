package com.ebrightmoon.dao;

import com.ebrightmoon.bean.UserInfo;

public interface UserDao {

	/**
	 * �����ֻ��Ų�ѯ
	 * @param name
	 * @return
	 */
	public UserInfo selectUserByName(String mobile);

	/**
	 * �����ֻ��ź������ѯ�û�
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo selectUserByName(String mobile, String pwd);
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public UserInfo selectUser(UserInfo user);

	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public Integer insertUser(UserInfo user);

	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateUser(UserInfo user);
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public Integer deleteUser(UserInfo user);

}
