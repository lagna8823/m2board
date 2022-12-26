package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.service.BoardService;
import model1.vo.Board;

@WebServlet("/mvc/ModifyBoardActionController")
public class ModifyBoardActionController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int resultRow = 0;
		
		Board paramBoard = new Board();
		paramBoard.setNo(no);
		paramBoard.setTitle(title);
		paramBoard.setContent(content);
   
		BoardService boardService = new BoardService();
		resultRow = boardService.modifyBoard(paramBoard);
   
		if(resultRow !=0){ 
        // 뷰가 있따!
			response.sendRedirect(request.getContextPath() + "/mvc/BoardOneController?no="+no);
			return;
		}
		response.sendRedirect(request.getContextPath() + "/mvc/ModifyBoardFormController");
	}
}
