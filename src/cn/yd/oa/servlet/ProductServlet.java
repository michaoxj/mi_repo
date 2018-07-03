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

//HttpServlet:可以接收Http请求信息,请求的地址:/ProductServlet
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	private ProductService productService = new ProductService();
	// JSP ---> Servlet ---> Service ---> Dao ---> DB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1:获取前端输入查询的关键字;
		String keyword = request.getParameter("keyword");
		//2:调用业务逻辑
		ArrayList<Product> proList = productService.queryByName(keyword);
		for(Product temp: proList) {
			System.out.println(temp);
		}
		//数据要交给query.jsp页面
		request.setAttribute("proList", proList);
		HttpSession session = request.getSession();
		session.setAttribute("proList", proList);
		//当前页面跳转到query.jsp(此方式称为重定向,会产生新的request对象)
//		response.sendRedirect("/demo_test/query.jsp");
		//如果servlet与jsp存在数据的共享,则建议使用转发(只能访问项目内部的资源,默认添加了工程名)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
		//在转发此请求的时候,会把上一次request response提交
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("request:" + request);
		System.out.println("response:" + response);

		//1.获取前端数据
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		
		//2.调用业务逻辑
		productService.save(product);
		//3.返回结果页面,在java开发中所有的资源访问都要从工程名开始(query.jsp)
		response.sendRedirect("/demo_test/query.jsp");
	}

}
