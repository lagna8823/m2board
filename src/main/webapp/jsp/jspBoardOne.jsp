<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc","root","java1234");
	String sql = "SELECT no, title, content FROM board WHERE no = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, no);
	ResultSet rs = stmt.executeQuery();
	if(rs.next()) {
%>
		<table border="1">
			<tr>
				<td>title</td>
				<td><%=rs.getString("title")%></td>
			</tr>
			<tr>
				<td>content</td>
				<td><%=rs.getString("content")%></td>
			</tr>
		</table>
		<div>
			<a href="<%=request.getContextPath()%>/jsp/jspModifyBoardForm.jsp?no=<%=rs.getInt("no")%>">수정</a>
			<a href="<%=request.getContextPath()%>/jsp/jspRemoveBoard.jsp?no=<%=rs.getInt("no")%>">삭제</a>
		</div>
<%
	}
%>
</body>
</html>
