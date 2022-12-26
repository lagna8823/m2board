package controller;

import java.io.IOException;

// C -> M ===> 클리언트 다른 컨트롤러를 요청하도록 리다이렉트 
// view(jsp)파일들을 WEB-INF보안폴더안으로 이동해서 클라이언트가 View를 직접 호출 못하도록...
// list select 					: C->  M -> V
// form 페이지 호출    				: C->  V
// action insert/update/delete  : C -> M  response.sendRedirect()
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import model1.service.BoardService;
@WebServlet("/mvc/AddBoardActionController")
public class AddBoardActionController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   int resultRow = 0;
	   System.out.println(title+"<-- AddBoardActionController.doPost.title");
	   
	   // 모델 호출
	   BoardService boardService = new BoardService();
	   resultRow = boardService.addBoard(title, content);
	   
	   if(resultRow !=0){ 
	         // 뷰가 있따!
	         response.sendRedirect(request.getContextPath() + "/mvc/BoardListController");
	         return;
	      }
	   response.sendRedirect(request.getContextPath() + "/mvc/BoardListController");
       return;
	}
}
