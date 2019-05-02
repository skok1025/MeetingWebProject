package com.meeting.love;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 러브테스트 메인 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/love/lovetestmain.do")
public class LoveTestMain extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/love/lovetestmain.jsp");
		dispatcher.forward(req, resp);
	}
}