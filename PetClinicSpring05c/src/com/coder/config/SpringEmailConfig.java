package com.coder.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SpringEmailConfig {
	public SpringEmailConfig(){
		System.out.println("Spring EMail COnfig ----> 1");
	}
	@Bean(name="mailSender")
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl ms=new JavaMailSenderImpl();
		ms.setHost("smtp.gmail.com");
		ms.setPort(587);
		ms.setUsername("minpyaehein.ucsdawei@gmail.com");
		ms.setPassword("09455836692");
		Properties prop=new Properties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.debug", "true");
		
		ms.setJavaMailProperties(prop);
		
		return ms;
	}
}










