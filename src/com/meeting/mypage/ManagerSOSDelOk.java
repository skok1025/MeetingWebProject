package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.mypage.model.MypageDAO;

/**
 * 매니저SOS 를 삭제하고 성공유무를 반환하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/managersosdelok.do")
public class ManagerSOSDelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq"); // 삭제할 매니저 sos seq
		
		MypageDAO dao = new MypageDAO();
		
		int result = dao.delManagerSOS(seq);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if(result == 1) {
			resp.getWriter().write("<script>alert('매니저 SOS 삭제 완료했습니다.'); location.href='/Meeting/mypage/manager/managersoslistdone.do';</script>");
		} else {
			resp.getWriter().write("<script>alert('매니저 SOS 삭제 실패했습니다.'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
	}

}
