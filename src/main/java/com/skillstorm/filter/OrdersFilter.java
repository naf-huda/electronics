package com.skillstorm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/api/orders")
public class OrdersFilter implements Filter {
	
	
	@Override
	public void destroy() {
		System.out.println("filter destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter FILTER()");
		
		chain.doFilter(request, response);	// forward the req/resp to the intended destination	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init()");
		
	}
}
