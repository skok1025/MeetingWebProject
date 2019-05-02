package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.meeting.mypage.model.MypageDAO;

/**
 * 관리자 통계 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/admin/statistics.do")
public class Statistics extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MypageDAO dao = new MypageDAO();
		
		JSONArray array = dao.getDateCategoryCntArray();  // 카테고리별 카운트 어레이 반환
		
		// 남자 수 
		int mancnt = dao.getManCnt("남자");
		// 여자 수
		int womancnt = dao.getManCnt("여자");
		
		req.setAttribute("mancnt", mancnt);
		req.setAttribute("womancnt", womancnt);
		req.setAttribute("array", array);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/admin/statistics.jsp");
		dispatcher.forward(req, resp);

	}

}