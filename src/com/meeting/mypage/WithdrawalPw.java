package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원 탈퇴시 비밀번호 입력 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/withdrawalpw.do")
public class WithdrawalPw extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/withdrawalpw.jsp");
		dispatcher.forward(req, resp);

	}

}