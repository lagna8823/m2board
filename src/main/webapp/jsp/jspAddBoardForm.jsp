<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>jspBoardList.jsp</title>
	</head>
	<body>
	   <h1>게시글 입력</h1>
	   <form action="<%=request.getContextPath()%>/jsp/jspAddBoardAction.jsp" method="post">
			<table border="1">
				<tr>
					<th>title</th>
					<td><input type="text" name="title" value=""></td>
				</tr>   
				<tr>
					<th>content</th>
					<td><textarea rows="4" cols="60" name="content"></textarea></td>
				</tr>
			 </table>
		   <button type="submit">입력하기</button>
	   </form>
	</body>
</html>

