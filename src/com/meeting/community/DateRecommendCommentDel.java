package com.meeting.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;

@WebServlet("/community/daterecommendcommentdel.do")
public class DateRecommendCommentDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		
		CommunityDAO dao = new CommunityDAO();
		
		int result = -1;
		
		if(dao.isOwner(seq, session.getAttribute("id").toString())) {
			result = dao.delComment(seq);
		}else {
			result = 2;
		}
		
		
		//3.
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");

		String txt = "";

		txt += "{";
		txt += String.format("\"state\":\"%s\"", result);
		txt += "}";

		resp.getWriter().println(txt);
		resp.getWriter().close();

	}
}
