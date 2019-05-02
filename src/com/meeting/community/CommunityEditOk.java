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
import com.meeting.community.model.CommunityDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 글 수정 dao 작업 클래스
 * 
 * @author 임광민
 *
 */

@WebServlet("/community/communityeditok.do")
public class CommunityEditOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		try {
			
			req.setCharacterEncoding("UTF-8");
			
			String path = req.getRealPath("/files");

			System.out.println(path);
			int size = 100 * 1024 * 1024;

			MultipartRequest multi = new MultipartRequest(req, path, size, "UTF-8", // getParameter
					new DefaultFileRenamePolicy());

			String seq = multi.getParameter("cseq");
			String kind = multi.getParameter("kind");
			String ccseq = multi.getParameter("category");
			String title = multi.getParameter("title");
			String context = multi.getParameter("context");
			String image = multi.getParameter("image");
			String attach = multi.getParameter("attach");
			
			// + 첨부파일명
			String filename = multi.getFilesystemName("attach");
			String orgfilename = multi.getOriginalFileName("attach");

			// 2.
			CommunityDAO dao = new CommunityDAO();

			CommunityDTO dto = new CommunityDTO();

			System.out.println("title " + title);
			System.out.println("content" + context);
			System.out.println("attach" + attach);
			System.out.println("image" + image);
			System.out.println("kind" + kind);
			System.out.println("ccseq" + ccseq);
			
			System.out.println(session.getAttribute("cseq").toString() +","+ kind +","+ccseq+","+title+","+context+","+image+","+attach);
			
			dto.setSeq(seq);
			dto.setCcseq(ccseq);
			dto.setTitle(title);
			dto.setContent(context);
			dto.setAttach(attach);
			dto.setImage(image);
			dto.setKind(kind);
			dto.setCcseq(ccseq);
			dto.setCseq(session.getAttribute("cseq").toString());
			
			int result = dao.communityEdit(dto); 
			System.out.println(result);
			dao.close();
			
			if (result == 1) {
				resp.sendRedirect("/Meeting/community/communitymanage.do");
			} else {
				resp.getWriter().print("<script>alert('실패');history.back();</script>");
				resp.getWriter().close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}