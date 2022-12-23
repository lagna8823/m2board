package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.service.BoardService;

@WebServlet("/mvc/ModifyBoardActionController")
public class ModifyBoardActionController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		   String title = request.getParameter("title");
		   String content = request.getParameter("content");
		   int resultRow = 0;
		   
		   BoardService boardService = new BoardService();
		   resultRow = boardService.addBoard(title, content);
		   
		   if(resultRow !=0){ 
		         // 뷰가 있따!
			   response.sendRedirect(request.getContextPath() + "/WEB-INF/view/mvcBoardOne.jsp");
		         return;
		      }
		   response.sendRedirect(request.getContextPath() + "/WEB-INF/view/mvcModifyBoardForm.jsp");
	       return;
	}
}
