<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
  <style>
  	
  	html{
  		background-color: #FAEFE7;
  	}
  
    body {
      display: flex;
      min-height: 100vh;
      flex-direction: column;
      
    }

    main {
      flex: 1 0 auto;
    }

    

    .input-field input[type=date]:focus + label,
    .input-field input[type=text]:focus + label,
    .input-field input[type=email]:focus + label,
    .input-field input[type=password]:focus + label {
      color: #e91e63;
    }

    .input-field input[type=date]:focus,
    .input-field input[type=text]:focus,
    .input-field input[type=email]:focus,
    .input-field input[type=password]:focus {
      border-bottom: 2px solid #e91e63;
      box-shadow: none;
    }
    
    h1{
    	margin: 0px;
    	padding: 0px;
    }    
    h1 > span{
    	font-weight: bold;
    	font-size: .7em;
    	font-variant: small-caps;
    	color: #DE9391;
    }
    
    #subtitlte{
    	color: #E0808F;
    }
  </style>
   <jsp:include page="/inc/asset.jsp"></jsp:include>
</head>

<body>
  <div class="section"></div>
  <main>
    <center>
      <img class="responsive-img" style="width: 100px; margin-bottom: 0px;" src="/Meeting/images/logo.png" />
      <div class="section"></div>
	  <h1><span>광민</span> <span>愛</span> <span>듀오</span></h1>
      <h5 id="subtitlte">Please, login into your account</h5>
      <div class="section"></div>

      <div class="container">
        <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

          <form class="col s12" method="post" action="/Meeting/main/loginok.do">
            <div class='row'>
              <div class='col s12'>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type="text" name='id' id='id' />
                <label for='id'>Enter your ID</label>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='password' name='password' id='password' />
                <label for='password'>Enter your password</label>
              </div>
              <label style='float: right;'>
					<a class='pink-text' href='#!'><b>Forgot Password?</b></a>
			  </label>
            </div>

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect'
                style="background-color:#DE9391; ">Login</button>
              </div>
            </center>
          </form>
        </div>
      </div>
      <a href="/Meeting/main/join.do">Create account</a>
     
     <!-- 네이버 로그인 -->
     <div style="clear: both;"></div>
     
     <%
    String clientId = "ElietkqljUdRUf76Z6Ge";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8090/Meeting/main/naver/callback.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
  
  <a href="<%=apiURL%>"><img style="height: 50px; margin-top: 10px;" src="/Meeting/images/seokhyun/loginbt.PNG"/></a>
		
 

	<!--  -->
    </center>

    <div class="section"></div>
    <div class="section"></div>
  </main>

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>

</html>