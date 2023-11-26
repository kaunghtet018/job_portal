package com.hostmdy.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.hostmdy.model.User;

/**
 * Servlet Filter implementation class AuthenicationFilter
 */
public class AuthenicationFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -2568748240927861308L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenicationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpServletResponse servletResponse = (HttpServletResponse)response;
		
		HttpSession session =servletRequest.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
			if(servletRequest.getRequestURI().endsWith("/resume")||servletRequest.getRequestURI().endsWith("/jobapply")) {
				servletResponse.sendRedirect("login");
			}else {
				
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
