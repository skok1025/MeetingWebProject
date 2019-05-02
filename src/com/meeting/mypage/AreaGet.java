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
 * 분류 대지역을 받아서 해당 소지역 리스트를 반환해주는 Servlet 클래스 
 * @author 김석현
 *
 */
@WebServlet("/mypage/areaget.do")
public class AreaGet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bigarea = req.getParameter("bigarea");
		MypageDAO dao = new MypageDAO();
		JSONArray array = dao.getSmallAreaList(bigarea);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "application/json");
		
		resp.getWriter().write(array.toString());
		resp.getWriter().close();
		
		
	}

}
