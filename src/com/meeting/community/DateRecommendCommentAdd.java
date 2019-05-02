package com.meeting.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.DateRecommendCommentDTO;

@WebServlet("/community/daterecommendcommentadd.do")
public class DateRecommendCommentAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		String content = req.getParameter("comments");
		String drseq = req.getParameter("drseq");
		
		CommunityDAO dao = new CommunityDAO();
		DateRecommendCommentDTO dto = new DateRecommendCommentDTO();
				
		dto.setContent(content);
		dto.setDrseq(drseq);
		dto.setName(session.getAttribute("name").toString());
		dto.setCseq(session.getAttribute("cseq").toString());
		
		int result = dao.addComment(dto);
		
		String rseq = "";
		String rcontent = "";
		String rregdate = "";
		String rdrseq = "";
		String rcseq = "";
		String rname = "";
		String rstate = "";
		
		if (result == 1) {
			//댓글 쓰기 성공
			//방금 쓴 댓글을 DTO 가져오기
			dto = dao.getContent(); //마지막 쓴 댓글 반환
			
			if (dto != null) {
				//최종 성공(state = 1)
				rstate = "1";
				rseq = dto.getSeq();
				rcontent = dto.getContent().replace("\n", "\\n");
				rregdate = dto.getRegdate();
				rdrseq = dto.getDrseq();
				rcseq = dto.getCseq();
				rname = dto.getName();				
			} else {
				//댓글 가져오기 실패(state = 2)
				rstate = "2";
			}
			
		} else {
			//댓글 쓰기 실패(state = 0)
			rstate = "0";
		}
		
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		String txt = "";
		
		txt += "{";
		txt += String.format("\"state\":\"%s\",", rstate);
		txt += "\"dto\": {";
		txt += String.format("\"seq\": \"%s\",", rseq);
		txt += String.format("\"content\": \"%s\",", rcontent);
		txt += String.format("\"regdate\": \"%s\",", rregdate);
		txt += String.format("\"drseq\": \"%s\",", rdrseq);
		txt += String.format("\"cseq\": \"%s\",", rcseq);
		txt += String.format("\"name\": \"%s\"", rname);
		txt += "}";
		txt += "}";
		
		resp.getWriter().println(txt);
		resp.getWriter().close();
		
		
		
		
		
	}
}
