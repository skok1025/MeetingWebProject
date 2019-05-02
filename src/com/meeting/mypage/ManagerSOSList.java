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

import com.meeting.mypage.model.ManagerDTO;
import com.meeting.mypage.model.ManagerSOSDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 해당회원이 작성한 매니저 SOS 리스트를 반환해주는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/managersoslist.do")
public class ManagerSOSList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		MypageDAO dao = new MypageDAO();
		// 매니저 SOS 리스트 가져오기
		ArrayList<ManagerSOSDTO> mList = dao.getManagerSOSList(session.getAttribute("id").toString());
		
		ManagerDTO mdto  = dao.getManagerInfo(session.getAttribute("id").toString());
		System.out.println(mList);
		
		req.setAttribute("mList", mList);
		req.setAttribute("mdto", mdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/managersoslist.jsp");
		dispatcher.forward(req, resp);

	}

}
