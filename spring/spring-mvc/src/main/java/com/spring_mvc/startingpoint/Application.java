package com.spring_mvc.startingpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan // is scanning the current directory/package
@SpringBootApplication//has the same functionality as previous three annotation
@ComponentScan("com.spring_mvc")
public class Application extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
//		return application.sources(Application.class);
//	}
}
