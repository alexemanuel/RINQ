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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    SpringMailConfig springMailConfig;
    
    private static final String HTML_PATH = "src/main/resources/templates";
    
    public void sendWelcomeEmail(String recipientName, String recipientEmail) throws MessagingException, IOException {
    	
    	TemplateEngine templateEngine = springMailConfig.emailTemplateEngine();
    	
    	final String fileName = "email-inlineimage.html";
    	
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        
        mimeMessageHelper.setSubject("Bem-Vindo ao RINQ");
        mimeMessageHelper.setFrom("rinq@gmail.com");
        mimeMessageHelper.setTo(recipientEmail);

        final Context context = new Context();
        context.setVariable("name", recipientName);
        
        final String htmlContent = getFileContent(HTML_PATH + "/" + fileName);
        
        final String processedHTML = templateEngine.process(htmlContent, context);
        mimeMessageHelper.setText(processedHTML, true);

        this.mailSender.send(mimeMessage);
    }
    
    private String getFileContent(final String filePath) throws IOException {
    	return Files.readString(Paths.get(filePath));
    }
}