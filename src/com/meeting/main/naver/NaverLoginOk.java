package com.meeting.main.naver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.main.LoginDAO;
import com.meeting.main.LoginDTO;

@WebServlet("/main/naver/naverloginok.do")
public class NaverLoginOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String id = session.getAttribute("naverId").toString();
		System.out.println("네이버 아이디:"+session.getAttribute("naverId").toString());
		String pw = "naver";
		boolean isUser = false;
		boolean isManager = false;
		boolean isAdmin = false;
		
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		
		
		LoginDAO dao = new LoginDAO();
		
		// 회원인지 매니저인지 관리자인지
		isUser = dao.isUser(id);
		isManager = dao.isManager(id);
		isAdmin = dao.isAdmin(id);
		
		String profileImage=null;
		String gradeBadge=null;
		
		int userResult = 0;
		if(isUser) {
			userResult = dao.loginOk(dto);
			dto = dao.login(dto); 
			
		} 
		else if(isManager) {
			dto = dao.managerLogin(dto);
		} 
		else if(isAdmin) {
			dto = dao.adminLogin(dto);
		} else {
			dto = null;
		}
		
		
		
		resp.setCharacterEncoding("UTF-8");

		session.setAttribute("isUser", isUser);
		session.setAttribute("isManager", isManager);
		session.setAttribute("isAdmin", isAdmin);
		
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if((userResult == 1 || dto !=null) && isUser) { // 로그인 성공
			if(dto !=null) {
				
			profileImage = dao.getProfileIm(dto.getId());
			gradeBadge = dao.getBadge(dto.getGrade());
			
			session.setAttribute("cseq", dto.getCseq());
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
			session.setAttribute("nick", dto.getNick());
			session.setAttribute("grade", dto.getGrade());
			session.setAttribute("pw", dto.getPw());
			session.setAttribute("profileimage", dto.getImage());
			session.setAttribute("tel", dto.getTel());
			session.setAttribute("age", dto.getAge());
			session.setAttribute("ability", dto.getAbility());
			session.setAttribute("height", dto.getHeight());
			session.setAttribute("job", dto.getJob());
			session.setAttribute("smallhobby", dto.getSmallhobby());
			session.setAttribute("smallarea", dto.getSmallarea());
			session.setAttribute("bigarea", dto.getBigarea());
			session.setAttribute("content", dto.getContent().replace("\r\n", "<br>"));
			session.setAttribute("introduce", dto.getIntroduce());
			session.setAttribute("gender", dto.getGender());
			
			session.setAttribute("profileimage", profileImage);
			session.setAttribute("badge", gradeBadge);
			}
			
			resp.sendRedirect("/Meeting/sample/template.do");
		} else if(dto !=null && isManager){
			session.setAttribute("id", dto.getId());
			session.setAttribute("pw",dto.getPw());
			session.setAttribute("ssn", dto.getSsn());
			session.setAttribute("name", dto.getName());
			session.setAttribute("age", dto.getAge());
			session.setAttribute("regdate", dto.getRegdate());
			
			resp.sendRedirect("/Meeting/sample/template.do");
		} else if(dto !=null && isAdmin){
			session.setAttribute("id", dto.getId());
			session.setAttribute("pw",dto.getPw());
			
			resp.sendRedirect("/Meeting/sample/template.do");
		} else { // 로그인 실패
			resp.getWriter().write("<script>alert('로그인 실패하셨습니다. 다시 시도해주세요.'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
		resp.getWriter().close();

	}

}
