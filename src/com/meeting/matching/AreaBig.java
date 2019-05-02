package com.meeting.matching;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.meeting.matching.model.MatchingDAO;
import com.meeting.mypage.model.BigAreaDTO;

/**
 * 지역(구)의 속하는 지역(동)을 가져오는 클래스
 * @author 한싱민
 *
 */
@WebServlet("/matching/areabig.do")
public class AreaBig extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String bigarea = req.getParameter("bigarea");
		
		MatchingDAO dao = new MatchingDAO();
		BigAreaDTO dto = new BigAreaDTO();
		
		/*ArrayList<BigAreaDTO> area = dao.getAreaBig(bigarea);*/
		JSONArray area = dao.getAreaBig(bigarea);
		
/*		req.setAttribute("area",area);*/
		
		/*JSONArray array = dao.list();*/
	      
	    resp.setHeader("Content-type", "application/json");
	    resp.setCharacterEncoding("UTF-8");
	      
	    resp.getWriter().print(area);
	    resp.getWriter().close();
		
		
	}
}