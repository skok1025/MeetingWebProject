package com.meeting.courtship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.courtship.model.CourtshipDAO;
import com.meeting.courtship.model.CustomerAllDetailDTO;
import com.meeting.courtship.model.CustomerProfileDTO;

@WebServlet("/courtship/profile.do")
public class Profile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String gender = session.getAttribute("gender").toString();
		
		Random rnd = new Random();

		CourtshipDAO dao = new CourtshipDAO();

		ArrayList<CustomerProfileDTO> list = dao.list();

		String temp = req.getParameter("seq");
		int seq = 0;
		int nseq = 0;
		
		if (temp != null && temp != "") {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		
		boolean check = true;

		while (check) {

			nseq = rnd.nextInt(list.size()) + 1;

			if (!list.get(nseq).getGender().equals(gender)) {
				check = false;
			}
		}
		
		if (temp == null || temp == "") {
			seq = nseq;
		}
		

		int lovecnt = dao.getLoveCnt(seq);
		
		String cseq = session.getAttribute("cseq").toString();

		CustomerAllDetailDTO dto = dao.detail(seq + ""); //seq => now

		System.out.println(seq);
		req.setAttribute("seq", seq);
		req.setAttribute("lovecnt", lovecnt);
		req.setAttribute("dto", dto);
		req.setAttribute("cseq", cseq);
		req.setAttribute("nseq", nseq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/courtship/profile.jsp");
		dispatcher.forward(req, resp);

	}
}