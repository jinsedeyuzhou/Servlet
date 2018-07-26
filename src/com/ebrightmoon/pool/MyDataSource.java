package com.ebrightmoon.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.ebrightmoon.utils.JDBCUtils;

public class MyDataSource implements DataSource {
	private LinkedList<Connection> connections = new LinkedList<Connection>();

	public MyDataSource() throws Exception {
		System.out.println("һ���Գ�ʼ��10�����ݿ����Ӷ���.");
		for (int i = 0; i < 10; i++) {
			// ��ȡ���ݿ����Ӷ���.
			 Connection conn = JDBCUtils.getConnection();
			// ����ȡ�����Ӷ�����а�װ.
			MyConnection myConn = new MyConnection(this, conn);
			// ����װ������Ӷ�����ӵ����ӳ���.
			connections.add(conn);
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = connections.getFirst();
		// ��ʹ�õ����Ӷ�������ӳ���ɾ��,��ֹͬʱʹ��ͬһ�����Ӷ���.
		connections.removeFirst();
		return conn;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Connection conn) {
		connections.add(conn);
	}

}
