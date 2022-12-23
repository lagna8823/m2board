<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspRemoveBoard.jsp</title>
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
		<form action="<%=request.getContextPath()%>/jsp/jspModifyBoardAction.jsp" method="post">
		<input type="hidden" name="no" value="<%=rs.getInt("no")%>">
		<table border="1">
			<tr>
				<td>title</td>
				<td><input type="text" name="title" value="<%=rs.getString("title")%>"></td>
			</tr>
			<tr>
				<td>content</td>
				<td><textarea rows="4" cols="60" name="content"><%=rs.getString("content")%></textarea></td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
		</form>
<%
	}
%>
</body>
</html>
