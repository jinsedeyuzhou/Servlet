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
		System.out.println("一次性初始化10个数据库连接对象.");
		for (int i = 0; i < 10; i++) {
			// 获取数据库连接对象.
			 Connection conn = JDBCUtils.getConnection();
			// 将获取的连接对象进行包装.
			MyConnection myConn = new MyConnection(this, conn);
			// 将包装后的连接对象添加到连接池中.
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
		// 将使用的连接对象从连接池中删除,防止同时使用同一个连接对象.
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
