package com.meeting.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 글쓰기 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communityadd.do")
public class CommunityAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String kind = req.getParameter("kind");
		String id = session.getAttribute("id").toString();
		
		req.setAttribute("id", id);
		req.setAttribute("kind", kind);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/communityadd.jsp");
		dispatcher.forward(req, resp);
	}
}