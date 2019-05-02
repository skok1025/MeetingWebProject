package com.meeting.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.CommunityDTO;

/**
 * 글관리 작업 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communitymanage.do")
public class CommunityManage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = session.getAttribute("cseq").toString();
		
		CommunityDAO dao = new CommunityDAO();
		
		ArrayList<CommunityDTO> list = new ArrayList<>(); 
		
		if(session.getAttribute("id").toString().equals("admin1")) {
			list = dao.getMyList();
		} else {
			list = dao.getMyList(seq);
		}
		
		req.setAttribute("list", list);
		req.setAttribute("seq", seq);
		req.setAttribute("id", session.getAttribute("id"));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/communitymanage.jsp");
		dispatcher.forward(req, resp);
	}
}
