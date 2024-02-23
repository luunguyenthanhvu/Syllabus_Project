package com.vuluu.project.service;

import com.vuluu.project.service.template.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

  @Autowired
  private JavaMailSender emailSender;

  @Override
  public void sendUserAccount(String email, String username, String password) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("vuluudragonslayer@gmail.com");
    message.setTo(email);
    message.setSubject("[FAMS] - Account Created Successfully");

    // Creating email body with placeholders replaced with specific user information
    String body = "Hi, " + username + ",\n\n"
        + "Your login account for the FAMS system has been created successfully.\n"
        + "Please access the system using the following information:\n\n"
        + "Username: " + email + "\n"
        + "Password: " + password + "\n\n"
        + "Note: Please remember to change your password after logging in.";

    message.setText(body);

    try {
      emailSender.send(message);
    } catch (Exception e) {
      // Handling exception when unable to send email
      System.err.println("Can't send email: " + e.getMessage());
    }
  }
}
