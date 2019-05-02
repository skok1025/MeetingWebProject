package com.meeting.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.main.model.PlanDTO;


/**
 * 회원가입시, 진행하는 계획성 테스트 관련 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/plantest.do")
public class PlanTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mseq = req.getParameter("mseq");
		
		String nick = req.getParameter("nick");
		String tel = req.getParameter("tel");
		String age = req.getParameter("age");
		String ability = req.getParameter("ability");
		String height = req.getParameter("height");
		String job = req.getParameter("job");
		String pseq = req.getParameter("pseq");
		String saseq = req.getParameter("saseq");
		String introduce = req.getParameter("introduce");
		String gender = req.getParameter("gender");
		
		System.out.println("=========== Plan Test =============");
		System.out.println("name:"+name);
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		System.out.println("mseq: "+mseq);
		System.out.println("nick:"+nick);
		System.out.println("tel:"+tel);
		System.out.println("age:"+age);
		System.out.println("ability:"+ability);
		System.out.println("height:"+height);
		System.out.println("job:"+job);
		System.out.println("pseq:"+pseq);
		System.out.println("saseq:"+saseq);
		System.out.println("introduce:"+introduce);
		System.out.println("gender:"+gender);
		
		System.out.println("==================================");
		 String result = "";
	      int yes = 0;
	      int no = 0;
	      int ltseq = 0;
	      
	      for(int i=1; i<=12; i++) {
	         result = req.getParameter("hq"+i);
	         System.out.println(result);
	         
	         if(result.equals("y")) {
	            yes += 1; 
	         } else {
	            no += 1;
	         }
	      }
	      
	      if(yes > no) {
	         if(yes > 9 && yes <= 12) {
	        	 ltseq = 1;
	         } else if(yes > 6 && yes <= 9) {
	        	 ltseq = 2;
	         }
	      } else if(no < yes) {
	         if(no > 9 && no <= 12) {
	        	 ltseq = 4;
	         } else if(no > 6 && no <= 9) {
	        	 ltseq = 3;
	         }
	      } else {
	    	  ltseq = 5;
	      }
	      
	      System.out.println("ltseq:"+ltseq);
	      
	      // PlanTest 가져오기
	      JoinDAO dao = new JoinDAO();
	      ArrayList<ExamDTO> list = dao.getTestList("Plan");

	      req.setAttribute("list", list);
			req.setAttribute("name", name);
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);
			req.setAttribute("mseq", mseq);
			req.setAttribute("nick", nick);
			req.setAttribute("tel", tel);
			req.setAttribute("age", age);
			req.setAttribute("ability", ability);
			req.setAttribute("height", height);
			req.setAttribute("job", job);
			req.setAttribute("gender", gender);
			req.setAttribute("pseq", pseq);
			req.setAttribute("saseq", saseq);
			req.setAttribute("introduce", introduce);
			req.setAttribute("ltseq", ltseq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/plantest.jsp");
		dispatcher.forward(req, resp);

	}

}
