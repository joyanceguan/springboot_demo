package com.joyance.springboot.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Filters {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new MyFilter1());
		registration.addUrlPatterns("/config/*"); //
		registration.addInitParameter("t1", "p1"); //
		registration.setName("myfilter1");
		registration.setOrder(1);
		return registration;
	}
 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean authFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new MyFilter2());
		registration.addUrlPatterns("/hello"); //
		registration.addInitParameter("t2", "p2"); //
		registration.setName("myfilter2");
		registration.setOrder(2);
		return registration;
	}
	
}
