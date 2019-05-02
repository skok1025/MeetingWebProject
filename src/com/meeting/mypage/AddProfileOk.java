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
 * 프로필 사진을 등록 후 성공/실패 결과 여부를 반환하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/mypage/addprofileok.do")
public class AddProfileOk extends HttpServlet {

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
		//System.out.println(profileName);
		
		MypageDAO dao = new MypageDAO();
		int result = dao.updateProfileImage(profileName,session.getAttribute("id").toString());
		session.setAttribute("profileimage", profileName);
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		if(result == 1) {
			resp.getWriter().write("<script>alert('프로필 사진 등록 완료'); location.href='/Meeting/mypage/myinfo.do'</script>");
		} else {
			resp.getWriter().write("<script>alert('프로필 사진 등록 실패'); history.back();</script>");
		}
		resp.getWriter().println("</head><body></body></html>");
		resp.getWriter().close();

	}

}
