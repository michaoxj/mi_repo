<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <!-- 发送的是http请求,ProductService是不能够识别,需要一个中介Servlet -->
   <%=request.getAttribute("req") %><br />
	<%=session.getAttribute("sess") %><br />
	<%=application.getAttribute("app") %><br />
	
   <!-- 在项目中所有的请求都要从工程名开始,请修改成自己工程名 -->
   工程名:<%=request.getContextPath() %>
   <form action="/demo_test/ProductServlet" method="get">
      <!--  ctrl + atl + 下方向键 -->

            关键字:<input type="text" name="keyword" /><br/>
       <input type="submit" value="搜索" />
   </form>
   
   req: <%=request.getAttribute("proList") %><br />
   res: <%=session.getAttribute("proList") %><br />
   <table border="1" width="500px">
   		<tr>
   			<th>编号</th>
   			<th>名称</th>
   			<th>价格</th>
   			<th>备注</th>
   			<th>日期</th>
   			<!--所有的a标签都是get请求  -->
   			<th>更新|删除</th>
   		</tr>
   		
   		<c:forEach items="${requestScope.proList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.remark}</td>
				<td>${product.date}</td>
			</tr>
		</c:forEach>
   		
   </table>
   
   
</body>
</html>