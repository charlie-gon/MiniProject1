package com.pikachu.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pikachu.board.common.DAO;
import com.pikachu.board.vo.BoardVO;

public class BoardDAO extends DAO {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "SELECT BID, BTITLE, BNAME, BDATE, BHIT FROM BOARD";
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbName(rs.getString("bName"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	public BoardVO select(BoardVO vo) {
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int update(BoardVO vo) {
		int n = 0;
		String sql = "UPDATE BOARD SET BCONTENT = ? WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int insert(BoardVO vo) {
		int n = 0;
		String sql = "INSERT INTO BOARD(BID, BNAME, BTITLE, BCONTENT, BDATE) VALUES(BIDSEQ.NEXTVAL, ?,?,?,?)"; 
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	// 글 수정
public BoardVO editSelect(BoardVO vo) {
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 댓글 가져오는 메소드 아래에 추가하기
	
	public void close() {
		
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void hitCount(int hit) {
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
