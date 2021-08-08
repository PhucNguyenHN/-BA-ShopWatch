package com.shopwatch.api.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSend {
	
	@Autowired
    public JavaMailSender emailSender;
	
	public void sendMailRegister(String email) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
         
        String htmlMsg = "<h2>Hi, Newbie @.@</h2>"
        		+"<h4>Vui long nhan vao Nut Login de tiep tuc !!!</h4>"
                +"<a href='https://watchshop-44.web.app/index' style='background:#eee;padding:10px 40px;border-radius:5px;text-decoration: none;font-weight: bold;font-size: 26px;'>Login</a>";
         
        message.setContent(htmlMsg, "text/html");
         
        helper.setTo(email);
         
        helper.setSubject("Đăng ký Tài Khoản WatchShop Thành Công!");
         
     
        this.emailSender.send(message);
	}
	
	
}
