package com.example.demo;


import com.example.demo.knights.Knight;
import com.example.demo.knights.config.KnightConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		Knight knight = context.getBean(Knight.class);
//		knight.embarkOnQuest();
	}

}
