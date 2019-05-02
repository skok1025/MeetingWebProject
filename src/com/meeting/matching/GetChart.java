package com.meeting.matching;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import com.meeting.matching.model.MatchingDAO;

/**
 * 단계에 속하는 최종 회원 정보를 가져오는 클래스
 * @author 한상민
 *
 */
@WebServlet("/matching/getchart.do")
public class GetChart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String min = req.getParameter("min");
		String max = req.getParameter("max");
		String choiceBigArea = req.getParameter("choiceBigArea");
		String choiceSmallArea = req.getParameter("choiceSmallArea");
		//회원번호,성별 테스트
		String gender = session.getAttribute("gender").toString();
		String ppseq = session.getAttribute("cseq").toString();
		
		
		
		System.out.println(gender);
		System.out.println(ppseq);
		System.out.println(req.getParameter("min"));
		System.out.println(max);
		System.out.println(choiceBigArea);
		System.out.println(choiceSmallArea);
		
		MatchingDAO dao = new MatchingDAO();
		
		JSONArray chartList = dao.getChartList(ppseq,min,max,choiceBigArea,choiceSmallArea,gender);
		
		System.out.println(chartList.size());
		
		/*System.out.println(chartList.size());*/
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().print(chartList);
		resp.getWriter().close();
		
	      
	      
	}
}













