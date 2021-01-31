package com.pikachu.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pikachu.board.common.Command;
import com.pikachu.board.dao.BoardDAO;
import com.pikachu.board.vo.BoardVO;

public class BoardView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세보기
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "board/boardView";
	}

}
