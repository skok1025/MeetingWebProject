package com.meeting.matching;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.meeting.matching.model.MatchingDAO;

/**
 * 나이 최소,최대 범위를 통해 회원 정보를 가져오는 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/getage.do")
public class GetAge extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String min = req.getParameter("min");
		String max = req.getParameter("max");
		
		
		System.out.println(min);
		System.out.println(max);
		MatchingDAO dao = new MatchingDAO();
		
		JSONArray agelist = dao.getAgeCustomer(min,max);
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().print(agelist);
		resp.getWriter().close();
		
		
		
		/*ArrayList<BigAreaDTO> area = dao.getAreaBig(bigarea);*/
		
	      
	      
	}
}