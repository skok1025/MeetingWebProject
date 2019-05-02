package com.meeting.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.mypage.model.CustomerDTO;
import com.meeting.mypage.model.CustomerDetailDTO;

@WebServlet("/main/adduserok.do")
public class AddUserOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mseq = req.getParameter("mseq");
		String nick = req.getParameter("nick");
		
		if(name == null || name.equals("")) { // 네이버 로그인인 경우?
			name = session.getAttribute("naverName").toString();
			id = session.getAttribute("naverId").toString();
			pw = "naver";
			nick = session.getAttribute("naverNick").toString();
		}
		
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
		String sense = req.getParameter("sense");
		String extrovert = req.getParameter("extrovert");
		String gender = req.getParameter("gender");
		
		System.out.println("=========== Result Test =============");
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
		System.out.println("sense:"+sense);
		System.out.println("extrovert:"+extrovert);
		System.out.println("==================================");
		
		String result = "";
		 String answer = "";
		int scorecnt = 0;
		
		for(int i=11; i<=20; i++) {
	         result = req.getParameter("hq"+i);
	         answer = req.getParameter("answer"+i);
	         
	         if(result.equals(answer)) {
	        	 scorecnt++;
	         }
	        
	    }
		System.out.println("alacrity:"+scorecnt);
		String alacrity = scorecnt+"";
		
		JoinDAO dao = new JoinDAO();
		CustomerDTO cdto = new CustomerDTO(); 
		
		cdto.setId(id);
		cdto.setName(name);
		cdto.setNick(nick);
		cdto.setGender(gender);
		cdto.setMseq(mseq);
		
		System.out.println("네이버 이름: "+session.getAttribute("naverName").toString());
		System.out.println("dto 이름:"+cdto.getName());
		int result1 = dao.addUserfirst(cdto);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
	 
		if(result1 == 1) {
			int cseq = dao.getMaxCseq();
			
			CustomerDetailDTO dto = new CustomerDetailDTO();
			dto.setPw(pw);
			dto.setTel(tel);
			dto.setAge(age);
			dto.setAbility(ability);
			dto.setHeight(height);
			dto.setJob(job);
			dto.setPlan(Integer.parseInt(plan));
			dto.setHumor(Integer.parseInt(humor));
			dto.setAlacrity(Integer.parseInt(alacrity));
			dto.setSense(Integer.parseInt(sense));
			dto.setExtrovert(Integer.parseInt(extrovert));
			dto.setStyle(Integer.parseInt(style));
			dto.setCseq(cseq+"");
			dto.setLtseq(ltseq);
			dto.setSaseq(saseq);
			dto.setPseq(pseq);
			dto.setIntroduce(introduce);
			
			int result2 = dao.addUserSecond(dto);
			dao.addUsserThird(cseq);
			
			int cdseq = dao.getMaxCdseq();
			
			dao.addUserFirth(cdseq);
			
			System.out.println("네이버 이미지 업데이트 전: "+session.getAttribute("naverImg").toString());
			
			// session 의 naverImg 가 null 이 아니면 
			// cseq 의 이미지를 네이버 이미지로
			if(session.getAttribute("naverImg") != null || session.getAttribute("naverImg").toString() != "") {
				dao.updateImage(cseq,session.getAttribute("naverImg").toString());
			}
			
			if(result2==1) {
				resp.getWriter().write("<script>alert('가입완료 새로 로그인해주세요!!'); location.href='/Meeting/main/login.do';</script>");
			} else {
				resp.getWriter().write("<script>alert('가입 실패'); history.back();</script>");
			}
			
			
		} else {
			resp.getWriter().write("<script>alert('가입 실패'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
		
		


	}

}