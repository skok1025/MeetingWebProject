package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 비밀번호 수정 결과 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/updatepwok.do")
public class UpdatePwOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String pw = req.getParameter("password");
		System.out.println(pw);
		System.out.println(session.getAttribute("pw"));
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		
		if(pw.equals(session.getAttribute("pw").toString())) {
			resp.sendRedirect("/Meeting/mypage/updatemyinfo.do");
		} else {
			resp.getWriter().write("<script>alert('비밀번호 오류'); history.back();</script>");
		}
		
		resp.getWriter().println("</head><body></body></html>");

	}

}
