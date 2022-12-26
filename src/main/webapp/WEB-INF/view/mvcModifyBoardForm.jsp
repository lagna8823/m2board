<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>ModifyBoard</title>
	</head>
	<body>
	      <form action="${pageContext.request.contextPath}/mvc/ModifyBoardActionController" method="post">
	     
	      <table border="1">
	      	<c:forEach var="b" items="${list}">
	      		<input type="hidden" name="no" value="${b.no}">
	      		<tr>
	      			<td>title</td>
	           		<td><input type="text" name="title" value="${b.title}"></td>
	      		</tr>
	      		<tr>
		            <td>content</td>
		            <td><textarea rows="4" cols="60" name="content">${b.content}</textarea></td>
	         </tr>
	      	</c:forEach>
	      </table>
	      <button type="submit">수정하기</button>
	      </form>
	</body>
</html>