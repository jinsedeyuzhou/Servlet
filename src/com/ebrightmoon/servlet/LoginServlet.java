package com.ebrightmoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.ebrightmoon.bean.UserInfo;
import com.ebrightmoon.utils.JDBCHelper;
import com.ebrightmoon.utils.JDBCUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			query();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * 查询数据
	 */
	private void selectData() {
		// 获取C3P0连接池对象.
				// 定义数据库连接对象.
				Connection conn=null;
				// 定义PreparedStatement对象.
				PreparedStatement stmt = null;
				// 定义结果集对象.
				ResultSet rs = null;
				try {
					conn = JDBCHelper.getConnection();
					// 获取数据库连接.
					// 定义SQL语句.
					String sql = "SELECT * FROM userinfo";
					// 利用PreparedStatement对象加载SQL语句.
					stmt = conn.prepareStatement(sql);
					// 将SQL语句发送至数据库.
					rs = stmt.executeQuery();
					// 遍历结果集.
					while (rs.next()) {
						System.out.print(rs.getString("username") + ", ");
						System.out.print(rs.getString("realname") + ", ");
						System.out.println(rs.getString("id") + ", ");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try { if (rs != null) rs.close(); } catch(Exception e) { }
		            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
		            try { if (conn != null) conn.close(); } catch(Exception e) { }
				}
		
	}
	
	/**
	 * 更新数据
	 */
	private void updateData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE userinfo SET username=?  WHERE id=?";
		try {
			conn = JDBCHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "李艾可");
			stmt.setInt(2, 5);
		
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		
	}

	/**
	 * DBUtils 请求操作数据
	 */
	private void query() throws Exception{
		QueryRunner queryRunner = new QueryRunner(JDBCHelper.getDataSource());
		List<UserInfo> accounts = queryRunner.query("SELECT * FROM account", new ResultSetHandler<List<UserInfo>>() {

			@Override
			public List<UserInfo> handle(ResultSet rs) throws SQLException {
				List<UserInfo> accounts = new ArrayList<UserInfo>();
				while (rs.next()) {
					UserInfo userInfo = new UserInfo();
					userInfo.setId(rs.getInt("id"));
					userInfo.setUserName(rs.getString("username"));
					userInfo.setRealName(rs.getString("realname"));
					accounts.add(userInfo);
				}
				return accounts;
			}
			
		});
		
		for (UserInfo userInfo : accounts) {
			System.out.println(userInfo.toString());
		}
		
		
		
	}

}
