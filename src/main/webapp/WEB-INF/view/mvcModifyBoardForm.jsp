<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "model1.vo.*" %>
<%@ page import = "model1.service.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
	// 컨트롤러에서 공유한 모델데이터 셋팅
	ArrayList<Board> list = (ArrayList<Board>)(request.getAttribute("list"));
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>ModifyBoard</title>
	</head>
	<body>
	      <form action="<%=request.getContextPath()%>/mvc/ModifyBoardActionController" method="post">
	     
	      <table border="1">
	      	 <%
	            for(Board b : list) {
	         %>  
	          <input type="hidden" name="no" value="<%=b.getNo()%>">
	         <tr>
	            <td>title</td>
	            <td><input type="text" name="title" value="<%=b.getTitle()%>"></td>
	         </tr>
	         <tr>
	            <td>content</td>
	            <td><textarea rows="4" cols="60" name="content"><%=b.getContent()%></textarea></td>
	         </tr>
	      </table>
	       <%
		   		}
			%>
	      <button type="submit">수정하기</button>
	      </form>
	</body>
</html>