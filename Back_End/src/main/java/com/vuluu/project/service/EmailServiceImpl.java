package com.vuluu.project.service;

import com.vuluu.project.service.template.IEmailService;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

  @Autowired
  private JavaMailSender emailSender;

  @Override
  public void sendPasswordToEmail(String email, String password) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("vuluudragonslayer@gmail.com");
    message.setTo(email);
    message.setSubject("Your Password Account");
    message.setText("Your password is: " + password);

    try {
      emailSender.send(message);
    } catch (MailException e) {
      // Use a proper logging framework instead of System.err.println
      // log.error("Can't send email", e);
      System.err.println("Can't send email: " + e.getMessage());
    }
  }
}
