package com.meeting.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.mypage.model.MatchOpponentDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 내가 보낸 메세지에 대한 상대방의 매칭결과 (수락/거절) 을 알수있는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/mymeetingresultlist.do")
public class MyMeetingResultList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String pcseq = session.getAttribute("cseq").toString(); // 내 번호로 수락여부 확인
		
		MypageDAO dao = new MypageDAO();
		
		ArrayList<MatchOpponentDTO> list = dao.getMyCofirmMiddleList(pcseq); 
		
		dao.updateConfirm(pcseq);
		
		
		
		req.setAttribute("list", list);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/mymeetingresultlist.jsp");
		dispatcher.forward(req, resp);

	}

}