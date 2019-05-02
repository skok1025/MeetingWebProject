package com.meeting.matching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.mail.Session;
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


/**
 * 차트에 이용할 정보를 가져오는 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/chartresult.do")
public class ChartResult extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		

		String seq = session.getAttribute("cseq").toString();
		String pseq = req.getParameter("pseq");
	      
	    CourtshipDAO dao = new CourtshipDAO();
	      
	    //ArrayList<CustomerProfileDTO> list = dao.list();

	    /*int seq = 0;
	    boolean check = true;
	      
	    while(check) {
	         
	       seq = rnd.nextInt(list.size())+1;
	         
	       if(list.get(seq).getGender().equals("남자")) {
	            check = false;
	       }
	         
	    }
	    */
	    CustomerAllDetailDTO dto = dao.detail(seq);
	    CustomerAllDetailDTO seconddto = dao.detail(pseq);
	    
	    System.out.println("dto"+dto);
	    System.out.println("seconddto"+seconddto);
	    
	    seconddto.setContent(dto.getContent().replace("\\r\\n", "<br />").replace("장점", "<b>장점</b>").replace("단점", "<b>단점</b>")
	            .replace("L타입", "<b>L타입</b>").replace("O타입", "<b>O타입</b>").replace("V타입", "<b>V타입</b>")
	            .replace("E타입", "<b>E타입</b>").replace("Psycho 타입", "<b>Psycho타입</b>"));
	      
	      
	    req.setAttribute("dto", dto);
	    req.setAttribute("seconddto", seconddto);
	   
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("//WEB-INF/view/matching/chartresult.jsp");
		dispatcher.forward(req, resp);
	}
}





