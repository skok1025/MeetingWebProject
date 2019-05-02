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
 * 매니저에게 온 매니저SOS 의 리스트를 보여주고 답변의 성공유무를 알려주는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/managersosdoneok.do")
public class ManagerSosDoneOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String seq = req.getParameter("seq");  // 매니저 sos 번호
		String statuscontent = req.getParameter("statuscontent").replace("\r\n", "<br>"); // 매니저 sos 답변
		
		MypageDAO dao = new MypageDAO();
		int result = dao.doneManagerSOS(seq,statuscontent);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if(result == 1) {
			resp.getWriter().write("<script>alert('매니저 SOS 답변 완료했습니다.'); location.href='/Meeting/mypage/manager/managersos.do';</script>");
		} else {
			resp.getWriter().write("<script>alert('매니저 SOS 답변 실패했습니다.'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
		
		
		
	}

}
