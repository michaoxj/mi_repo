package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 主要用来完成数据库连接(资源释放)
public class JdbcUtils {
	
	public static void main(String[] args) {
		JdbcUtils utils = new JdbcUtils();
		utils.getConnection();
		
	}
	
	//此方法调用则会返回一个Connection对象
	public Connection getConnection() {
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
		System.out.println(conn);
		return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	};
	
	static {
		//只有静态(static)参数才能被类调用;
		System.out.println("静态块,此类加载到JVM中时会自动执行且执行一次");
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
