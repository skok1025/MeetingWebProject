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
import javax.servlet.http.HttpSession;

import com.meeting.courtship.model.CourtshipDAO;
import com.meeting.courtship.model.CustomerAllDetailDTO;
import com.meeting.courtship.model.CustomerProfileDTO;
import com.meeting.matching.model.MatchingDAO;

/**
 * 회원을 랜덤으로 추천해주는 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/managermatching.do")
public class ManagerMatching extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		/*String cseq = session.getAttribute("cseq").toString();*/
		String gender = session.getAttribute("gender").toString();
		System.out.println("gender : " + gender);	
		int seq;
		
		boolean check = true;
		
		
		if(gender == "남자") {
			gender = "여자";
		} else if(gender =="여자") {
			gender ="남자";
		}
		
		Random rnd = new Random();
		
		ArrayList<Integer> randomCustomer = new ArrayList<Integer>();
		
		CourtshipDAO dao = new CourtshipDAO();
	      
	    ArrayList<CustomerProfileDTO> list = dao.list();
	    
    	int k =0;
    	
    		while(k < 9) {
    			seq = rnd.nextInt(list.size())+1;
        		/*System.out.println(list.get(seq).getGender().equals("여자"));*/
        		if(list.get(seq).getGender().equals(gender)) {
        			randomCustomer.add(seq);
        			k++;
        		}
    		}
    		
    		System.out.println(randomCustomer.size());

	   
	    
		MatchingDAO daoMatch = new MatchingDAO();
		CustomerAllDetailDTO dto = new CustomerAllDetailDTO();
		
		ArrayList<CustomerAllDetailDTO> listCustomer = daoMatch.getManagerMatching(randomCustomer);
		
	   
		req.setAttribute("listCustomer", listCustomer);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/matching/managermatching.jsp");
		dispatcher.forward(req, resp);
	}
}





