package com.meeting.courtship;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.courtship.model.CourtshipDAO;

@WebServlet("/courtship/profilegood.do")
public class ProfileGood extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 데이터 가져오기(state, id, pseq)
		// 2. DAO 위임 -> insert -> 결과
		// 3. Ajax 객체에서 결과 반환

		// 1.
		// String good = req.getParameter("good");
		String cseq = req.getParameter("cseq");
		String pseq = req.getParameter("pseq");

		CourtshipDAO dao = new CourtshipDAO();

		int count = dao.getGood(cseq, pseq);
		
		int result = 0;
		
		if(count == 0) {
			result = dao.addGood(cseq,pseq);
		} else {
			resp.getWriter().write("0");
			resp.getWriter().close();
		}
		
		resp.setCharacterEncoding("UTF-8");
		
		
		if(result == 1) {
			resp.getWriter().write("2");
			resp.getWriter().close();
		} else {
			resp.getWriter().write("1");
			resp.getWriter().close();
		}
	}
	
	
	
	
	
}
