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
 * 오늘의 인연에 온 상대방의 메세지에 수락할지 거절할지 여부 등록 성공을 결정하는 Servlet 클래스 
 * @author 김석현
 *
 */
@WebServlet("/mypage/meetingresultconfirm.do")
public class MeetingResultConfirm extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq"); // 적용할 MatchResult seq
		String accept = req.getParameter("accept");
		String confirm = req.getParameter("confirm");
		
		//System.out.println(seq);
		//System.out.println(accept);
		//System.out.println(confirm);
		
		MypageDAO dao = new MypageDAO();
		int result = dao.accepttblMatchResult(seq,accept,confirm);
		
		
		
		resp.getWriter().println(result);
		resp.getWriter().close();
		
		
		/*
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/meetingresultconfirm.jsp");
		dispatcher.forward(req, resp);*/

	}

}