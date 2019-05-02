package com.meeting.main.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.meeting.main.Join;
import com.meeting.main.JoinDAO;

@WebServlet("/main/naver/naverinfo.do")
public class NaverInfo extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 네이버 정보
		 String token = session.getAttribute("access_token").toString();// 네이버 로그인 접근 토큰;
	        String header = "Bearer " + token; // Bearer 다음에 공백 추가
	        try {
	            String apiURL = "https://openapi.naver.com/v1/nid/me";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Authorization", header);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	            
	            // 반환 정보 JSON -> 파싱 -> 원하는 정보만 가져오기
	            JSONParser parser = new JSONParser();
	            JSONObject result = (JSONObject)parser.parse(response.toString());
	            
	           
	            
	            String naverId = (String)  ((JSONObject)result.get("response")).get("email");
	            String naverName = (String)  ((JSONObject)result.get("response")).get("name");
	            String gender = ((String) ((JSONObject)result.get("response")).get("gender")).equals("M") ? "남자":"여자" ;
	            String profileimg = (String) ((JSONObject)result.get("response")).get("profile_image");
	            String nick = (String) ((JSONObject)result.get("response")).get("nickname");
	            
	            System.out.println(naverId);
	            System.out.println(naverName);
	            System.out.println(gender);
	            System.out.println(profileimg);
	            System.out.println(nick);
	            
	            // 기존에 회원가입을 한 네이버 아이디인지 아닌지 여부 확인
	            
	            JoinDAO dao = new JoinDAO();
	            boolean existId = dao.isExistId(naverId);
	            
	            resp.setCharacterEncoding("UTF-8");
	            resp.getWriter().println("<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">");
	            if(!existId) { //  아이디가 없으면 회원가입절차 진행	            	
	            	session.setAttribute("naverName", naverName);
	            	session.setAttribute("naverId", naverId);
	            	session.setAttribute("naverGender", gender);
	            	session.setAttribute("naverImg", profileimg);
	            	session.setAttribute("naverNick", nick);
	            	
	            	 resp.getWriter().write("<script>alert('처음오셨군요~~'); alert('회원가입을 진행할게요!!'); location.href = '/Meeting/main/joinmoreinfo.do';</script>");
	            } else {
	            	session.setAttribute("naverId", naverId);
	            	resp.sendRedirect("/Meeting/main/naver/naverloginok.do");
	            }
	            resp.getWriter().println("</head><body></body></html>");
	            
	            
	           
	           
	        } catch (Exception e) {
				// TODO: handle exception
			}

		

	}

}