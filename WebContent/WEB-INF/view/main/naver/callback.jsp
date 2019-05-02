
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<style>

</style>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<%
    String clientId = "ElietkqljUdRUf76Z6Ge";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "qKAYvOsI8U";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8090/Meeting/main/naver/callback.do", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      	
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
        out.println(res.toString()); // JSON 객체 스트링
     // {"access_token":"AAAAOfrIfdk9+Np1H24EIygBMPRoQD/F7uBx8b7+rF+V7/GZpLlYoHhL1A6qT8OB4Gk+rhtPCy5Do9hStIp5Ay9v4WQ=","refresh_token":"iiIj8otvJeliibCrZfAL0QIHdmQX7pAR2gb3UAmHKjip4InlfC2EripOkgOvtLegNJlwET8Zyng7iibipCYr6EQ4ehjYw1keeUV100ou0dCUs1sooIL8nQt0iiXMtgHpcQNSTDx","token_type":"bearer","expires_in":"3600"}
        
     JSONParser parser = new JSONParser();
     JSONObject result = (JSONObject)parser.parse(res.toString());
     
     out.print("<br>"+result.get("access_token"));
     
     session.setAttribute("access_token", result.get("access_token"));
     
     response.sendRedirect("/Meeting/main/naver/naverinfo.do");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  %>
</body>
</html>