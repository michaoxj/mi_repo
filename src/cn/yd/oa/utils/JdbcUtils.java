package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ��Ҫ����������ݿ�����(��Դ�ͷ�)
public class JdbcUtils {
	
	public static void main(String[] args) {
		JdbcUtils utils = new JdbcUtils();
		utils.getConnection();
		
	}
	
	//�˷���������᷵��һ��Connection����
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
		//ֻ�о�̬(static)�������ܱ������;
		System.out.println("��̬��,������ص�JVM��ʱ���Զ�ִ����ִ��һ��");
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
