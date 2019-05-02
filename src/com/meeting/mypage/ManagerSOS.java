package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.mypage.model.ManagerDTO;
import com.meeting.mypage.model.MypageDAO;


/**
 * 매니저 SOS 관련 Servlet 클래스
 * @author 김석현
 * 
 */
@WebServlet("/mypage/managersos.do")
public class ManagerSOS extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		MypageDAO dao = new MypageDAO();
		ManagerDTO mdto = dao.getManagerInfo(session.getAttribute("id").toString());
		String cseq = dao.getCseq(session.getAttribute("id").toString());
		req.setAttribute("mdto", mdto);
		req.setAttribute("cseq", cseq);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/managersos.jsp");
		dispatcher.forward(req, resp);

	}

}