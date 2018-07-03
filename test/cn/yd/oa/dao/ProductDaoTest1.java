package cn.yd.oa.dao;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yd.oa.model.Product;

public class ProductDaoTest1 {
	private static ProductDao productDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前执行");
		productDao = new ProductDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testqueryByName() {
		ArrayList<Product> proList = productDao.queryByName("%%");
		for(Product temp:proList) {
			System.out.println(temp.toString());
		}
	}
	
	@Test
	public void testgetById() {
		Product product = productDao.getById(2);
		System.out.println(product);
	}
	
	
	@Test
	public void testDelete() {
		productDao.delete(4);
	}

	@Test
	public void testUpdate() {
		Product p=new Product();
		p.setName("苹果手机");
		p.setPrice(5600.00);
		p.setId(2);
		p.setRemark("华为新款手机");
		productDao.update(p);
	}

	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("摩托罗拉手机");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("摩托罗拉手机");
		productDao.save(p);
	}

}
