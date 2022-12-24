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

@WebServlet("/mvc/BoardOneController")
public class BoardOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardService boardService = new BoardService();
		Board board = boardService.getBoardOne(no);
		
		// view와 공유할 모델데이터 설정( BoardOne에서 뷰로 보여줄 board를 "board"로 저장한다.)
		//  세션은 저장한 정보가 남아있어 setAttribute를 사용.
		request.setAttribute("board", board); 
		
		// view연결  둘다 view가 있을시 include, 하나만 view 있기에 대부분 forward를 사용
		RequestDispatcher rd 
			= request.getRequestDispatcher("/WEB-INF/view/mvcBoardOne.jsp");
		rd.forward(request, response);
	}
}
