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
		System.out.println("�˷����ڲ��Է���֮ǰִ��");
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
		p.setName("ƻ���ֻ�");
		p.setPrice(5600.00);
		p.setId(2);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.update(p);
	}

	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("Ħ�������ֻ�");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("Ħ�������ֻ�");
		productDao.save(p);
	}

}
