package com.meeting.courtship;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.courtship.model.CourtshipDAO;
import com.meeting.matching.model.MatchResultDTO;

@WebServlet("/courtship/profilemessagesend.do")
public class ProfileMessageSend extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String pseq = req.getParameter("pseq");
		String cseq = req.getParameter("cseq");
		String context =req.getParameter("context");
		
		CourtshipDAO dao = new CourtshipDAO();
		
		MatchResultDTO dto = new MatchResultDTO();
		
		dto.setCseq(cseq);
		dto.setPcseq(pseq);
		dto.setContent(context);
		
		int result = dao.pprofileMatchResult(dto);
		
		int presult = dao.profileMatchResult(dto);
		
		System.out.println(result);
		System.out.println(presult);
		
		if (result == 1 && presult == 1) {
			//resp.sendRedirect("/Meeting/courtship/profilemesseageresult.do");
			resp.getWriter().print("<script>alert('Success');window.close();</script>");
			resp.getWriter().close();
		} else {
			resp.getWriter().print("<script>alert('Error');history.back();</script>");
			resp.getWriter().close();
		}
		
	}
}
