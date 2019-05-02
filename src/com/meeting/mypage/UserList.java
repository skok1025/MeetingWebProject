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

import com.meeting.mypage.model.CustomerDetailDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 매니저의 담당회원 리스트 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/userlist.do")
public class UserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		MypageDAO dao = new MypageDAO();
		
		// 담당 회원 정보리스트 
		ArrayList<CustomerDetailDTO> clist = dao.getCustomerDetailList(session.getAttribute("id").toString());
		
		req.setAttribute("clist", clist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/manager/userlist.jsp");
		dispatcher.forward(req, resp);

	}

}
