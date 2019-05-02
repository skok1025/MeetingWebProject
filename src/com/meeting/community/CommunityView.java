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

import com.meeting.community.model.CommunityCommentDTO;
import com.meeting.community.model.CommunityDAO;
import com.meeting.community.model.CommunityDTO;

/**
 * 글 세부 사항 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communityview.do")
public class CommunityView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		CommunityDAO dao = new CommunityDAO();
		
		CommunityDTO dto = dao.communityGet(seq);
		
		System.out.println(dto == null);
		
		String regdate = dto.getRegdate();
		regdate = regdate.substring(0, regdate.length()-2);
		
		dto.setRegdate(regdate);
		
		String content = dto.getContent().replace("\\r\\n", "<br>");
		
		dto.setContent(content);
		
		String image = dto.getImage();
		
		if(image != null && image != "") {
			if (image.toLowerCase().endsWith(".jpg") || image.toLowerCase().endsWith(".jpeg")
					|| image.toLowerCase().endsWith(".gif") || image.toLowerCase().endsWith(".png")) {
				content = String.format("<img src='/Meeting/files/%s' style='display:block; margin: 20px 0px;' id='attachimg'>",image) + content;
				
				dto.setContent(content);
			}
		}
		
		ArrayList<CommunityCommentDTO> cclist = dao.communityComment(seq);
		
		for (CommunityCommentDTO cdto : cclist) {
			regdate = cdto.getRegdate();
			regdate = regdate.substring(0, regdate.length() - 2);
			cdto.setRegdate(regdate);
		}
		
		req.setAttribute("dto", dto); // 부모글
		req.setAttribute("clist", cclist); // 댓글목록

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/community/communityview.jsp");
		dispatcher.forward(req, resp);
	}
}