package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.mypage.model.CustomerDetailDTO;
import com.meeting.mypage.model.MypageDAO;
import com.meeting.mypage.model.ScoreAvgDTO;
import com.meeting.mypage.model.ScoreDTO;

/**
 * 매니저의 회원 상세정보 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/userview.do")
public class UserView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id"); // 회원 아이디
		
		MypageDAO dao = new MypageDAO();
		
		CustomerDetailDTO dto =  dao.getCustomerDetail(id);
		
		// 해당회원의 점수 및 성별 평균 점수
		ScoreDTO scoredto = dao.getScoreDTO(dto.getId());
		ScoreAvgDTO avgdto = dao.getScoreAvgDTO(dto.getGender());
		
		req.setAttribute("dto", dto);
		req.setAttribute("scoredto", scoredto);
		req.setAttribute("avgdto", avgdto);
		req.setAttribute("userid", id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/manager/userview.jsp");
		dispatcher.forward(req, resp);

	}

}