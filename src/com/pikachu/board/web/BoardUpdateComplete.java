package com.pikachu.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pikachu.board.common.Command;
import com.pikachu.board.dao.BoardDAO;
import com.pikachu.board.vo.BoardVO;

public class BoardUpdateComplete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정 완료
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = dao.update(vo);
		String viewPage = null;
		
		if(n != 0) {	
			viewPage = "boardForm.do";
		}
		return viewPage;
	}

}
