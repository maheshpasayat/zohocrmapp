package com.zohocrmapp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailServiceImpl implements EmailService {
@Autowired
private JavaMailSender javaMailSender;
	@Override
	public void sendEmail(String to, String sub, String emailBody) {
	     SimpleMailMessage mailMessage
         = new SimpleMailMessage();

     // Setting up necessary details
     mailMessage.setTo(to);
     mailMessage.setSubject(sub);
     mailMessage.setText(emailBody);

     // Sending the mail
     javaMailSender.send(mailMessage);

	}

}
