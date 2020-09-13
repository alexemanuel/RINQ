package com.rinq.services.mail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



public class MailSender{

	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendMail(String address, String subject, String filename) throws MessagingException, IOException{
		
		String mailBody = Files.readString(Paths.get(String.format("src/main/resources/templates/%s", filename)));
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(address);
		helper.setSubject(subject);
		helper.setText(mailBody, true);
		
		javaMailSender.send(message);		
	}
}
