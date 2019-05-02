package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.main.LoginDAO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 유저 탈퇴 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/userdelete.do")
public class UserDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id"); // 삭제할 유저 아이디
		
		MypageDAO dao = new MypageDAO();
		int result = dao.withdraw(id, "매니저 요청");	
		
			resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		
			if(result == 1) {
				resp.getWriter().write("<script>alert('탈퇴 완료했습니다.'); location.href='/Meeting/mypage/manager/userlist.do'</script>");	
			} else {
				resp.getWriter().print("<script> alert('탈퇴 실패했습니다.'); history.back(); </script>");
			}
		
			
		
		
		resp.getWriter().println("</head><body></body></html>");

	}

}