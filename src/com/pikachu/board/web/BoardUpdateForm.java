package com.pikachu.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pikachu.board.common.Command;
import com.pikachu.board.dao.BoardDAO;
import com.pikachu.board.vo.BoardVO;

public class BoardUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정 페이지 전달
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo = dao.editSelect(vo);
		request.setAttribute("vo", vo);
		return "board/boardUpdateForm";
	}

}
