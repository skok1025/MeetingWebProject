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

import com.meeting.mypage.model.MyMeetingDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 해당회원의 미팅현황을 보여주는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/meeting.do")
public class Meeting extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 미팅 리스트 가져오기
		MypageDAO dao = new MypageDAO();
		System.out.println(session.getAttribute("id"));
		ArrayList<MyMeetingDTO> meetinglist =  dao.getMeetingList(session.getAttribute("id").toString());
		System.out.println(meetinglist.size());
		req.setAttribute("meetinglist", meetinglist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/meeting.jsp");
		dispatcher.forward(req, resp);

	}

}