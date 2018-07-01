package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao是数据访问层.
public class ProductDao extends BaseDao1 {
	
	//编写一个根据id查询对象的方法
	public Product getById(Integer id) {
		Product product=new Product();
		String sql="select * from product where id = ?";
		//1:连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();
		//2:编译和执行SQL语句
		
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
		
		
		//3:返回查询的结果集
		return product;
		//4:释放资源
		
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
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("华为新款手机");
//		dao.save(p);
//		dao.update(p);
		dao.delete(2);
	}
	
	public void delete(Integer id) {
		// ?称为占位符
		String sql="delete from product where id = ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}

	
	// 编写一个方法,完成数据的插入操作
	public void update(Product product) {
		// ?称为占位符
		String sql="update product set name=?,price=?,remark=? where id = ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: 对占位符进行赋值操作
			pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.setInt(4, product.getId());
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}

	// 编写一个方法,完成数据的插入操作
	public void save(Product product) {
		// ?称为占位符
		String sql="insert into product (name,price,remark) values (?,?,?)";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: 对占位符进行赋值操作
			pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}*/
}
