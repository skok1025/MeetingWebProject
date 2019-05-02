package com.meeting.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.CommunityDTO;

/**
 * 글 수정 작업 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communityedit.do")
public class CommunityEdit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		System.out.println(seq);
		CommunityDAO dao = new CommunityDAO();

		CommunityDTO dto = dao.communityGet(seq);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/communityedit.jsp");
		dispatcher.forward(req, resp);
	}
}
