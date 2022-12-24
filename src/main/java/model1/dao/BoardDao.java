package model1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model1.vo.Board;

public class BoardDao {
   // public ResultSet selectBoardList() throws Exception {
   // ResultSet 반환타입으로 별로 -> 평범한 타입 -> List
   public ArrayList<Board> selectBoardList(Connection conn) throws Exception {
      // 다른 메서드에서도 동일한 매개값을 사용하는 코드 중복 
      // -> 매개값(ex:db비밀번호)이 변경되면 중복된 코드 모두 이 매개값을 같은 값으로 변경해야 된다.
      // Class.forName("org.mariadb.jdbc.Driver");
      // Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc","root","java1234");
      
      String sql = "SELECT no, title FROM board";
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      // ResultSet -> List 가공작업
      ArrayList<Board> list = new ArrayList<Board>();
      while(rs.next()) {
         Board b = new Board();
         b.setNo(rs.getInt("no"));
         b.setTitle(rs.getString("title"));
         list.add(b);
      }
      return list;
   }
   
   
   
   // m1 ADD 추가
   public int insertBoard(Connection conn, String title, String content) throws Exception{
      int resultRow=0;
      String sql = "INSERT INTO board(title, content) VALUE(?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, title);
          stmt.setString(2, content);
          resultRow = stmt.executeUpdate();
          return resultRow;
   }
   
   // m1 BoardOne 상세보기 select
   public Board selectOne(Connection conn, int no) throws Exception {
	   Board board = new Board();
	   String sql = "SELECT no, title, content FROM board WHERE no=?";
	   PreparedStatement stmt = conn.prepareStatement(sql);
	   stmt.setInt(1, board.getNo());
	   ResultSet rs = stmt.executeQuery();
	   while(rs.next()) {
		   board.setNo(rs.getInt("no"));
		   board.setTitle(rs.getString("title"));
		   board.setTitle(rs.getString("title"));
	   }
	   return board;
   }
   
   // m1 MODIFY 수정폼 select
   public ArrayList<Board> selectBoard(Connection conn, int no) throws Exception {
      // 다른 메서드에서도 동일한 매개값을 사용하는 코드 중복 
      // -> 매개값(ex:db비밀번호)이 변경되면 중복된 코드 모두 이 매개값을 같은 값으로 변경해야 된다.
      // Class.forName("org.mariadb.jdbc.Driver");
      // Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mvc","root","java1234");
      
      String sql = "SELECT no, title, content FROM board WHERE no = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, no);
      ResultSet rs = stmt.executeQuery();
      ArrayList<Board> list = new ArrayList<Board>();
      while(rs.next()) {
         Board b = new Board();
         b.setNo(rs.getInt("no"));
         b.setTitle(rs.getString("title"));
         b.setContent(rs.getString("content"));
         list.add(b);
      }
      return list;
   }
   
   // m1 MODIFY 수정
      public int modifyBoard(Connection conn, Board paramBoard) throws Exception{
    	 int resultRow = 0;
         String sql = "update board SET title=? , content=? where no=?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, paramBoard.getTitle());
         stmt.setString(2, paramBoard.getContent());
         stmt.setInt(3, paramBoard.getNo());
         resultRow = stmt.executeUpdate(); 
         stmt.close();
         return resultRow;
        
      }
      
   // m1 MODIFY 삭제
      public int removeBoard(Connection conn, int no) throws Exception{
    	 int resultRow = 0;
    	 String sql = "DELETE FROM board where no=?";
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, no);
         resultRow = stmt.executeUpdate(); 
         stmt.close();
         return resultRow;
        
      }
}