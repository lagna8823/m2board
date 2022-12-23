<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "model1.service.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
   // request
   request.setCharacterEncoding("UTF-8");
   String title = request.getParameter("title");
   String content = request.getParameter("content");
   int resultRow = 0;
   
   BoardService boardService = new BoardService();
   resultRow = boardService.addBoard(title, content);
   
   if(resultRow !=0){ 
         // 뷰가 있따!
         response.sendRedirect(request.getContextPath() + "/model1/m1BoardList.jsp");
         return;
      }
   response.sendRedirect(request.getContextPath() + "/model1/m1AddBoardForm.jsp");
   return;
   
   
   /*
      clinet에게 재요청(redirect)
      server에서 서버자원에게 부탁(forward / include)
   */
%>