package com.meeting.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.community.model.CommunityDAO;

/**
 * 글삭제 dao 작업
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communitydel.do")
public class CommunityDel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		CommunityDAO dao = new CommunityDAO();
		
		System.out.println("seq" + seq);
		
		int ccresult = dao.communitCommentDel(seq);
		int cresult = dao.communityDel(seq);
		
		System.out.println("ccresult" + ccresult);
		System.out.println("cresult" + cresult);
		
		if (cresult == 1) {
			resp.sendRedirect("/Meeting/community/communitymanage.do");
		} else {
			resp.getWriter().print("<script>alert('실패');history.back();</script>");
			resp.getWriter().close();
		}
	}
}