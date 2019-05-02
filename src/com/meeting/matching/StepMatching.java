package com.meeting.matching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.courtship.model.CourtshipDAO;
import com.meeting.courtship.model.CustomerAllDetailDTO;
import com.meeting.courtship.model.CustomerProfileDTO;

/**
 * 단계별 매칭 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/stepmatching.do")
public class StepMatching extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Random rnd = new Random();
		
		String seq1 = req.getParameter("seq");
	      
	    CourtshipDAO dao = new CourtshipDAO();
	      
	    ArrayList<CustomerProfileDTO> list = dao.list();

	    int seq = 0;
	    boolean check = true;
	      
	    while(check) {
	         
	       seq = rnd.nextInt(list.size())+1;
	         
	       if(list.get(seq).getGender().equals("남자")) {
	            check = false;
	       }
	         
	    }
	      
	    CustomerAllDetailDTO dto = dao.detail(seq+"");
	      
	    System.out.println(seq);
	    req.setAttribute("seq", seq);
	      
	    req.setAttribute("dto", dto);
	   
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/matching/stepmatching.jsp");
		dispatcher.forward(req, resp);
	}
}





