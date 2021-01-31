package com.pikachu.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pikachu.board.web.BoardForm;
import com.pikachu.board.web.BoardUpdateComplete;
import com.pikachu.board.web.BoardUpdateForm;
import com.pikachu.board.web.BoardView;
import com.pikachu.board.web.LoginForm;
import com.pikachu.board.web.Main;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		map.put("/main.do", new Main()); // 메인 페이지 호출
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		// map.put("/loginSuccess.do", new LoginSuccess()); // 로그인 성공
		// map.put("/loginFail.do", new LoginFail()); // 로그인 실패
		map.put("/boardForm.do", new BoardForm()); // 게시판 호출
		map.put("/boardView.do", new BoardView()); // 글 상세 페이지 호출
		map.put("/boardUpdateForm.do", new BoardUpdateForm()); // 글 수정 페이지 호출
		map.put("/boardUpdateComplete.do", new BoardUpdateComplete());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
