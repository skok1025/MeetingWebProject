package com.meeting.love;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.meeting.love.model.LoveDAO;
import com.meeting.love.model.TestResultDTO;

/**
 * 러브테스트 결과 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/love/lovetestresult.do")
public class LoveTestResult extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String result = "";
		int yes = 0;
		int no = 0;
		int finalresult = 0;
		
		for(int i=1; i<=12; i++) {
			result = req.getParameter("hq"+i);
			System.out.println(result);
			
			if(result.equals("y")) {
				yes += 1; 
			} else {
				no += 1;
			}
		}
		
		if(yes > no) {
			if(yes > 9 && yes <= 12) {
				finalresult = 1;
			} else if(yes > 6 && yes <= 9) {
				finalresult = 2;
			}
		} else if(no < yes) {
			if(no > 9 && no <= 12) {
				finalresult = 4;
			} else if(no > 6 && no <= 9) {
				finalresult = 3;
			}
		} else {
			finalresult = 5;
		}
		
		LoveDAO dao = new LoveDAO();
		
		TestResultDTO dto = dao.testResult(finalresult);

		dto.setContent(dto.getContent().replace("\\r\\n", "<br />").replace("장점", "<b>장점</b>").replace("단점", "<b>단점</b>")
				.replace("L타입", "<b>L타입</b>").replace("O타입", "<b>O타입</b>").replace("V타입", "<b>V타입</b>")
				.replace("E타입", "<b>E타입</b>").replace("Psycho 타입", "<b>Psycho타입</b>"));
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/love/lovetestresult.jsp");
		dispatcher.forward(req, resp);
		
	}
}