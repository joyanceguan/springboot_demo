package com.joyance.springboot.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
	
	  /**
	   * 表示这些配置的是静态文件所处路径， 不用拦截
	   */
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("/static/**")
	              .addResourceLocations("classpath:/static/");
	      registry.addResourceHandler("/templates/**")
	              .addResourceLocations("classpath:/templates/");
	      super.addResourceHandlers(registry);
	  }
	  
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      // 自定义拦截器，添加拦截路径和排除拦截路径
//	      registry.addInterceptor(xdcsSpringMvcInterceptor()).addPathPatterns("/**");
	      registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/config/*").excludePathPatterns("/config/getbyid*");
	      super.addInterceptors(registry);
	  }
	  
}