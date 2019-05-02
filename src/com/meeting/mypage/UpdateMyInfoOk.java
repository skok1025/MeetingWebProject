package com.meeting.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.main.LoginDTO;
import com.meeting.mypage.model.MypageDAO;

/**
 * 나의 정보의 수정 성공유무에 대한 Servlet 클래스 
 * @author 김석현
 *
 */
@WebServlet("/mypage/updatemyinfook.do")
public class UpdateMyInfoOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		String cid = req.getParameter("cid"); 
		String cname = req.getParameter("cname");
		String cnick = req.getParameter("cnick");
		String cpw = req.getParameter("cpw");
		String ctel = req.getParameter("ctel");
		String cage = req.getParameter("cage");
		String cheight = req.getParameter("cheight");
		String cability = req.getParameter("cability");
		String csmallhobby = req.getParameter("csmallhobby");
		String cjob = req.getParameter("cjob");
		String cbigarea = req.getParameter("cbigarea");
		String csmallarea = req.getParameter("csmallarea");
		String cintroduce = req.getParameter("cintroduce");
		
		resp.setCharacterEncoding("UTF-8");
		
		System.out.println(csmallarea);
		
		LoginDTO dto = new LoginDTO();
		dto.setId(cid);
		dto.setName(cname);
		dto.setNick(cnick);
		dto.setPw(cpw);
		dto.setTel(ctel);
		dto.setAge(Integer.parseInt(cage));
		dto.setHeight(Integer.parseInt(cheight));
		dto.setAbility(cability);
		dto.setSmallhobby(csmallhobby);//
		dto.setJob(cjob);
		dto.setBigarea(cbigarea);//
		dto.setSmallarea(csmallarea);//
		dto.setIntroduce(cintroduce.replace("\r\n", "<br>"));
		
		MypageDAO dao = new MypageDAO();
		int result = dao.updateInfo(dto);
		session.setAttribute("id", dto.getId());
		session.setAttribute("name", dto.getName());
		session.setAttribute("nick", dto.getNick());
		session.setAttribute("tel", dto.getTel());
		session.setAttribute("age", dto.getAge());
		session.setAttribute("ability", dto.getAbility());
		session.setAttribute("height", dto.getHeight());
		session.setAttribute("job", dto.getJob());
		session.setAttribute("smallhobby", dto.getSmallhobby());
		session.setAttribute("smallarea", dto.getSmallarea());
		session.setAttribute("bigarea", dto.getBigarea());
		session.setAttribute("introduce", dto.getIntroduce());
		
		//int result = 1;
		resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
		
		if(result == 1) { // 성공
			
			resp.getWriter().write("<script>alert('수정 완료했습니다.'); location.href='/Meeting/sample/template.do'</script>");
		} else {
			resp.getWriter().print("<script> alert('수정 실패했습니다.'); history.back(); </script>");
			
		}
		resp.getWriter().println("</head><body></body></html>");
		resp.getWriter().close();
	}

}