package com.meeting.introduce.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/introduce/mainindexdata.do")
public class MainIndexData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String clientId = "GLPArbhm9AYtSPReIVU4";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "WMIbLpWVsn";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode("연애", "UTF-8");
            //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
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
            
            //XML 형태로 데이터 내보내기
            //	-임시 페이지 작성
            resp.setHeader("Content-type", "text/xml");
            resp.setCharacterEncoding("UTF-8");
            
            resp.getWriter().print(response.toString());
            resp.getWriter().close();
            
            
            //System.out.println(response.toString());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/introduce/mainindexdata.jsp");
		dispatcher.forward(req, resp);
	}
}

