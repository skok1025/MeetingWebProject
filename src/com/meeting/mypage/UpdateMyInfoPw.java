package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 나의 정보 수정전 패스워드를 입력하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/updatemyinfopw.do")
public class UpdateMyInfoPw extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/updatemyinfopw.jsp");
		dispatcher.forward(req, resp);

	}

}
