<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	               <td>${board.title}</td>
	            </tr>
	            <tr>
	               <td>content</td>
	               <td>${board.content}</td>
	            </tr>
	         
	      </table>
	      <div>
	         <a href="${pageContext.request.contextPath}/mvc/ModifyBoardFormController?no=${board.no}">수정</a>
	         <a href="${pageContext.request.contextPath}/mvc/RemoveBoardActionController?no=${board.no}">삭제</a>
	         <a href="${pageContext.request.contextPath}/mvc/BoardListController">뒤로가기</a>
	      </div>
	</body>
</html>