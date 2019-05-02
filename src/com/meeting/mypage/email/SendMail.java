
package com.meeting.mypage.email;

import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import com.meeting.mypage.email.SMTPAuthenticatior;
import javax.mail.Authenticator;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입시, 이메일 인증코드를 전송하는 Servlet 클래스
 * @author 김석현
 *
 */
@WebServlet("/main/sendmail.do")
public class SendMail extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Random rand = new Random();
		
		String code = (rand.nextInt(90000)+10000)+"";
		
		String from = "skok1025@naver.com";
		String to = req.getParameter("to"); // E mail
		String subject = "광민 애 듀오 인증번호입니다.";
		String content = "인증번호 :"+code;
		
		Properties p = new Properties(); // 정보를 담을 객체
		 
		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP
		 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들
		
		try{
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(subject); // 제목
		     
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // 보내는 사람
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
		     
		    Transport.send(msg); // 전송
		    resp.getWriter().write(code);
		    
		} catch(Exception e){
		    e.printStackTrace();
		    // 오류 발생시 뒤로 돌아가도록
		    return;
		}
		
		/*
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main/sendMail.jsp");
		dispatcher.forward(req, resp);
		*/
	}

}