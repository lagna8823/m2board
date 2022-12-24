package model1.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model1.dao.BoardDao;
import model1.util.DBUtil;
import model1.vo.Board;

// 서비스
// 1) 예외처리 -> db자원반납, 트랜잭션 처리
// 2) Connection객체를 dao에 넘겨주는 역활
// 3) 기타 dao안에 있어서는 안되는 비지니스로직(코드)
public class BoardService {
   private BoardDao boardDao;
   public ArrayList<Board> getBoardList()  {
      boardDao = new BoardDao();
      Connection conn = null;
      ArrayList<Board> list = null;
      try {
         conn = DBUtil.getConnection();
         conn.setAutoCommit(false);
         list = boardDao.selectBoardList(conn);
         conn.commit();
      } catch (Exception e) {
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return list;
   }
   
   // boardOne 
   public Board getBoardOne(int no)  {
	      boardDao = new BoardDao();
	      Connection conn = null;
	      Board board = null;
	      try {
	         conn = DBUtil.getConnection();
	         conn.setAutoCommit(false);
	         board = boardDao.selectOne(conn, no);
	         conn.commit();
	      } catch (Exception e) {
	         try {
	            conn.rollback();
	         } catch (SQLException e1) {
	            e1.printStackTrace();
	         }
	         e.printStackTrace();
	      } finally {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return board;
	   }
   
   // insert
   public int addBoard(String title, String content)  {
      boardDao = new BoardDao();
      Connection conn = null;
      int resutlRow = 0;
      try {
         conn = DBUtil.getConnection();
         conn.setAutoCommit(false);
         resutlRow = boardDao.insertBoard(conn, title, content);
         conn.commit();
      } catch (Exception e) {
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return resutlRow;
   }
   
   //modify 폼
   public ArrayList<Board> getBoard(int no)  {
      boardDao = new BoardDao();
      Connection conn = null;
      ArrayList<Board> list = null;
      try {
         conn = DBUtil.getConnection();
         conn.setAutoCommit(false);
         list = boardDao.selectBoard(conn, no);
         conn.commit();
      } catch (Exception e) {
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return list;
   }

   // modify 수정
   public int modifyBoard(Board paramBoard)  {
      boardDao = new BoardDao();
      Connection conn = null;
      int resultRow = 0;
      try {
         conn = DBUtil.getConnection();
         conn.setAutoCommit(false);
         resultRow = boardDao.modifyBoard(conn, paramBoard);
         conn.commit();
      } catch (Exception e) {
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return resultRow;
   }    
   
   // romove 삭제
      public int romoveBoard(int no)  {
         boardDao = new BoardDao();
         Connection conn = null;
         int resultRow = 0;
         try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            resultRow = boardDao.removeBoard(conn, no);
            conn.commit();
         } catch (Exception e) {
            try {
               conn.rollback();
            } catch (SQLException e1) {
               e1.printStackTrace();
            }
            e.printStackTrace();
         } finally {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         return resultRow;
   }
}