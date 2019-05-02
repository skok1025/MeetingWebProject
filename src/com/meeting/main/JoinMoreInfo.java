package com.meeting.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.meeting.mypage.model.MypageDAO;
import com.meeting.mypage.model.PersonalityDTO;

/**
 * 회원가입 시, 추가정보를 입력하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/joinmoreinfo.do")
public class JoinMoreInfo extends HttpServlet {
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("UTF-8");
		
		Random rand = new Random();
		
		String name = req.getParameter("username");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String mseq = (rand.nextInt(10)+1)+"";
		
		HttpSession session = req.getSession();
		
		// 소지역리스트 , 대지역 리스트
		MypageDAO dao = new MypageDAO();
		
		ArrayList<String> bigareaList = dao.getBigAreaList();
		
		req.setAttribute("bigareaList", bigareaList);
		
		ArrayList<PersonalityDTO> personalityList = dao.getPersonalityList();
		
		req.setAttribute("personalityList", personalityList);
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("mseq", mseq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/joinmoreinfo.jsp");
		dispatcher.forward(req, resp);	
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	
	
	

}