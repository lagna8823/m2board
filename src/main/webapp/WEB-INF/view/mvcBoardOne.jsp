<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "model1.vo.*" %>
<%@ page import = "model1.service.*" %>
<!-- View -->
<%
	// 컨트롤러에서 공유한 모델데이터 셋팅
	Board board = (Board)(request.getAttribute("board"));
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	      <table border="1">
	            <tr>
	               <td>title</td>
	               <td><%=board.getTitle()%></td>
	            </tr>
	            <tr>
	               <td>content</td>
	               <td><%=board.getContent()%></td>
	            </tr>
	         
	      </table>
	      <div>
	         <a href="<%=request.getContextPath()%>/mvc/ModifyBoardFormController?no=<%=board.getNo()%>">수정</a>
	         <a href="<%=request.getContextPath()%>/mvc/RemoveBoardActionController?no=<%=board.getNo()%>">삭제</a>
	      </div>
	</body>
</html>