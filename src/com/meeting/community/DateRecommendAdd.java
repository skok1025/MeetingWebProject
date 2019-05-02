package com.meeting.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/daterecommendadd.do")
public class DateRecommendAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String mode = req.getParameter("mode");

		
		req.setAttribute("mode", mode);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/daterecommendadd.jsp");
		dispatcher.forward(req, resp);

	}
}
