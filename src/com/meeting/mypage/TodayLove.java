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

import com.meeting.matching.model.MatchResultDTO;
import com.meeting.mypage.model.MatchOpponentDTO;
import com.meeting.mypage.model.MypageDAO;


/**
 * 오늘의 인연(상대가 보낸 메세지 리스트를 보여줌) Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/todaylove.do")
public class TodayLove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		MypageDAO dao = new MypageDAO();
		
		String cseq = session.getAttribute("cseq").toString();
		
		// 상대가 보낸 매칭 결과 요청 리스트
		ArrayList<MatchOpponentDTO> mlist = dao.getMatchResultNotConfirm(cseq);
		System.out.println(mlist);
		req.setAttribute("mlist", mlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/todaylove.jsp");
		dispatcher.forward(req, resp);

	}

}