package com.sym.DAOimpl;

//import com.sym.UserDAO;
//import com.spring.user.model.UserInfo;
import com.sym.DAO.UserDao;
import com.sym.model.Loginf;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UserDAOimpl implements UserDao {
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Loginf logidpwd(String usr,String pwd)
	{
		String sql1="select expire_on from waltairclub";
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Date: " +format);
      
		

		
		String sql = "SELECT * FROM member_login WHERE member_id = ? and password = ? and active = 1";
		Connection conn = null;
		 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, usr);
			ps.setString(2, pwd);
			Loginf lg=null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1));
				lg = new Loginf(rs.getString(1), rs.getString(2));
			}
			rs.close();
			ps.close();
			return lg;
			
			
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
	}

}
}
