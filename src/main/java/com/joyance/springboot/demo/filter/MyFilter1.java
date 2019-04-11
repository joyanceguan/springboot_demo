package com.joyance.springboot.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		System.out.println("过滤器1执行。。。。。。。。。");
		req.setAttribute("t1", "p1");
		filter.doFilter(req, resp);		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
