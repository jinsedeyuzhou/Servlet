package com.ebrightmoon.pool;

import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection  extends ConnectionWrapper {
	
	private Connection conn;
	private MyDataSource dataSource;
	public MyConnection(MyDataSource dataSource, Connection conn) {
		this.dataSource = dataSource;
		this.conn = conn;
	}
	@Override
	public void close() throws SQLException {
		System.out.println("已成功将使用完的连接对象放回连接池中.");
		this.dataSource.add(this.conn);
	}

}
