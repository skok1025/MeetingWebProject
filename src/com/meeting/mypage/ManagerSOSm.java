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

import com.meeting.mypage.model.CustomerDTO;
import com.meeting.mypage.model.ManagerSOSDTO;
import com.meeting.mypage.model.MypageDAO;


/**
 * 해당 매니저에게 온 담당 회원들의 매니저 SOS 를 보여주는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/managersos.do")
public class ManagerSOSm extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String userid = req.getParameter("userid");
		String whereUserId = "";
		
		if(userid!="" && userid!=null) {
			whereUserId = " and c.id ='"+userid+"'";
		}
		System.out.println(whereUserId);
		// 매니저 아이디 넘기면 담당회원들의 매니저 SOS 리스트 반환한다.
		
		
		
		MypageDAO dao = new MypageDAO();
		ArrayList<ManagerSOSDTO> mlist = dao.getManagerSOSListMnodone(session.getAttribute("id").toString(),whereUserId);

		// 담당회원 아이디, 이름 반환 리스트
		ArrayList<CustomerDTO> clist = dao.getCustomerList(session.getAttribute("id").toString());
		
		
		req.setAttribute("mlist", mlist);
		req.setAttribute("clist", clist);
		req.setAttribute("suserid", userid);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/manager/managersos.jsp");
		dispatcher.forward(req, resp);
		
	}

}
