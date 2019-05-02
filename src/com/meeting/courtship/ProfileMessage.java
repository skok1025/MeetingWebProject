package com.meeting.courtship;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/courtship/profilemessage.do")
public class ProfileMessage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pseq = req.getParameter("pseq");
		String cseq = req.getParameter("seq");
		
		req.setAttribute("pseq", pseq);
		req.setAttribute("cseq", cseq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/courtship/profilemessage.jsp");
		dispatcher.forward(req, resp);
	}

}
