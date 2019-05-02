package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.mypage.model.MypageDAO;

/**
 * 회원의 탈퇴 성공유무에 대한 Servlet 클래스 
 * @author 김석현
 *
 */
@WebServlet("/mypage/withdrawok.do")
public class WithDrawOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		String pw = req.getParameter("password");
		String reason = req.getParameter("reason");
		
		System.out.println(session.getAttribute("id"));
		
		resp.setCharacterEncoding("UTF-8");
		
		MypageDAO dao = new MypageDAO();
		
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		
		if(session.getAttribute("pw").toString().equals(pw)) {
			int result = dao.withdraw(session.getAttribute("id").toString(),reason);
			
			if(result == 1) {
				resp.getWriter().write("<script>alert('탈퇴 완료했습니다.'); location.href='/Meeting/sample/template.do'</script>");	
			} else {
				resp.getWriter().print("<script> alert('탈퇴 실패했습니다.'); history.back(); </script>");
			}
		
			
		} else {
			resp.getWriter().print("<script> alert('비밀번호가 틀립니다.'); history.back(); </script>");
			resp.getWriter().close();
		}
		
		resp.getWriter().println("</head><body></body></html>");
	}

}
