<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "model1.vo.*" %>
<%@ page import = "model1.service.*" %>


<%
	// request
	int no = Integer.parseInt(request.getParameter("no"));
	int resultRow =0;
	
	BoardService boardService = new BoardService();
    resultRow = boardService.romoveBoard(no);
    if(resultRow !=0){
   		// 뷰가 있따!
   		response.sendRedirect(request.getContextPath() + "/model1/m1BoardList.jsp");
   		return;
   	}
	response.sendRedirect(request.getContextPath() + "/model1/m1BoardOne.jsp?no="+no);
	
%>