package com.meeting.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.mypage.model.MypageDAO;
import com.meeting.mypage.model.OutCustomerDTO;

/**
 * 매니저의 탈퇴한 회원 리스트 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/withdrawlist.do")
public class WithdrawList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MypageDAO dao = new MypageDAO();
		ArrayList<OutCustomerDTO> oclist = dao.outCustomerList();
		
		req.setAttribute("oclist", oclist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/manager/withdrawlist.jsp");
		dispatcher.forward(req, resp);

	}

}
