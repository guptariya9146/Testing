package com.nagarro.user.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user/*")
public class AddResponseHeaderFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 InetAddress ip;
	     String hostname;
	     ip = InetAddress.getLocalHost();
         hostname = ip.getHostName();
         System.out.println("Your current IP address : " + ip);
         System.out.println("Your current Hostname : " + hostname);

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Hostname",hostname);
		chain.doFilter(request, response);
		System.out.println("Hello");
		// TODO Auto-generated method stub

	}
	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ...
	}

	@Override
	public void destroy() {
		// ...
	}

}
