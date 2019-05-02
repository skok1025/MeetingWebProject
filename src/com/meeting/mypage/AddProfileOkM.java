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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 매니저가 회원들의 정보를 수정할 경우 진행하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/manager/addprofileok.do")
public class AddProfileOkM extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi = new MultipartRequest(req,
				req.getRealPath("/profile"),
				100*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		String profileName = multi.getFilesystemName("profileim");
		String userid = multi.getParameter("userid");
		
		MypageDAO dao = new MypageDAO();
		
		int result = dao.updateProfileImage(profileName,userid);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if(result == 1) {
			resp.getWriter().write("<script>alert('프로필 사진 등록 완료'); location.href='/Meeting/mypage/manager/userlist.do'</script>");
		} else {
			resp.getWriter().write("<script>alert('프로필 사진 등록 실패'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
		resp.getWriter().close();
	}

}
