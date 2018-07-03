package ProductService;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

public class ProductService {
	
	/* new对象的3个缺点
	 * 1. 不能控制ProductDao数量,在项目中Servlet,Service,Dao都是单例模式.Model必须是多例模式.
	 * 2.不能控制类型,项目编码的目标:高内聚/低耦合
	 * 3.不能控制对象的创建时间
	 */
	
	private ProductDao productDao = new ProductDao();
		
	public void save(Product product) {
		
		productDao.save(product);
		
	}
	
	public ArrayList<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);
		
	}
	
	public void delete(Integer id) {
		productDao.delete(id);
	}
	

}
