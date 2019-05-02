package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.mypage.model.MypageDAO;
import com.meeting.mypage.model.ScoreAvgDTO;
import com.meeting.mypage.model.ScoreDTO;

/**
 * 나의 상세정보를 확인할 수 있는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/myinfo.do")
public class MyInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		MypageDAO dao = new MypageDAO();
		
		/*MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/Meeting/files"),1024*1024*100,"UTF-8",new DefaultFileRenamePolicy());
		
		String profileim = multi.getFilesystemName("profileim");*/
		
		String mysmallarea = dao.getSmallarea(session.getAttribute("id").toString());
		String mybigarea = dao.getBigarea(session.getAttribute("id").toString());
		String image = dao.getImage(session.getAttribute("id").toString());
		System.out.println(session.getAttribute("gender").toString());
		ScoreDTO scoredto = dao.getScoreDTO(session.getAttribute("id").toString());
		ScoreAvgDTO avgdto = dao.getScoreAvgDTO(session.getAttribute("gender").toString());
		
		System.out.println("사용자의 성별:"+session.getAttribute("gender"));
		
		req.setAttribute("mysmallarea", mysmallarea);
		req.setAttribute("mybigarea", mybigarea);
		req.setAttribute("myimg", image);
		req.setAttribute("scoredto", scoredto);
		req.setAttribute("avgdto", avgdto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/mypage/myinfo.jsp");
		dispatcher.forward(req, resp);

	}

}