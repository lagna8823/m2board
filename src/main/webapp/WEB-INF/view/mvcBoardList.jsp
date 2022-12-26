<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>jspBoardList.jsp</title>
	</head>
	<body>
		<h1>MODEL1 BOARD LIST</h1>
		<div>
			<a href="${pageContext.request.contextPath}/mvc/AddBoardFormController">글입력</a>
		</div>
		<table border="1">
			<thead>
				<tr>
					<th>no</th>
					<th>title</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach var="b" items="${list}">
					<tr>
						<td>${b.no}</td>
						<td>
							<a href="${pageContext.request.contextPath}/mvc/BoardOneController?no=${b.no}">
								${b.title} 
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
