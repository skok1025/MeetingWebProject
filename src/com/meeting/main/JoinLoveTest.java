package com.meeting.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.love.model.TestDTO;


/**
 * 회원가입시 진행하는 LOVE TEST Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/joinlovetest.do")
public class JoinLoveTest extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mseq = req.getParameter("mseq");
		
		String gender = req.getParameter("gender");
		String nick = req.getParameter("nick");
		String tel = req.getParameter("tel");
		String age = req.getParameter("age");
		String ability = req.getParameter("ability");
		String height = req.getParameter("height");
		String job = req.getParameter("job");
		String pseq = req.getParameter("pseq");
		String saseq = req.getParameter("saseq");
		String introduce = req.getParameter("introduce");
		/*
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(mseq);
		System.out.println(nick);
		System.out.println(tel);
		System.out.println(age);
		System.out.println(ability);
		System.out.println(height);
		System.out.println(job);
		System.out.println(pseq);
		System.out.println(saseq);
		System.out.println(introduce);
		*/
		JoinDAO dao = new JoinDAO();
		
		ArrayList<TestDTO> list = dao.getTestList();
		
		 req.setAttribute("list", list);

		
		
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("mseq", mseq);
		req.setAttribute("nick", nick);
		req.setAttribute("tel", tel);
		req.setAttribute("age", age);
		req.setAttribute("ability", ability);
		req.setAttribute("height", height);
		req.setAttribute("job", job);
		req.setAttribute("pseq", pseq);
		req.setAttribute("saseq", saseq);
		req.setAttribute("introduce", introduce);
		req.setAttribute("gender", gender);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/joinlovetest.jsp");
		dispatcher.forward(req, resp);

	}

}