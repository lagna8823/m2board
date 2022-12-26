package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.service.BoardService;
import model1.vo.Board;

@WebServlet("/mvc/ModifyBoardFormController")
public class ModifyBoardFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		//BoardDao boardDao = new BoardDao();
		BoardService boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoard(no);
		
		//세션에 list 저장.
		request.setAttribute("list", list); 
		
		// view연결(forward 사용)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mvcModifyBoardForm.jsp");
		rd.forward(request, response);
	}
}
