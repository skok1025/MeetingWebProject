package com.meeting.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.CommunityDTO;

/**
 * 글 신고 dao 작업
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communitywarning.do")
public class CommunityWarning extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		String warning = req.getParameter("warning");
		
		CommunityDAO dao = new CommunityDAO();

		int result = dao.communityWarning(seq, warning);

		dao.close();
		
		if (result == 1) {
			resp.sendRedirect("/Meeting/community/communitymanage.do");
		} else {
			resp.getWriter().print("<script>alert('실패');history.back();</script>");
			resp.getWriter().close();
		}
	}
}