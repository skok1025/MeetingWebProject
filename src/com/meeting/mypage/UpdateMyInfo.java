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

import com.meeting.mypage.model.MypageDAO;

/**
 * 나의 정보를 수정하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/updatemyinfo.do")
public class UpdateMyInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// 소지역리스트 , 대지역 리스트
		MypageDAO dao = new MypageDAO();
		
		// 현재 소지역
		String mysmallarea = dao.getSmallarea(session.getAttribute("id").toString());
		String mybigarea = dao.getBigarea(session.getAttribute("id").toString());
		
		ArrayList<String> bigareaList = dao.getBigAreaList();
		
		session.setAttribute("introduce", session.getAttribute("introduce").toString().replace("<br>", "\r\n"));
		
		
		req.setAttribute("bigareaList", bigareaList);
		req.setAttribute("mysmallarea", mysmallarea);
		req.setAttribute("mybigarea", mybigarea);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/updatemyinfo.jsp");
		dispatcher.forward(req, resp);

	}

}