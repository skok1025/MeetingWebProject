package com.meeting.courtship;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.courtship.model.CourtshipDAO;
import com.meeting.courtship.model.CustomerAllDetailDTO;
import com.meeting.courtship.model.ProfileImagesDTO;

@WebServlet("/courtship/profilehome.do")
public class ProfileHome extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      String seq = req.getParameter("seq");
      // 회원  seq
      
      // 프로필 이미지 5개 
      
      CourtshipDAO dao = new CourtshipDAO();
      
      ArrayList<ProfileImagesDTO> imglist = dao.getProfileImg(seq);
      
      CustomerAllDetailDTO dto = dao.detail(seq);
      System.out.println(imglist);
      req.setAttribute("dto", dto);
      req.setAttribute("imglist", imglist);
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/courtship/profilehome.jsp");
      dispatcher.forward(req, resp);
   }
}