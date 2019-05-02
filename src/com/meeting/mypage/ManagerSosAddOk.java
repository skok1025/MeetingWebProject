package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.mypage.model.ManagerSOSDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 매니저 SOS 를 추가하고 성공유무를 반환하는 Servlet 클래스
 * @author sist40
 *
 */
@WebServlet("/mypage/managersosaddok.do")
public class ManagerSosAddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String content = req.getParameter("content").replace("\r\n", "<br>");
		String mseq = req.getParameter("mseq");
		String cseq = req.getParameter("cseq");
		
		MypageDAO dao = new MypageDAO();
		ManagerSOSDTO dto = new ManagerSOSDTO();
		
		dto.setContent(content);
		dto.setMseq(mseq);
		dto.setCseq(cseq);
		
		
		// 매니저 SOS 등록
		int result = dao.addManagerSOS(dto);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if(result == 1) {
			resp.getWriter().write("<script>alert('매니저 SOS 등록 완료했습니다.'); location.href='/Meeting/mypage/managersoslist.do';</script>");
		} else {
			resp.getWriter().write("<script>alert('매니저 SOS 등록 실패했습니다.'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
	}

}