<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "model1.vo.*" %>
<%@ page import = "model1.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%   
   request.setCharacterEncoding("utf-8");
   int no = Integer.parseInt(request.getParameter("no"));
//   BoardDao boardDao = new BoardDao();
   BoardService boardService = new BoardService();
   ArrayList<Board> list = boardService.getBoard(no);
%>
      <table border="1">
         <%
            for(Board b : list) {
         %>   
         
            <tr>
               <td>title</td>
               <td><%=b.getTitle()%></td>
            </tr>
            <tr>
               <td>content</td>
               <td><%=b.getContent()%></td>
            </tr>
         
      </table>
      <div>
         <a href="<%=request.getContextPath()%>/model1/m1ModifyBoardForm.jsp?no=<%=b.getNo()%>">수정</a>
         <a href="<%=request.getContextPath()%>/model1/m1RemoveBoardAction.jsp?no=<%=b.getNo()%>">삭제</a>
      </div>
      	<%
            }
         %>

</body>
</html>