package com.meeting.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 로그아웃 시, session 처리가 이뤄지는 Servlet 클래스 
 * @author 김석현
 *
 */
@WebServlet("/main/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("nick");
		session.removeAttribute("grade");
		session.removeAttribute("pw");
		session.removeAttribute("profileimage");
		session.removeAttribute("tel");
		session.removeAttribute("age");
		session.removeAttribute("ability");
		session.removeAttribute("height");
		session.removeAttribute("job");
		session.removeAttribute("smallhobby");
		session.removeAttribute("smallarea");
		session.removeAttribute("bigarea");
		session.removeAttribute("content");
		session.removeAttribute("badge");
		
		session.removeAttribute("isUser");
		session.removeAttribute("isAdmin");
		session.removeAttribute("isManager");
	
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		resp.getWriter().write("<script>alert('로그아웃 하셨습니다.'); location.href = '/Meeting/main/login.do'</script>");
		resp.getWriter().println("</head><body></body></html>");
		resp.getWriter().close();
		

	}

}