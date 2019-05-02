package com.meeting.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입 시 진행하는 외향적 테스트 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/extroverttest.do")
public class ExtrovertTest extends HttpServlet {

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
		String ltseq = req.getParameter("ltseq");
		String plan = req.getParameter("plan");
		String style = req.getParameter("style");
		String humor = req.getParameter("humor");
		String gender = req.getParameter("gender");
		
		System.out.println("=========== Extrovert Test =============");
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
		System.out.println("ltseq:"+ltseq);
		System.out.println("plan:"+plan);
		System.out.println("style:"+style);
		System.out.println("humor:"+humor);
		System.out.println("gender:"+gender);
		
		System.out.println("==================================");
		
		 String result = "";
		 String answer = "";
		int scorecnt = 0;
		
		for(int i=1; i<=10; i++) {
	         result = req.getParameter("hq"+i);
	         answer = req.getParameter("answer"+i);
	         
	         if(result.equals(answer)) {
	        	 scorecnt++;
	         }
	        
	    }
		System.out.println("Sense:"+scorecnt);
		
		JoinDAO dao = new JoinDAO();
		
		 ArrayList<ExamDTO> list = dao.getTestList("Extrovert");
		
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
		req.setAttribute("pseq", pseq);
		req.setAttribute("saseq", saseq);
		req.setAttribute("introduce", introduce);
		req.setAttribute("ltseq", ltseq);
		req.setAttribute("plan", plan);
		req.setAttribute("style", style);
		req.setAttribute("humor", humor);
		req.setAttribute("sense", scorecnt);
		req.setAttribute("gender", gender);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/extroverttest.jsp");
		dispatcher.forward(req, resp);

	}

}