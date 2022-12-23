package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.service.BoardService;

@WebServlet("/mvc/RemoveBoardActionController")
public class RemoveBoardActionController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int resultRow =0;
		
		BoardService boardService = new BoardService();
	    resultRow = boardService.romoveBoard(no);
	    if(resultRow !=0){
	   		// 뷰가 있따!
	   		response.sendRedirect(request.getContextPath() + "/WEB-INF/view/mvcBoardList.jsp");
	   		return;
	   	}
		response.sendRedirect(request.getContextPath() + "/WEB-INF/view/mvcBoardOne.jsp?no="+no);
	}
}
