<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
	// request
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	System.out.println(no+title+content);
	int resultRow =0;

	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc","root","java1234");
	String sql = "update board SET title=? , content=? where no=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1, title);
	stmt.setString(2, content);
	stmt.setInt(3, no);
	resultRow = stmt.executeUpdate();
	if(resultRow !=0){ 
   		// 뷰가 있따!
   		response.sendRedirect(request.getContextPath() + "/jsp/jspBoardOne.jsp?no="+no);
		stmt.close();
		conn.close();
   		return;
   	}
	response.sendRedirect(request.getContextPath() + "/jsp/jspModifyBoardForm.jsp?no="+no);
	return;
	
%>