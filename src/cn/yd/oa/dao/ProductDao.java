package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao�����ݷ��ʲ�.
public class ProductDao {
	
	// alt+/
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product p=new Product();
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("��Ϊ�¿��ֻ�");
//		dao.save(p);
//		dao.update(p);
		dao.delete(2);
	}
	
	public void delete(Integer id) {
		// ?��Ϊռλ��
		String sql="delete from product where id = ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			// 4: ִ��SQL���,����int�������Ϊ1���������1������
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
			throw new RuntimeException(e);
		}
		// 5: �ر�Connection�ͷ���Դ
	}

	
	// ��дһ������,������ݵĲ������
	public void update(Product product) {
		// ?��Ϊռλ��
		String sql="update product set name=?,price=?,remark=? where id = ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: ��ռλ�����и�ֵ����
			pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.setInt(4, product.getId());
			// 4: ִ��SQL���,����int�������Ϊ1���������1������
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
			throw new RuntimeException(e);
		}
		// 5: �ر�Connection�ͷ���Դ
	}

	// ��дһ������,������ݵĲ������
	public void save(Product product) {
		// ?��Ϊռλ��
		String sql="insert into product (name,price,remark) values (?,?,?)";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: ��ռλ�����и�ֵ����
			pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			// 4: ִ��SQL���,����int�������Ϊ1���������1������
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