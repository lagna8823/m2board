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
// Model(일반클래스) - Controller(Servlet클래스 상속) - View(JSP)
@WebServlet("/mvc/BoardListController")
public class BoardListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardList();
		
		// view와 공유할 모델데이터 설정
		request.setAttribute("list", list); //리스트라는 이름으로 리스트에 저장 같은 request를 mvcBoardList와 공유하고있다. 세션으로 저장할수있지만 세션은 계쏙남고 이거는 한번쓰고 지워짐

		// view 연결 
		// RequestDispatcher 1)inculde 둘다 view가 있을시 사용(합칠때)  2)forward view 하나만일경우
		RequestDispatcher rd 
			= request.getRequestDispatcher("/WEB-INF/view/mvcBoardList.jsp");
		rd.forward(request, response);
	}
}
