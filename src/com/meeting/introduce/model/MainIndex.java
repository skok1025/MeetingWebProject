package com.meeting.introduce.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/introduce/mainindex.do")
public class MainIndex extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//좋아요 수가 많은 회원 정보 반환하기
		//1. 좋아요 수가 많은 상위 3명 회원 반환하기
		//2. 반환된 회원의 SEQ로 정보 얻어오기
		
		HttpSession session = req.getSession();
		
		IntroduceDAO dao = new IntroduceDAO();

		ArrayList<CustomerDTO> clist = dao.customerList(); //좋아요 수 상위 세 명 회원 정보 반환
		req.setAttribute("clist", clist);
		
		req.setAttribute("id",session.getAttribute("id"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/introduce/mainindex.jsp");
		dispatcher.forward(req, resp);
	}
}

