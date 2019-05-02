package com.meeting.introduce.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/introduce/manager.do")
public class Manager extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//manager 정보 반환받아서 가져오기
		
		IntroduceDAO dao = new IntroduceDAO();
		/*ArrayList<IntroduceDTO> list = dao.list();*/
		IntroduceDTO dto = dao.list();
		ArrayList<IntroduceDTO> ilist = dao.managerList();
		 
		req.setAttribute("dto", dto);
		//System.out.println("java dto : " +  dto.getName());
		
		/*resp.setHeader("Content-Type", "application/json");
		resp.setCharacterEncoding("UTF-8");*/
		
		/*
		 	{
		 		"seq" : "seq",
		 		"name" : "name",
		 		"managerInfo" : "managerInfo",
		 		"age" : "age"
		 	}
		  
		 */
		/*resp.getWriter().println(txt);
		resp.getWriter().close();*/
		
		req.setAttribute("ilist", ilist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/introduce/manager.jsp");
		dispatcher.forward(req, resp);
	}
}

