package ProductService;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

public class ProductService {
	
	/* new�����3��ȱ��
	 * 1. ���ܿ���ProductDao����,����Ŀ��Servlet,Service,Dao���ǵ���ģʽ.Model�����Ƕ���ģʽ.
	 * 2.���ܿ�������,��Ŀ�����Ŀ��:���ھ�/�����
	 * 3.���ܿ��ƶ���Ĵ���ʱ��
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
