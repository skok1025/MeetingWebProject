package com.meeting.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.DateRecommendDTO;

@WebServlet("/community/daterecommendaddok.do")
public class DateRecommendAddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		CommunityDAO dao = new CommunityDAO();
		
		DateRecommendDTO dto = new DateRecommendDTO();
		
		req.setCharacterEncoding("UTF-8");
		
		String mode = req.getParameter("mode");
		System.out.println("mode : "+mode);
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String lat = req.getParameter("lat");
		String lng = req.getParameter("lng");
		String categorynum = req.getParameter("category");
		String area = req.getParameter("area");
		
		
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		System.out.println("lat : "+lat);
		System.out.println("lng : "+lng);
		System.out.println("categorynum : "+categorynum);
		System.out.println("area : "+area);
		
		dto.setArea(area);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setLat(lat);
		dto.setLng(lng);
		dto.setCategory(categorynum);
		System.out.println();
		
		
		System.out.println(session.getAttribute("seq").toString());
		dto.setId(session.getAttribute("id").toString());
		dto.setManagernum(session.getAttribute("seq").toString());  //session매니저 번호

		int result = dao.add(dto);
		
		String seq = dao.getSeq();  //방금 쓴 글의 seq값
		
		dao.close();
		
		
		resp.setHeader("Content-type", "application/json");
		
		if (result == 1) {
			resp.sendRedirect("/Meeting/community/daterecommend.do");
			resp.getWriter().print(String.format("{ \"result\": \"%d\" }", result));
		} else {
			resp.getWriter().print("<script> alert('failed');history.back(); </script>");
			resp.getWriter().close();
		}
		
		



	}
}

