package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao�����ݷ��ʲ�.
public class ProductDao extends BaseDao1 {
	
	//��дһ������id��ѯ����ķ���
	public Product getById(Integer id) {
		Product product=new Product();
		String sql="select * from product where id = ?";
		//1:�������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();
		//2:�����ִ��SQL���
		
		PreparedStatement pre;
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		//3:���ز�ѯ�Ľ����
		return product;
		//4:�ͷ���Դ
		
//		return null;
		
	}
	
	
	
	public void delete(Integer id) {
		String sql = "delete from product where id = ?";
		super.executeUpdate(sql, new Object[] {id});
	}
	
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
	}
	
	public void save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark()});
		
	}

	
	
	
	
	
	
	
	
/*
 * // alt+/
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
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
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
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
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
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
			throw new RuntimeException(e);
		}
		// 5: �ر�Connection�ͷ���Դ
	}*/
}
