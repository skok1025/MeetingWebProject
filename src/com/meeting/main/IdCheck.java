package com.meeting.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입 시 아이디 중복검사의 결과를 반환하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/idcheck.do")
public class IdCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		
		LoginDAO dao = new LoginDAO();
		int result = dao.idcheck(id);
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/idcheck.jsp");
		dispatcher.forward(req, resp);

	}

}