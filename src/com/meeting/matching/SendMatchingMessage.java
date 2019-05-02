package com.meeting.matching;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.matching.model.MatchingDAO;

/**
 * 매칭 성공 메시지 출력 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/sendmatchingmessage.do")
public class SendMatchingMessage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String cseq = session.getAttribute("cseq").toString();
		String pseq = req.getParameter("pseq");
				
	    System.out.println(cseq);
	    System.out.println(pseq);
		MatchingDAO dao = new MatchingDAO();
	      
	    int result = dao.setMatchingResult(cseq,pseq);
	    
	    System.out.println(result);
	    
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/matching/sendmatchingmessage.jsp");
		dispatcher.forward(req, resp);
	}
}





