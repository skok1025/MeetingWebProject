package com.meeting.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.community.model.CommunityCommentDTO;
import com.meeting.community.model.CommunityDAO;

/**
 * 댓글 추가
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communityaddcomment.do")
public class CommunityAddComment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//댓글 내용
		String content = req.getParameter("comments");
		//커뮤니티 번호
		String pseq = req.getParameter("pseq");

		CommunityDAO dao = new CommunityDAO();

		CommunityCommentDTO dto = new CommunityCommentDTO();

		dto.setContent(content);
		dto.setCmseq(pseq);
		dto.setCseq(session.getAttribute("cseq").toString());
		
		int result = dao.addComment(dto);

		String rseq = "";
		String rid = "";
		String rcomments = "";
		String rregdate = "";
		String rpseq = "";
		String rname = "";
		String rstate = "";

		if (result == 1) {

			dto = dao.getCommunityComment(); 

			if (dto != null) {
				rstate = "1";
				rseq = dto.getSeq();
				rid = dto.getName();
				rcomments = dto.getContent();
				rregdate = dto.getRegdate();
				rpseq = dto.getCseq();
				rname = dto.getCmseq();
				System.out.println(dto);
			} else {
				
			}

		} else {
			
		}
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		String txt = "";

		txt += "{";
		txt += String.format("\"state\":\"%s\",", rstate);
		txt += "\"dto\": {";
		txt += String.format("\"seq\": \"%s\",", rseq);
		txt += String.format("\"id\": \"%s\",", rid);
		txt += String.format("\"comments\": \"%s\",", rcomments);
		txt += String.format("\"regdate\": \"%s\",", rregdate);
		txt += String.format("\"pseq\": \"%s\",", rpseq);
		txt += String.format("\"name\": \"%s\"", rname);
		txt += "}";
		txt += "}";
		System.out.println("txt" + txt);
		resp.getWriter().println(txt);
		resp.getWriter().close();
	}
}