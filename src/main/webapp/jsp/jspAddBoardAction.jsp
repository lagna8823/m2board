<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
	// request
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int resultRow = 0;
	
	// DB연결
	Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc","root","java1234");
    
    String sql = "INSERT INTO board(title, content) VALUE(?,?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, title);
    stmt.setString(2, content);
    resultRow = stmt.executeUpdate();
   	if(resultRow !=0){ 
   		// 뷰가 있따!
   		response.sendRedirect(request.getContextPath() + "/jsp/jspBoardList.jsp");
		stmt.close();
		conn.close();
   		return;
   	}
	response.sendRedirect(request.getContextPath() + "/jsp/jspAddBoardForm.jsp");
	return;
	
	/*
		clinet에게 재요청(redirect)
		server에서 서버자원에게 부탁(forward / include)
	*/
%>