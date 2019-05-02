package com.meeting.community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.DateRecommendCommentDTO;
import com.meeting.community.model.DateRecommendDTO;


@WebServlet("/community/daterecommenddetail.do")
public class DateRecommendDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seq = req.getParameter("seq");
		
		req.setCharacterEncoding("UTF-8");
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		boolean isSearch = false;
		
		if (column != "" && word != "" && column != null && word != null) {
			isSearch = true;
		}
		
		HttpSession session = req.getSession();
		
		
		
		CommunityDAO dao = new CommunityDAO();
		
		DateRecommendDTO dto = dao.detail(seq);
		
		int num = dto.getArea().indexOf("구");
		
		//System.out.println("num" + num);
		
		String location1 = dto.getArea().substring(0, num+2);
		
		int locnum = dto.getContent().indexOf("위치 - ");
		//System.out.println("위치 번호" + locnum);
		
		String location2 = dto.getContent().substring(locnum+5);
		
		//System.out.println("location2" + location2);
		
		String location = location1+location2;
		
		//System.out.println("location"+location);
		
		dto.setLocation(location);
		
		
		//글내용에 엔터값 처리하기
		String content = dto.getContent().replace("\\r\\n", "<br>");
		
		dto.setContent(content);
		
		
		
		
		//2.8 댓글 목록 가져오기
		ArrayList<DateRecommendCommentDTO> clist = dao.listComment(seq);//부모글번호 전달
		
		for (DateRecommendCommentDTO cdto : clist) {
			
			//A. 댓글내용의 엔터 처리 -> <br>
			String comments = cdto.getContent();
			comments = comments.replace("\n", "<br>");
			cdto.setContent(comments);
			
			//B. 날짜의 마지막 .0 제거
			String regdate = cdto.getRegdate();
			regdate = cdto.getRegdate();
			regdate = regdate.substring(0, regdate.length()-2);
			cdto.setRegdate(regdate);
		}
		
		boolean iswho = true;
		
		ArrayList<DateRecommendDTO> pclist = dao.getmanager();
		
		for(int i=0; i<pclist.size(); i++) {
			System.out.println(session.getAttribute("id").toString());
			System.out.println(pclist.get(i).getId());
			if(session.getAttribute("id").toString().equals(pclist.get(i).getId())) {
				iswho = false;
				break;
			}
		}
		
		System.out.println(pclist);
		
		req.setAttribute("iswho",iswho); 
		
		dao.close();
		req.setAttribute("iswho", iswho);
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		
		//아래의 2개 데이터는 JSP 사용하기 위해서X, list.do에게 전달하기 위해서
		req.setAttribute("word", word); //검색어
		req.setAttribute("column", column); //컬럼
		req.setAttribute("seq", seq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/daterecommenddetail.jsp");
		dispatcher.forward(req, resp);

	}
}

