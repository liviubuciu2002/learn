package com.spring_mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * extinzand WebMvcConfigurerAdapter si aducand adnotarea @Configuration se poate lipsi de web.xml
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//o configurare specifica spring pentru ca view sa fie tehnologia jsp dintre thymeleaf,jsp, freemarker, velocity
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setSuffix(".jsp");
		bean.setPrefix("/WEB-INF/myliviu/");
		bean.setViewClass(JstlView.class);
		registry.viewResolver(bean);
	}
}