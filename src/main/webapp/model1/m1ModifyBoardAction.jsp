<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "model1.vo.*" %>
<%@ page import = "model1.service.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
   // request
   request.setCharacterEncoding("utf-8");
   int no = Integer.parseInt(request.getParameter("no"));
   String title = request.getParameter("title");
   String content = request.getParameter("content");
   int resultRow =0;
   
   Board paramBoard = new Board();
   paramBoard.setNo(no); 
   paramBoard.setTitle(title);
   paramBoard.setContent(content);
   
   BoardService boardService = new BoardService();
   resultRow = boardService.modifyBoard(paramBoard);
   
   if(resultRow !=0){ 
         // 뷰가 있따!
         response.sendRedirect(request.getContextPath() + "/model1/m1BoardOne.jsp?no="+no);
         return;
      }
   response.sendRedirect(request.getContextPath() + "/model1/m1ModifyBoardForm.jsp?no="+no);
   return;
   
%>