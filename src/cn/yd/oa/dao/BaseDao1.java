package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.utils.JdbcUtils;

public class BaseDao1  {
	
	public void executeUpdate(String sql,Object[] param) {
		// ?��Ϊռλ��
//		String sql="update product set name=?,price=?,remark=? where id = ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: ��ռλ�����и�ֵ����
//			pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
//			pre.setDouble(2, product.getPrice());
//			pre.setString(3, product.getRemark());
//			pre.setInt(4, product.getId());
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
			for (int i = 0; i < param.length; i++) {
				pre.setObject(i+1, param[i]);
			}
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
			throw new RuntimeException(e);
		}
		// 5: �ر�Connection�ͷ���Դ
	}


}
