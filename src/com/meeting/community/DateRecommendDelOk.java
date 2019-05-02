package com.meeting.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.main.LoginDAO;
import com.meeting.main.LoginDTO;

@WebServlet("/community/daterecommenddelok.do")
public class DateRecommendDelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		String drseq = req.getParameter("drseq");
		
		CommunityDAO dao = new CommunityDAO();
		

		int result = -1;
		
		if(dao.isOwner(seq, session.getAttribute("id").toString())) {
			//댓글먼저 삭제
			result = dao.delRecommendComment(seq);
			result = dao.del(seq);
			
			System.out.println("seq"+seq);
		}else {
			result = 2;
		}
		
		if(result==1) {
			resp.sendRedirect("/Meeting/community/daterecommend.do");
		}else if(result==2) {
			resp.getWriter().print("<script> alert('글쓴 매니저만 삭제 가능합니다'); history.back(); </script>");
			resp.getWriter().close();
		}else {
			resp.getWriter().print("<script> alert('Failed'); history.back(); </script>");
			resp.getWriter().close();
		}


	}
}
