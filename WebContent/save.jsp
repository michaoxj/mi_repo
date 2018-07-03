<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!--在java代码声明,在Jsp有3大内置对象用来存储数据: request session application  
		1:存储在application对象中的数据与项目的声明周期相同,如果项目重启则app数据将会消失;
			application可以存储系统公共的数据(类似内存的一个缓存区域)
		2:session(会话,主要是每个用户都有独立的区域,但是只要会话结束则session消失)
			会话结束两种情况:1,默认情况下30分钟没有与服务器交互;2,浏览器关闭.
		3:request: 代表的是用户与服务器端的一次请求.每次请求都会产生一个request对象.
			如果当前对象产生了一个新的request对象,则原来的request将会自动销毁;
	
	-->
	
	
	<!--前端页面使用"<% %>"则是使用java代码,此段代码是有tomcat解析;  -->
	<%
		request.setAttribute("req", "request");
		session.setAttribute("res", "session");
		application.setAttribute("app","application");
	%>
	<a href="query.jsp">query.jsp</a>

   <!-- 发送的是http请求,ProductService是不能够识别,需要一个中介Servlet -->
   <!-- 在项目中所有的请求都要从工程名开始,请修改成自己工程名 -->
   <form action="/demo_test/ProductServlet" method="post">
      <!--  ctrl + atl + 下方向键 -->
           商品名:<input type="text" name="name" /><br/>
            价格:<input type="text" name="price" /><br/>
            备注:<input type="text" name="remark" /><br/>
       <input type="submit" value="提交" />
   </form>
</body>
</html>