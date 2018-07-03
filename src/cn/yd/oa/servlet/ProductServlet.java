package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProductService.ProductService;	
import cn.yd.oa.model.Product;

//HttpServlet:���Խ���Http������Ϣ,����ĵ�ַ:/ProductServlet
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	private ProductService productService = new ProductService();
	// JSP ---> Servlet ---> Service ---> Dao ---> DB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1:��ȡǰ�������ѯ�Ĺؼ���;
		String keyword = request.getParameter("keyword");
		//2:����ҵ���߼�
		ArrayList<Product> proList = productService.queryByName(keyword);
		for(Product temp: proList) {
			System.out.println(temp);
		}
		//����Ҫ����query.jspҳ��
		request.setAttribute("proList", proList);
		HttpSession session = request.getSession();
		session.setAttribute("proList", proList);
		//��ǰҳ����ת��query.jsp(�˷�ʽ��Ϊ�ض���,������µ�request����)
//		response.sendRedirect("/demo_test/query.jsp");
		//���servlet��jsp�������ݵĹ���,����ʹ��ת��(ֻ�ܷ�����Ŀ�ڲ�����Դ,Ĭ������˹�����)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
		//��ת���������ʱ��,�����һ��request response�ύ
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("request:" + request);
		System.out.println("response:" + response);

		//1.��ȡǰ������
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		
		//2.����ҵ���߼�
		productService.save(product);
		//3.���ؽ��ҳ��,��java���������е���Դ���ʶ�Ҫ�ӹ�������ʼ(query.jsp)
		response.sendRedirect("/demo_test/query.jsp");
	}

}
