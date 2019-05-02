<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
 <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 
<style>
body{
    display: table-cell;
    vertical-align: middle;
    background-color: #FBE3D3 !important;
}

html {
    display: table;
    margin: auto;
}

html, body {
    height: 100%;
}

.medium-small {
    font-size: 0.9rem;
    margin: 0;
    padding: 0;
}

.login-form {
    width: 280px;
}

.login-form-text {
    text-transform: uppercase;
    letter-spacing: 2px;
    font-size: 0.8rem;
}

.login-text {
    margin-top: -6px;
    margin-left: -6px !important;
}

.margin {
    margin: 0 !important;
}

.pointer-events {
    pointer-events: auto !important;
}

.input-field >.material-icons  {
    padding-top:10px;
}

.input-field div.error{
    position: relative;
    top: -1rem;
    left: 3rem;
    font-size: 0.8rem;
    color:#FF4081;
    -webkit-transform: translateY(0%);
    -ms-transform: translateY(0%);
    -o-transform: translateY(0%);
    transform: translateY(0%);
}

#registerbt{
	background-color: #DE9391;
}

.row > span{
	font-size: .8em;
	font-weight: bold;
	margin-left: 60px;
}
	
#emchecktxt{
	color: cornflowerblue;
}	
</style>

<script src="/Meeting/asset/js/jquery-1.12.4.js"></script>
<script src="/Meeting/asset/js/bootstrap.js"></script>
<script src="/Meeting/asset/js/jquery.validate.min.js"></script>

<script>


$(document).ready(function(){
	
	$("#codecheckbt").click(function(){
		//alert($("#realcode").val()); // Real Code
		//alert($("#emcheck").val()); // 내가 입력한 코드
		
		if($("#realcode").val()== $("#emcheck").val()){
			$("#emchecktxt").text("인증 성공!!");
			$("#codecheckbt").attr("disabled","false");
		} else{
			$("#emchecktxt").text("인증 코드를 확인하세요.");
		}
	});
	
	$("#checkembt").click(function(){
		//alert("click");
		
		$.ajax({
			type:"post",
			url:"/Meeting/main/sendmail.do",
			data:"to="+$("#email").val(),
			success:function(result){
				console.log(result);
				alert('메세지를 전송했습니다. 인증코드를 확인해주세요.');
				$("#realcode").val(result);
			},
			error:function(a,b,c){
				console.log(a+b+c);				
			}
		});
	});
	
	

	$("#id").keyup(function(){
		
		
		$.ajax({
			type: "get",
			async: true, // true (비동기), false(동기)
			url: "/Meeting/main/idcheck.do",
			data: "id="+$("#id").val(), // QueryString Get 방식으로 전송되던 형식 동일
			success:function(result){
				
				if(result==1){
					$("#registerbt").attr("disabled","disabled");
					$("#idcheck").text("이미 사용중인 아이디 입니다.");	
					$("#idcheck").css({
						color:"tomato",
						"font-weight":"bold"
					});
				} else{
					if($("#pwcheck").text()=="일치"){
						if($("#emchecktxt").text()== "인증 성공!!"){
							$("#registerbt").removeAttr("disabled");	
						}
					}
					$("#idcheck").text("사용 가능한 아이디입니다!!");
					$("#idcheck").css({
						color:"cornflowerblue",
						"font-weight":"bold"
					});
				}
			},
			error:function(a,b,c){
				console.log(a+b+c);
			}
		})

		
	});
	
	
	$("#password_a").keyup(function(){
		
		if($("#password_a").val() == ""){
			$("#pwcheck").text("");
			return;
		}
		if($("#password_a").val() != $("#password").val()){
			$("#pwcheck").text("비밀번호가 일치하지 않습니다.");
			$("#pwcheck").css({
				color:"tomato",
				"font-weight":"bold"
			});
			
			if($("#emchecktxt").text()!= "인증 성공!!"){
				$("#registerbt").attr("disabled","disabled");
			}
			if($("#emchecktxt").text()== "인증 성공!!" && $("#pwcheck").text() != "비밀번호가 일치하지 않습니다."){
				$("#registerbt").removeAttr("disabled");
			} 
			
		} else{
			if($("#emchecktxt").text()!= "인증 성공!!"){
				$("#registerbt").attr("disabled","disabled");
			} 
			if($("#emchecktxt").text()== "인증 성공!!"){
				$("#registerbt").removeAttr("disabled");
			} 
			
			$("#pwcheck").text("일치");
			$("#pwcheck").css("color","cornflowerblue");
		}
	});
	
	
}); // ready

 

$(".login-form").validate({
	  rules: {
	    username: {
	      required: true,
	      minlength: 4
	    },     
	    id: {
	      required: true,
	      id:true
	    },
	    password: {
	      required: true,
	      minlength: 5
	    },
	    cpassword: {
	      required: true,
	      minlength: 5,
	      equalTo: "#password"
	    }
	  },
	  //For custom messages
	  messages: {
	    username:{
	      required: "Enter a username",
	      minlength: "Enter at least 4 characters"
	    }
	  },
	  errorElement : 'div',
	  errorPlacement: function(error, element) {
	    var placement = $(element).data('error');
	    if (placement) {
	      $(placement).append(error)
	    } else {
	      error.insertAfter(element);
	    }
	  }
}); 
</script>
<link rel="stylesheet" href="/WebClientTest/css/css/basic.css">
</head>
<body>
	<div id="login-page" class="row" >
  <div class="col s12 z-depth-4 card-panel" >
    
    <form class="login-form" method="post" action="/Meeting/main/joinmoreinfo.do">
      <div class="row">
        <div class="input-field col s12 center">
          <h4>Register</h4>
          <p class="center">Join to our community now !</p>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">account_circle</i>
          <input id="username" name="username" type="text"/>
          <label for="username">Username</label>
        </div>
      </div>

      <div class="row margin">
        <div id="id" class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">face</i>
          <input id="id" name="id" type="text" style="cursor: auto;" />
          <label for="id">id</label>
        </div>
        <span id="idcheck"></span>
      </div>
      
      <div class="row margin">
        <div id="id" class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">email</i>
          <input id="email" name="email" type="text" style="cursor: auto;" />
          <label for="email">Email</label>
        </div>
        <span id="emcodetxt"></span><button id="checkembt" onclick="return false"; class="btn waves-effect waves-light" style="float: right; background-color: #DE9391;">인증코드 발송</button>
        <div style="clear: both;"></div>
        <input type="hidden" id="realcode"/>
      </div>
      
      <div class="row margin">
        <div id="id" class="input-field col s12">
          <!-- <i class="mdi-social-person-outline prefix"></i> -->
          <i class="material-icons prefix">done_outline</i>
          <input id="emcheck" name="emcheck" type="text" style="cursor: auto;" />
          <label for="emcheck">인증코드</label>
        </div>
        <span id="emchecktxt"></span><button id="codecheckbt" onclick="return false;" class="btn waves-effect waves-light" style="float: right; background-color: #DE9391;">인증</button>
        <div style="clear: both;"></div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-action-lock-outline prefix"></i> -->
          <i class="material-icons prefix">vpn_key</i>
          <input id="password" name="password" type="password" />
          <label for="password">Password</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="mdi-action-lock-outline prefix"></i> -->
          <i class="material-icons prefix">vpn_key</i>
          <input id="password_a" name="cpassword" type="password" />
          <label for="password_a">Password again</label>
        </div>
        <span id="pwcheck"></span>
      </div>

      <div class="row">
        <div class="input-field col s12">
          <button id="registerbt" type="submit" class="btn waves-effect waves-light col s12" disabled>REGISTER NOW</button>
          
        </div>
        <div class="input-field col s12">
          <p class="margin center medium-small sign-up">Already have an account? <a href="./login.do">Login</a></p>
        </div>
      </div>


    </form>
  </div>
</div>

 <!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
 <script type="text/javascript" src="/Car/js/bootstrap.js"></script>
 <script type="text/javascript" src="/Car/js/jquery-1.12.4.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>

</body>
</html>