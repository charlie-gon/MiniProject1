package com.pikachu.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pikachu.board.common.Command;
import com.pikachu.board.dao.BoardDAO;
import com.pikachu.board.vo.BoardVO;

public class BoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시판 호출
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		return "board/boardForm";
	}

}
